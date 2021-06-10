package com.study.dw.springcoreprinciplebasic;

import com.study.dw.springcoreprinciplebasic.discount.FixDixcountPolicy;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;
import com.study.dw.springcoreprinciplebasic.member.MemoryMemberRepository;
import com.study.dw.springcoreprinciplebasic.order.OrderService;
import com.study.dw.springcoreprinciplebasic.order.OrderServiceImpl;

//Application 의 환경 구성에 대한 모든 것을 여기서 함
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());// 생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDixcountPolicy());
    }
}
