package com.study.dw.springcoreprinciplebasic.discount;

import com.study.dw.springcoreprinciplebasic.member.Grade;
import com.study.dw.springcoreprinciplebasic.member.Member;

public class FixDixcountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
