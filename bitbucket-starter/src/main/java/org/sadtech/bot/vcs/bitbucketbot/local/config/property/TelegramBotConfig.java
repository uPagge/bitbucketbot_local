package org.sadtech.bot.vcs.bitbucketbot.local.config.property;

import org.sadtech.bot.godfather.telegram.config.TelegramPollingConfig;
import org.sadtech.bot.godfather.telegram.listen.EventDistributor;
import org.sadtech.bot.godfather.telegram.listen.EventDistributorImpl;
import org.sadtech.bot.godfather.telegram.listen.TelegramConnect;
import org.sadtech.bot.godfather.telegram.listen.TelegramSender;
import org.sadtech.social.core.repository.impl.local.MailRepositoryList;
import org.sadtech.social.core.service.MailService;
import org.sadtech.social.core.service.impl.MailServiceImpl;
import org.sadtech.social.core.service.sender.Sending;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * TODO: Добавить описание класса.
 *
 * @author upagge [30.01.2020]
 */
@Configuration
@EnableScheduling
public class TelegramBotConfig {

    @Bean
    public MailService messageService() {
        return new MailServiceImpl(new MailRepositoryList());
    }

    @Bean
    public Sending sending(
            TelegramConnect telegramConnect
    ) {
        return new TelegramSender(telegramConnect);
    }

    @Bean
    public TelegramConnect telegramConnect(TelegramPollingConfig telegramConfig) {
        return new TelegramConnect(telegramConfig);
    }

    @Bean
    public EventDistributor eventDistributor(
            TelegramConnect telegramConnect,
            MailService mailService
    ) {
        return new EventDistributorImpl(telegramConnect, mailService);
    }

}
