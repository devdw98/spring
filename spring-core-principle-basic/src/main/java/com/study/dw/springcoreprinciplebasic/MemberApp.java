package com.study.dw.springcoreprinciplebasic;

import com.study.dw.springcoreprinciplebasic.member.Grade;
import com.study.dw.springcoreprinciplebasic.member.Member;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember: "+member.getName());
        System.out.println("findMember: "+findMember.getName());
    }
}
