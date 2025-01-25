package com.midominio.proyecto_basico.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String name;

    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "El formato del email no es válido")
    private String email;

}
