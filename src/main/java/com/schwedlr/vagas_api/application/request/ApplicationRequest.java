package com.schwedlr.vagas_api.application.request;

import jakarta.validation.constraints.NotNull;



public record ApplicationRequest(
        String notes,
        @NotNull
        Long jobId
) {
}

