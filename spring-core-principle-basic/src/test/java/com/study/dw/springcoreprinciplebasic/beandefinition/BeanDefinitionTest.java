package com.study.dw.springcoreprinciplebasic.beandefinition;

import com.study.dw.springcoreprinciplebasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {
    //ApplicationContext로 하면 getBeanDefinitionNames()를 쓰지 못함
//    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class); // 팩토리 메서드를 이용하여 빈 등록하는 법

    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml"); //직접 스프링 빈 등록하는 법

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinitionName = "+beanDefinitionName +
                        " beanDefinition = "+beanDefinition);
            }
        }
    }
}
