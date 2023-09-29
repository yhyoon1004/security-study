package study.security.controller;

import study.security.dto.MemberSignupForm;
import study.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SecurityController {
    private final MemberService memberService;

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "root page!!!";
    }

    @PostMapping("/signup")
    public String signupHandle(@RequestBody MemberSignupForm memberSignupForm) {
        memberService.registerMember(memberSignupForm);
        return "signup runned";
    }
    @GetMapping("/user/test")
    public String userTestHandle(){
        return "test OK";
    }
}
