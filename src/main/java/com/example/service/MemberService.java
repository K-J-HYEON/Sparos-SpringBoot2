package com.example.service;
import com.example.domain.Member;
import com.example.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getMember(Member member) {
        Optional<Member> findMember = memberRepository.findById(member.getUsername());
        if (findMember.isPresent())
            return findMember.get();
        else
            return null;
    }
}
