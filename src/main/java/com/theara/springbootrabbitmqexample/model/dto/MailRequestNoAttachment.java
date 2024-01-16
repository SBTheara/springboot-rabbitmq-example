package com.theara.springbootrabbitmqexample.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class MailRequestNoAttachment {

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

}
