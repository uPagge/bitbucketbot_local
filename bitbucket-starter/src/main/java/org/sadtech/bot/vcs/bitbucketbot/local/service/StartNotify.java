package org.sadtech.bot.vcs.bitbucketbot.local.service;

import lombok.RequiredArgsConstructor;
import org.sadtech.bot.vcs.bitbucketbot.local.config.property.BitbucketUserProperty;
import org.sadtech.bot.vcs.core.config.properties.AppProperty;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.notify.SimpleTextNotify;
import org.sadtech.bot.vsc.bitbucketbot.context.service.NotifyService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * Компонент отправляет сообщение при старте бота.
 *
 * @author upagge 06.11.2020
 */
@Component
@RequiredArgsConstructor
public class StartNotify {

    private final NotifyService notifyService;
    private final BitbucketUserProperty userProperty;
    private final AppProperty appProperty;

    @PostConstruct
    public void sendStartNotification() {
        notifyService.send(
                SimpleTextNotify.builder()
                        .recipients(Collections.singleton(userProperty.getLogin()))
                        .message("Привет! Желаю продуктивного кодинга :)" +
                                "\n-- -- -- -- --\n" +
                                "_Version " + appProperty.getVersion() + " | Developer @uPagge_")
                        .build()
        );
    }

}
