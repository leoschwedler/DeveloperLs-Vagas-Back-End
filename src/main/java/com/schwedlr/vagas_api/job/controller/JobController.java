package com.schwedlr.vagas_api.job.controller;


import com.schwedlr.vagas_api.job.mapper.JobMapper;
import com.schwedlr.vagas_api.job.request.JobRequest;
import com.schwedlr.vagas_api.job.response.JobResponse;
import com.schwedlr.vagas_api.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/job")
public class JobController {

    private final JobService service;
    private final JobMapper mapper;
    public JobController(JobService service, JobMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    // CREATE
    @PostMapping(value = "/create")
    public ResponseEntity<JobResponse> create(@RequestBody JobRequest request){
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
            @RequestBody JobRequest request
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
