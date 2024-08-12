package spring.boot.week7day2lap10.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.week7day2lap10.Model.JobPost;
import spring.boot.week7day2lap10.Repository.JobPostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public boolean updateJobPost(JobPost jobPost, Integer id) {
        JobPost jp = jobPostRepository.findById(id).orElse(null);
        if (jp == null) {
            return false;
        }
        jp.setTitle(jobPost.getTitle());
        jp.setDescription(jobPost.getDescription());
        jp.setLocation(jobPost.getLocation());
        jp.setSalary(jobPost.getSalary());
        jp.setPostingDate(jobPost.getPostingDate());
        jobPostRepository.save(jp);
        return true;
    }

    public boolean deleteJobPost(Integer id) {
        JobPost jp = jobPostRepository.findById(id).orElse(null);
        if (jp == null) {
            return false;
        }
        jobPostRepository.delete(jp);
        return true;
    }
}
