package com.schwedlr.vagas_api.exception;

public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(Long id) {
        super("Job not found: " + id);
    }
}
