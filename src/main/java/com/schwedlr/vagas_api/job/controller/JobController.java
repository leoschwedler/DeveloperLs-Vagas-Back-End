package com.schwedlr.vagas_api.job.controller;



import com.schwedlr.vagas_api.job.request.JobRequest;
import com.schwedlr.vagas_api.job.response.JobResponse;
import com.schwedlr.vagas_api.job.service.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job")
public class JobController {

    private final JobService service;
    public JobController(JobService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping(value = "/create")
    public ResponseEntity<JobResponse> create(@Valid @RequestBody JobRequest request){
        JobResponse jobResponse = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobResponse);
    }

    // READ ALL
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<JobResponse>> findAll(){
        return  ResponseEntity.ok(service.findAll());
    }

    // READ BY ID
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<JobResponse> findById(@PathVariable Long id){
        return  ResponseEntity.ok(service.findById(id));
    }

    // UPDATE
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<JobResponse> update (
            @PathVariable Long id,
            @Valid @RequestBody JobRequest request
    ){
        return ResponseEntity.ok(service.update(id,request));
    }

    // DELETE
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
