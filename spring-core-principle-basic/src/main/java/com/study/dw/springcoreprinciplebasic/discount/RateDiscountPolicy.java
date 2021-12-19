package com.study.dw.springcoreprinciplebasic.discount;

import com.study.dw.springcoreprinciplebasic.member.Grade;
import com.study.dw.springcoreprinciplebasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
