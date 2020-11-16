package org.sadtech.bot.vcs.bitbucketbot.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(
        basePackages = "org.sadtech.bot.vcs.bitbucketbot.data.jpa"
//        includeFilters = @ComponentScan.Filter(classes = PullRequestsRepositoryJpa.class)
)
@SpringBootApplication(scanBasePackages = "org.sadtech.bot.vcs")
@EntityScan(basePackages = "org.sadtech.bot.vsc.bitbucketbot.context.domain.entity")
public class BotLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotLocalApplication.class, args);
    }

}
