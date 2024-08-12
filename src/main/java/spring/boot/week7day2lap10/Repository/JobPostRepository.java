package spring.boot.week7day2lap10.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.week7day2lap10.Model.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Integer> {
    JobPost findJobPostsById(Integer id);
}
