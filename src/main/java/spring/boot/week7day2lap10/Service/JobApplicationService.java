package spring.boot.week7day2lap10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week7day2lap10.ApiResponse.ApiResponse;
import spring.boot.week7day2lap10.Model.JobApplication;
import spring.boot.week7day2lap10.Repository.JobApplicationRepository;
import spring.boot.week7day2lap10.Repository.JobPostRepository;
import spring.boot.week7day2lap10.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public String applyForJob(JobApplication jobApplication) {
        if (userRepository.findUserById(jobApplication.getUserId())!=null&& jobPostRepository.findJobPostsById(jobApplication.getJobPostId())!=null){
            jobApplicationRepository.save(jobApplication);
            return "Applied for job successfully";
        }
        return "not found";

    }

    public boolean withdrawJobApplication(Integer id) {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElse(null);
        if (jobApplication == null) {
            return false;
        }
        jobApplicationRepository.delete(jobApplication);
        return true;
    }
}
