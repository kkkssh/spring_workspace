package org.iclass.ex;

//스프링 구성 클래스로, 애플리케이션에서 사용하는 빈을 설정
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.iclass.ex")   //해당패키지의 Component를 모두 bean으로 생성
//@ComponentScan 어노테이션을 사용하여 org.iclass.ex 패키지 내에서 컴포넌트 스캔을 수행하고,
//해당 패키지 내의 클래스를 빈으로 등록
public class ProductConfig {

}
