package com.example.lap10.Controller;

import com.example.lap10.Model.JobPost;
import com.example.lap10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jop")
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getJobPost() {
        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors ) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body("JobPost Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost(@PathVariable Integer id,@Valid @RequestBody JobPost jobPost, Errors errors ){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobPostService.updateJobPost(id,jobPost);
        if (isUpdated) {
            return ResponseEntity.status(200).body("JobPost Updated");
        }
        return ResponseEntity.status(400).body("JobPost Not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        boolean isDeleted = jobPostService.deleteJobPost(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("JobPost Deleted");
        }
        return ResponseEntity.status(400).body("JobPost Not Found");
    }


}
