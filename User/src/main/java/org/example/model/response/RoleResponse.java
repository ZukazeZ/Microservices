package org.example.model.response;

import org.example.model.enums.ERoles;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleResponse {
    private String id;
    private ERoles role;

}
