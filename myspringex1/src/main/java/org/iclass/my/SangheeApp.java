package org.iclass.my;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import lombok.extern.slf4j.Slf4j;

public class SangheeApp {
//	private static final Logger logger = LoggerFactory.getLogger(ProductApp.class);

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SangheeConfig.class);
		
		SangheeController controller = context.getBean(SangheeController.class);
		int result = controller.product();
		System.out.println("result = " + result);

		((AbstractApplicationContext) context).close();
	}

}
