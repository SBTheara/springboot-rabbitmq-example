package com.theara.springbootrabbitmqexample.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MailRequest {
    @NotEmpty(message = "Please input the email for send to")
    private Set<String> to;

    @NotEmpty(message = "Please input the Cc for send")
    private Set<String> cc;

    @NotEmpty(message = "Please input subject")
    private String subject;

    @NotEmpty private String body;

    private String firstname;
    private String lastname;
    private String dateOfSend;
    private String logo;
    private Map<String, String> attachmentPath = new HashMap<>();
}
