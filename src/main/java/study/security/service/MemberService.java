package study.security.service;

import study.security.dto.MemberSignupForm;
import study.security.entity.Member;
import study.security.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> findMember(String userId){
        return memberRepository.findMemberByUserid(userId);
    }

    public Member registerMember(MemberSignupForm memberSignupForm){
        Member savedMember = memberRepository.save(memberSignupForm.toMember());
        return savedMember;
    }
}
