package org.example.model.request;

import lombok.*;
import org.example.model.enums.ERoles;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class RoleRequest {
    @NotEmpty(message = "Roles please.")
    private ERoles role;
}
