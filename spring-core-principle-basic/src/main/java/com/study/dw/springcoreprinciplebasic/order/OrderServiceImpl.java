package com.study.dw.springcoreprinciplebasic.order;

import com.study.dw.springcoreprinciplebasic.discount.DiscountPolicy;
import com.study.dw.springcoreprinciplebasic.discount.FixDixcountPolicy;
import com.study.dw.springcoreprinciplebasic.discount.RateDiscountPolicy;
import com.study.dw.springcoreprinciplebasic.member.Member;
import com.study.dw.springcoreprinciplebasic.member.MemberRepository;
import com.study.dw.springcoreprinciplebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //할인정책 적용 시 이 부분을 변경해야함
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인정책 적용 시 이 부분을 변경해야함
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
