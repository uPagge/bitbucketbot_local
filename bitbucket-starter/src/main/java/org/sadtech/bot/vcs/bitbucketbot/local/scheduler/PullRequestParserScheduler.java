package org.sadtech.bot.vcs.bitbucketbot.local.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.sadtech.bot.vsc.context.service.PullRequestParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Позволяет задать время парсинга для ПРов.
 *
 * @author upagge 06.09.2020
 */
@Slf4j
@Service
public class PullRequestParserScheduler {

    private final PullRequestParser pullRequestParser;

    public PullRequestParserScheduler(PullRequestParser pullRequestParser) {
        this.pullRequestParser = pullRequestParser;
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void parsingOldPullRequest() {
        pullRequestParser.parsingOldPullRequest();
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void parsingNewPullRequest() {
        pullRequestParser.parsingNewPullRequest();
    }

}
