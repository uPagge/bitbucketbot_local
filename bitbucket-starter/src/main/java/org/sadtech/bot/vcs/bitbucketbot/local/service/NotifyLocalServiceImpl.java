package org.sadtech.bot.vcs.bitbucketbot.local.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sadtech.bot.vcs.bitbucketbot.local.config.property.BitbucketUserProperty;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.entity.NotifySetting;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.notify.Notify;
import org.sadtech.bot.vsc.bitbucketbot.context.service.MessageSendService;
import org.sadtech.bot.vsc.bitbucketbot.context.service.NotifyService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * // TODO: 26.10.2020 Добавить описание.
 *
 * @author upagge 26.10.2020
 */
@Primary
@Service
@RequiredArgsConstructor
public class NotifyLocalServiceImpl implements NotifyService {

    private final MessageSendService messageSendService;
    private final BitbucketUserProperty bitbucketUserProperty;

    @Override
    public <T extends Notify> void send(T notify) {
        if (notify.getRecipients().contains(bitbucketUserProperty.getLogin())) {
            messageSendService.send(notify);
        }
    }

    @Override
    public void saveSettings(@NonNull NotifySetting setting) {
        throw new IllegalStateException();
    }

    @Override
    public Optional<NotifySetting> getSetting(@NonNull String login) {
        return Optional.empty();
    }

}
