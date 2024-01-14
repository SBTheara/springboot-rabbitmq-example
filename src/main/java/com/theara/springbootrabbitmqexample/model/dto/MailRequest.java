package com.theara.springbootrabbitmqexample.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MailRequest {
    private Set<String> to;
    private Set<String> cc;
    private String subject;
    private String body;
    private String logo;
    private boolean hasAttachment;
}
