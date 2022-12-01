package org.example.model.entity;

import lombok.*;
import org.example.model.enums.ERoles;

import javax.persistence.*;
@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nt_Roles")
public class RoleEntity {
    @Id
    private Long id;

    private String name;

}
