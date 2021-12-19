package com.study.dw.springcoreprinciplebasic.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
