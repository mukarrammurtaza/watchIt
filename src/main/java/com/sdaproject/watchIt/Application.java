package com.sdaproject.watchIt;

import com.sdaproject.watchIt.Admin.AdminRepository;
import com.sdaproject.watchIt.police.PoliceRepository;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@ComponentScan({ "com.sdaproject.watchIt.MainController","controller","service"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
		UserRepository policeRepo = configurableApplicationContext.getBean(PoliceRepository.class);
		UserRepository adminRepo = configurableApplicationContext.getBean(AdminRepository.class);
	}

}
