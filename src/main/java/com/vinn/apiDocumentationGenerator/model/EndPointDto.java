package com.vinn.apiDocumentationGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EndPointDto {
    private String method;
    private String url;
    private String description;
}
