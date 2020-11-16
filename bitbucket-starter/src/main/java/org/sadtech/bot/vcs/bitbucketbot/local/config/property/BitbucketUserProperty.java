package org.sadtech.bot.vcs.bitbucketbot.local.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * // TODO: 25.10.2020 Добавить описание.
 *
 * @author upagge 25.10.2020
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "bitbucketbot-local.user")
public class BitbucketUserProperty {

    private String login;
    private String token;
    private Long telegramId;

}
