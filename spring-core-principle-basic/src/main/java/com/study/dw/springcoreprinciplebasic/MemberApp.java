package com.study.dw.springcoreprinciplebasic;

import com.study.dw.springcoreprinciplebasic.member.Grade;
import com.study.dw.springcoreprinciplebasic.member.Member;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext; //spring container(객체 모든 걸 관리)
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // Spring으로 바꾸기
        // AppConfig class에 있는 설정 정보를 가지고 spring이 @Bean에다가 관리해줌
        // 인터페이스                                구현체
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링 컨테이너 생성

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember: "+member.getName());
        System.out.println("findMember: "+findMember.getName());
    }
}
