package com.example.configure;


import com.example.domain.Member;
import com.example.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username).get();
        if (member == null) {
            throw new UsernameNotFoundException(username + " 없음");
        }

        return new User(member.getUsername(),
                "{noop}" + member.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
    }
}
