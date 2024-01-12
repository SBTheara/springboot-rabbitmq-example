package com.theara.springbootrabbitmqexample.model.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ParameterObject
public class MailRequest {
    @Parameter(example = "thearaholishit@gmail.com")
    private Set<String> to;
    @Parameter(example = "thearaholishit@gmail.com")
    private Set<String> cc;
    @Parameter(example = "thearaholishit@gmail.com")
    private String subject;
    private String body;
    private String logo;
}
