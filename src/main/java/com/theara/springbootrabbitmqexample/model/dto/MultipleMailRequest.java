package com.theara.springbootrabbitmqexample.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MultipleMailRequest {
    private List<MailRequest> mailRequestList;
}
