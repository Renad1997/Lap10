package com.example.lap10.Controller;

import com.example.lap10.Model.JobApplication;
import com.example.lap10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/application")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplication() {
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }

    @PostMapping("/add")
    public ResponseEntity addJobApplication(@Valid @RequestBody JobApplication jobApplication, Errors errors ) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body("JobApplication Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApplication(@PathVariable Integer id,@Valid @RequestBody JobApplication jobApplication, Errors errors ){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobApplicationService.updateJobApplication(id,jobApplication);
        if (isUpdated) {
            return ResponseEntity.status(200).body("JobApplication Updated");
        }
        return ResponseEntity.status(400).body("JobApplication Not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id) {
        boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("JobApplication Deleted");
        }
        return ResponseEntity.status(400).body("JobApplication Not Found");
    }

}
