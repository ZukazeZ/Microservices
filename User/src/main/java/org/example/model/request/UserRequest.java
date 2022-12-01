package org.example.model.request;

import lombok.*;
import org.example.model.entity.UserEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {

        @NotEmpty(message = "The username is required.")
        @Size(min = 8, max = 100, message = "The length of username must be at least 8 character")
        private String username;

        @NotEmpty(message = "The email address is required.")
        @Email(message = "The email address is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
        private String email;

        @NotEmpty(message = "The age is required.")
        private String age;
        @NotEmpty(message = "The password address is required.")
        private String password;

        public UserEntity toUser() {
            return UserEntity.builder()
                    .username(this.username)
                    .email(this.email)
                    .age(this.age)
                    .password(this.password)
                    .build();
        }

    }
