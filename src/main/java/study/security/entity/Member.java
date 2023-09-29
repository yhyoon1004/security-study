package study.security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String userid;
    private String password;
    @Email
    private String email;
    private String roles;

    public Member(Long id, String userid, String password, String email, String roles){
        this.id = id;
        this.userid =userid;
        this.password =password;
        this.email = email;
        this.roles = roles;
    }
}
