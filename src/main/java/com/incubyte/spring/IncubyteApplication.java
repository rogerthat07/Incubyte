package com.incubyte.spring;

import com.incubyte.spring.entity.Words;
import com.incubyte.spring.repository.WordsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncubyteApplication {

	@Autowired
	private static WordsRepository wr;

	public static void main(String[] args) {
		SpringApplication.run(IncubyteApplication.class, args);
		wr.save(Words.builder().id(1L).word("word1").build());
	}

}
