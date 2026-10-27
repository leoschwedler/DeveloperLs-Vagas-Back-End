package com.schwedlr.vagas_api.application.response;

import com.schwedlr.vagas_api.enums.Status;
import com.schwedlr.vagas_api.job.response.JobResponse;

public record ApplicationResponse(
        Long id,
        Status status,
        String notes,
        JobResponse job
) {
}
