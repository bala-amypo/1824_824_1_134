import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DailySymptomLogServiceImpl implements DailySymptomLogService {

    private final DailySymptomLogRepository repository;

    public DailySymptomLogServiceImpl(DailySymptomLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public DailySymptomLog recordLog(DailySymptomLog log) {

        LocalDate today = LocalDate.now();

        if (log.getLogDate().isAfter(today)) {
            throw new RuntimeException("future date");
        }

        Long patientId = log.getPatient().getId();

        if (repository.existsByPatientIdAndLogDate(patientId, log.getLogDate())) {
            throw new RuntimeException("log already exists for this date");
        }

        return repository.save(log);
    }

    @Override
    public List<DailySymptomLog> getLogsByPatient(Long patientId) {
        return repository.findByPatientIdOrderByLogDateDesc(patientId);
    }

    @Override
    public DailySymptomLog getLogById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("log not found"));
    }
}
