package com.example.lap10.Service;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Repository.JobApplicationRepository;
import com.example.lap10.Repository.JobPostRepository;
import com.example.lap10.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getJobApplication() {
        return jobApplicationRepository.findAll();
    }

    public boolean addJobApplication(JobApplication jobApplication) {
        if (userRepository.existsById(jobApplication.getUserId())){
            if (jobPostRepository.existsById(jobApplication.getJobPostId())){
                jobApplicationRepository.save(jobApplication);
                return true;
            }
        }
        return false;
    }

    public boolean updateJobApplication(Integer id , JobApplication jobApplication) {
        JobApplication ja = jobApplicationRepository.getById(id);
        if(ja==null) {
            return false;
        }
        ja.setUserId(jobApplication.getUserId());
        ja.setJobPostId(jobApplication.getJobPostId());
        jobApplicationRepository.save(ja);
        return true;
    }
    public boolean deleteJobApplication(Integer id) {
        JobApplication ja = jobApplicationRepository.getById(id);
        if(ja==null) {
            return false;
        }
        jobApplicationRepository.delete(ja);
        return true;
    }

}
