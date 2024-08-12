package spring.boot.week7day2lap10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.boot.week7day2lap10.ApiResponse.ApiResponse;
import spring.boot.week7day2lap10.Model.JobPost;
import spring.boot.week7day2lap10.Service.JobPostService;

@RestController
@RequestMapping("/api/v1/jop/post")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAllJobPosts() {
        return ResponseEntity.status(200).body(jobPostService.getAllJobPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new ApiResponse("JobPost added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@Valid @RequestBody JobPost jobPost, @PathVariable Integer id, Errors error) {
        if (error.hasErrors()) {
            String message = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (jobPostService.updateJobPost(jobPost, id)) {
            return ResponseEntity.status(200).body(new ApiResponse("JobPost updated successfully"));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("JobPost not found"));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        if (jobPostService.deleteJobPost(id)) {
            return ResponseEntity.status(200).body(new ApiResponse("JobPost deleted successfully"));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse("JobPost not found"));
        }
    }
}
