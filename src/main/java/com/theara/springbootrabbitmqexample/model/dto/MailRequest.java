package com.theara.springbootrabbitmqexample.model.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ParameterObject
public class MailRequest {
    @Parameter(description = "sent mail from", example = "thearaholishit@gmail.com")
    private String from;
    @Parameter(description = "sent mail to", example = "thearaholishit@gmail.com")
    private String to;
    @Parameter(description = "sent mail cc", example = "thearaholishit@gmail.com")
    private String[] cc;
    @Parameter(description = "mail subject")
    private String subject;
    @Parameter(description = "mail body")
    private String body;
}
