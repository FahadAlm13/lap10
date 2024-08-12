package spring.boot.week7day2lap10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.boot.week7day2lap10.ApiResponse.ApiResponse;
import spring.boot.week7day2lap10.Model.JobApplication;
import spring.boot.week7day2lap10.Service.JobApplicationService;

@RestController
@RequestMapping("/api/v1/jopApp")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAllJobApplications() {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApplications());
    }

    @PostMapping("/apply")
    public ResponseEntity applyForJob(@Valid @RequestBody JobApplication jobApplication, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        String result = jobApplicationService.applyForJob(jobApplication);
        if (result.equalsIgnoreCase("Applied for job successfully")) {
            return ResponseEntity.status(200).body(new ApiResponse(result));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse(result));
        }
    }

    @DeleteMapping("/withdraw/{id}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer id) {
        if (jobApplicationService.withdrawJobApplication(id)) {
            return ResponseEntity.status(200).body("Job application withdrawn successfully");
        } else {
            return ResponseEntity.status(404).body("Job application not found");
        }
    }
}
