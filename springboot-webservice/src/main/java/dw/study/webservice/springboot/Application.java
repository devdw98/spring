package dw.study.webservice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //springboot 자동설정
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 was를 실행
    }
}
