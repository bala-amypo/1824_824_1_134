import java.util.List;

public interface DailySymptomLogService {

    DailySymptomLog recordLog(DailySymptomLog log);

    List<DailySymptomLog> getLogsByPatient(Long patientId);

    DailySymptomLog getLogById(Long id);
}
