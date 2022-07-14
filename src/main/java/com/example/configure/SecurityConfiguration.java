//package com.example.configure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailServiceImpl userDetailService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests()
//        // "/", "/member/**" 파일에 대한 접근은 무조건 허용
//        .antMatchers("/", "/member/**").permitAll()
//        // board 경로 접근은 인증된 사용자만 허용
//        .antMatchers("/board/**").authenticated();
//
//        // 로그인에 성공하면 글 목록 화면(/board/getBoardList)으로 이동한다.
//        http.formLogin().loginPage("/member.login").defaultSuccessUrl("/board/getBoardList");
//
//        http.userDetailsService(userDetailService);
//    }
//}