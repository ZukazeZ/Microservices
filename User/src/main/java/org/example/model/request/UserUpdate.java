package org.example.model.request;

import lombok.*;
import org.example.model.entity.UserEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserUpdate {
    @Size(min = 2, max = 100, message = "The length of name must be between 2 and 100 characters.")
    private String name;

    @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    private String age;
    private String previousPassword;
    private String currentPassword;

    public UserEntity toUser() {
        return UserEntity.builder()
                .username(this.name)
                .email(this.email)
                .age(this.age)
                .build();
    }

}
