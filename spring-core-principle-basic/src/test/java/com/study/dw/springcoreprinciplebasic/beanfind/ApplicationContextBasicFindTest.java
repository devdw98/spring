package com.study.dw.springcoreprinciplebasic.beanfind;

import com.study.dw.springcoreprinciplebasic.AppConfig;
import com.study.dw.springcoreprinciplebasic.member.MemberService;
import com.study.dw.springcoreprinciplebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService ms = ac.getBean("memberService", MemberService.class);
//        System.out.println("memberService = " + ms);
//        System.out.println("memberService.getClass() = "+ms.getClass());

        Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){
        MemberService ms = ac.getBean(MemberService.class);
        Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    // instance 타입으로 결정됨 but 거의 사용 안함
    void findBeanByName2(){
        MemberService ms = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(ms).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
//       MemberService xxx =  ac.getBean("xxxxx", MemberService.class);
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }
}
