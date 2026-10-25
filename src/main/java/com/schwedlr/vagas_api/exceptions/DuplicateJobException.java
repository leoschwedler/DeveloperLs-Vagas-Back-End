package com.schwedlr.vagas_api.exceptions;

import com.schwedlr.vagas_api.enums.Source;

public class DuplicateJobException extends RuntimeException {
    public DuplicateJobException(Source jobSource, String externalId) {
        super("Job already exists: " + jobSource + " / " + externalId);
    }
}
