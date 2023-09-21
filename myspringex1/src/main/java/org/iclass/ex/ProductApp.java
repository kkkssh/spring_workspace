package org.iclass.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.extern.slf4j.Slf4j;

//로그 출력을 위해 SLF4J 라이브러리를 사용
@Slf4j
public class ProductApp {
//	private static final Logger logger = LoggerFactory.getLogger(ProductApp.class);
	
	//main 메소드를 포함하고 있는 애플리케이션의 진입점
	public static void main(String[] args) {
		//AnnotationConfigApplicationContext를 사용하여 스프링 컨테이너를 초기화
		ApplicationContext context
		= new AnnotationConfigApplicationContext(ProductConfig.class);
				
		//스프링 컨테이너에서 ProductDao와 ProductService 빈을 가져와 각각의 product 메소드를 호출
		ProductDao dao = context.getBean(ProductDao.class);
		dao.product();
		System.out.println("\n");
		ProductService service = context.getBean(ProductService.class);
		service.product();
		log.info("org.iclass 패키지의 로그 수준은 log4j.xml 에서 level 태그 값으로 설정합니다.");
//		log.debug("debug 메소드 실행은 org.iclass 패키지 로그 출력 수준이 degug 이하 일때 나옵니다.");
//		log.info("info 메소드 실행은 org.iclass 패키지 로그 출력 수준이 info 이하 일때 나옵니다.");
//		로그 레벨  trace -> debug -> info -> warn -> error
		
		((AbstractApplicationContext) context).close();
	}

}
