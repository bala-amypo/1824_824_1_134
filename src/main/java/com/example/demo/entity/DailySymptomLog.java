import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "daily_symptom_logs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"patient_id", "log_date"})
        }
)
public class DailySymptomLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private PatientProfile patient;

    @Column(name = "log_date", nullable = false)
    private LocalDate logDate;

    private Integer painLevel;
    private Integer mobilityLevel;
    private Integer fatigueLevel;

    private String notes;

    private LocalDateTime submittedAt;

    @PrePersist
    public void onSubmit() {
        submittedAt = LocalDateTime.now();
    }

    // getters & setters
}
