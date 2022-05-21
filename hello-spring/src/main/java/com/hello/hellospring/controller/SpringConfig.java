package com.hello.hellospring.controller;

import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //이 로직을 호출하여 memberService를 springBean에 등록해줌.
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
        //MemberRepository는 인터페이스. MemoryMemberRepository는 구현체.
        //인터페이스는  new 불가함.
    }

}
