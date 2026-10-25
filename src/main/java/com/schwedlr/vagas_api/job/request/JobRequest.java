package com.schwedlr.vagas_api.job.request;

import com.schwedlr.vagas_api.enums.Source;

import java.util.Date;

public record JobRequest(Source jobSource, String externalId, String title, String company, String location,
                         String workplace, String url, Date postedAt) {
}

