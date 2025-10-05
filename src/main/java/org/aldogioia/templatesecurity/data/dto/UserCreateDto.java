package org.aldogioia.templatesecurity.data.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateDto {
    @NotNull
    @Size(min = 3, max = 50, message = "Lo username deve essere compreso tra 3 e 50 caratteri")
    private String username;

    @NotNull
    @Email
    private String email;

    // todo non so se la regex va bene
    @NotNull
    @Pattern(regexp = "^(?=.*[!@#])(?=.*\\d).{8,}$", message = "La password deve avere almeno 8 caratteri, almeno un numero e almeno uno tra i caratteri speciali !@#")
    private String password;
}
