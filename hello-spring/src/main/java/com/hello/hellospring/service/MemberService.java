package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional
public class MemberService {

    private  final MemberRepository memberRepository;

    //MemberService는 MemberRepository가 필요함.
    //Autowired가 되어 있으면 MemberService를 스프링이 생성할 때 springcontainer에 있는 MemberRepository를 넣어줌.
    //지금과 같은 경우에는 MemoryMemberRepository가 구현체로 있으므로 이것을 서비스에 주입을 해줌.
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //    회원가입
    public Long join(Member member) {

//        long start = System.currentTimeMillis();

//        try {
            //같은 이름이 있는 중복 회원X
            validateDuplicateMember(member); //중복회원검증
            memberRepository.save(member);
            return member.getId();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("join =" + timeMs + "ms");
//        }
    }//jpa는 join들어올 때 모든 데이터 변경이 다 트랜젝션 안에서 실행되어야 함

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    //전체 회원 조회
    public List<Member> findMembers() {
//        long start = System.currentTimeMillis();
//        try {
            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers " + timeMs + "ms");
//        }

    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
