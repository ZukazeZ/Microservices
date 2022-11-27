package org.example.model.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "nt_Username")
@SQLDelete(sql = "UPDATE user SET deleted = TRUE WHERE id = ?")
@Where(clause = "deleted=false")
@Entity
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String email;
    private String age;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleEntity> roles =new ArrayList<>();
}