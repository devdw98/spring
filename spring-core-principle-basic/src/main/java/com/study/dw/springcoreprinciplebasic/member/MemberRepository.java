package com.study.dw.springcoreprinciplebasic.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
