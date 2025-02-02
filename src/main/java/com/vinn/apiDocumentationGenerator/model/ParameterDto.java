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
public class ParameterDto {
    private String name;
    private String type;
    private boolean required;
    private String description;
    private List<NestedFieldDto> nestedFields;
}
