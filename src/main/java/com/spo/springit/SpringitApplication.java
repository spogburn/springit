package com.spo.springit;

import com.spo.springit.domain.Comment;
import com.spo.springit.domain.Link;
import com.spo.springit.repository.CommentRepository;
import com.spo.springit.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LinkRepository linkRepo, CommentRepository commentRepo) {
		return args -> {
			Link link = new Link("Getting started with Spring Boot 2", "https://therealdanvega.com");

			linkRepo.save(link);

			Comment comment = new Comment("This Spring Boot 2 link is awesome,", link);

			commentRepo.save(comment);
			link.addComment(comment);
		};
	}

}
