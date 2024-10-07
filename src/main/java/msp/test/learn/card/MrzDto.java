package msp.test.learn.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MrzDto {

    private String cardCode;
    private String issuingCountry;
    private String documentNumber;
    private LocalDateTime dob;
    private String gender;
    private LocalDateTime expiryDate;
    private String surName;
    private String firstName;
}
