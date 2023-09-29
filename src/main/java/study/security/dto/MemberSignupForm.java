package study.security.dto;

import study.security.entity.Member;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class MemberSignupForm {
    private String id;
    private String password;
    @Email
    private String email;
    private String role;

    public Member toMember(){
        return new Member(null,this.id,this.password,this.email,this.role);
    }

}
