package org.sadtech.bot.vcs.bitbucketbot.local.service;

import lombok.NonNull;
import org.sadtech.bot.vcs.bitbucketbot.local.config.property.BitbucketUserProperty;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.notify.Notify;
import org.sadtech.bot.vsc.bitbucketbot.context.service.MessageSendService;
import org.sadtech.social.core.domain.BoxAnswer;
import org.sadtech.social.core.service.sender.Sending;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * // TODO: 17.09.2020 Добавить описание.
 *
 * @author upagge 17.09.2020
 */
@Service
public class MessageSendTelegramService implements MessageSendService {

    private final Sending sending;

    private final BitbucketUserProperty bitbucketUserProperty;

    public MessageSendTelegramService(Sending sending, BitbucketUserProperty bitbucketUserProperty) {
        this.sending = sending;
        this.bitbucketUserProperty = bitbucketUserProperty;
    }

    @Override
    public void send(@NonNull Notify notify) {
        final Set<Long> telegramIds = Collections.singleton(bitbucketUserProperty.getTelegramId());
        telegramIds.forEach(
                telegramId -> sending.send(telegramId, BoxAnswer.of(notify.generateMessage()))
        );
    }

}
