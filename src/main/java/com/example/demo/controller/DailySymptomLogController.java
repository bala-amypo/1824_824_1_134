import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class DailySymptomLogController {

    private final DailySymptomLogService service;

    public DailySymptomLogController(DailySymptomLogService service) {
        this.service = service;
    }

    @PostMapping
    public DailySymptomLog createLog(@RequestBody DailySymptomLog log) {
        return service.recordLog(log);
    }

    @GetMapping("/patient/{patientId}")
    public List<DailySymptomLog> getLogsByPatient(@PathVariable Long patientId) {
        return service.getLogsByPatient(patientId);
    }

    @GetMapping("/{id}")
    public DailySymptomLog getLogById(@PathVariable Long id) {
        return service.getLogById(id);
    }
}
