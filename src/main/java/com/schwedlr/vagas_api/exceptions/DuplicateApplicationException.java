package com.schwedlr.vagas_api.exceptions;

public class DuplicateApplicationException extends RuntimeException {
    public DuplicateApplicationException(Long jobId) {
        super("An application already exists for job: " + jobId);
    }
}
