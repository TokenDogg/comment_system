package com.tokendogg.comment_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.MXBean;

@MapperScan(basePackages = {"com.tokendogg.comment_system.mapper"})
@SpringBootApplication
public class CommentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentSystemApplication.class, args);
	}

}
