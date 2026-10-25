package com.schwedlr.vagas_api.job.request;

import com.schwedlr.vagas_api.enums.Source;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record JobRequest(
        @NotNull
        Source jobSource,
        @NotBlank
        @Size(max = 100)
        String externalId,
        @NotBlank
        @Size(max = 255)
        String title,
        @NotBlank
        @Size(max = 255)
        String company,
        @Size(max = 255)
        String location,
        @Size(max = 20)
        String workplace,
        @NotBlank
        String url,
        Date postedAt
) {
}

