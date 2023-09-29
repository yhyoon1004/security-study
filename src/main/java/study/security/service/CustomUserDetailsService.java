package study.security.service;

import study.security.entity.Member;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberService memberService;

    public CustomUserDetailsService(MemberService memberService){
        this.memberService=memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findMember = memberService.findMember(username);
        Member member = findMember.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다."));

        return User.builder()
                .username(member.getUserid())
                .password(member.getPassword())
                .roles(member.getRoles())
                .build();
    }
}
