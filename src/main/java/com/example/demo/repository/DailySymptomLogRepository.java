import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface DailySymptomLogRepository extends JpaRepository<DailySymptomLog, Long> {

    boolean existsByPatientIdAndLogDate(Long patientId, LocalDate logDate);

    List<DailySymptomLog> findByPatientIdOrderByLogDateDesc(Long patientId);
}
