package com.schwedlr.vagas_api.job.response;

import com.schwedlr.vagas_api.enums.Source;


import java.time.LocalDate;

public record JobResponse(Long id, Source jobSource, String externalId, String title, String company, String location,
                          String workplace, String url, LocalDate postedAt) {
}
