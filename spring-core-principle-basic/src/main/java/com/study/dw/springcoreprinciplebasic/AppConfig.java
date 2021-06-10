package com.study.dw.springcoreprinciplebasic;

import com.study.dw.springcoreprinciplebasic.discount.DiscountPolicy;
import com.study.dw.springcoreprinciplebasic.discount.FixDixcountPolicy;
import com.study.dw.springcoreprinciplebasic.member.MemberRepository;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;
import com.study.dw.springcoreprinciplebasic.member.MemoryMemberRepository;
import com.study.dw.springcoreprinciplebasic.order.OrderService;
import com.study.dw.springcoreprinciplebasic.order.OrderServiceImpl;

//Application 의 환경 구성에 대한 모든 것을 여기서 함
public class AppConfig {
    // 역할
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());// 생성자 주입
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    //구현
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        return new FixDixcountPolicy();
    }
}
