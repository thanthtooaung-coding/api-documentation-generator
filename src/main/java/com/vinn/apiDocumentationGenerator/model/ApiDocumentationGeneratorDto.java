package com.vinn.apiDocumentationGenerator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiDocumentationGeneratorDto {
    private String apiName;
    private String apiVersion;
    private String apiDescription;
    private List<EndPointDto> endPoints;
}
