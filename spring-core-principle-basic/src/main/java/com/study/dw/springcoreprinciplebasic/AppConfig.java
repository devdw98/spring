package com.study.dw.springcoreprinciplebasic;

import com.study.dw.springcoreprinciplebasic.discount.DiscountPolicy;
import com.study.dw.springcoreprinciplebasic.discount.FixDixcountPolicy;
import com.study.dw.springcoreprinciplebasic.discount.RateDiscountPolicy;
import com.study.dw.springcoreprinciplebasic.member.MemberRepository;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;
import com.study.dw.springcoreprinciplebasic.member.MemoryMemberRepository;
import com.study.dw.springcoreprinciplebasic.order.OrderService;
import com.study.dw.springcoreprinciplebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { //Application 의 환경 구성에 대한 모든 것을 여기서 함 (설정정보)

    // 역할
    @Bean // spring container에 등록이 됨
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());// 생성자 주입
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    //구현
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDixcountPolicy();
        return new RateDiscountPolicy(); //할인정책 변경
    }
}
