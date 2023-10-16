package com.example.data;

import com.example.data.dto.UserSearchDto;
import com.example.data.service.OrderService;
import com.example.data.service.ProductService;
import com.example.data.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Date;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.data.entity"})
public class SpringDataApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringDataApplication.class, args);
		var request = UserSearchDto.builder()
				//.birthDate(Date.valueOf("1952-06-02"))
				.gender("M")
				.experience(50)
				//.firstName("ana")
				.pageNumber(6)

				.build();
		//context.getBean(UserService.class).searchUser(request);
		context.getBean(UserService.class).searchUserWithPaging(request);
	}

}
