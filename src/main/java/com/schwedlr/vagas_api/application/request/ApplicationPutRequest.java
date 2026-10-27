package com.schwedlr.vagas_api.application.request;

import com.schwedlr.vagas_api.enums.Status;
import jakarta.validation.constraints.NotNull;

public record ApplicationPutRequest(
        String notes,
        @NotNull
        Status status
) {
}
