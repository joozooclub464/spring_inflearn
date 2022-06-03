package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //구현체가 하나만 있을 경우 뒤에 Impl이라고 많이 씀(관례상)

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }



}
