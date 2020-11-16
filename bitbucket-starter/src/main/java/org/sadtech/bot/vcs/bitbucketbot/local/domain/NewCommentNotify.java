package org.sadtech.bot.vcs.bitbucketbot.local.domain;

import lombok.Builder;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.EntityType;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.notify.Notify;
import org.sadtech.bot.vsc.bitbucketbot.context.utils.Smile;

import java.text.MessageFormat;
import java.util.Collections;

/**
 * // TODO: 31.10.2020 Добавить описание.
 *
 * @author upagge 31.10.2020
 */
public class NewCommentNotify extends Notify {

    private final String pullRequestUrl;
    private final String pullRequestName;
    private final String projectKey;
    private final String repositorySlug;
    private final Integer commentCount;

    @Builder
    protected NewCommentNotify(
            String recipients,
            String pullRequestUrl,
            String pullRequestName,
            String projectKey,
            String repositorySlug,
            Integer commentCount
    ) {
        super(EntityType.PERSON, Collections.singleton(recipients));
        this.pullRequestUrl = pullRequestUrl;
        this.pullRequestName = pullRequestName;
        this.projectKey = projectKey;
        this.repositorySlug = repositorySlug;
        this.commentCount = commentCount;
    }

    @Override
    public String generateMessage() {
        return MessageFormat.format(
                "{0} *Новые комментарии | {1} | {2}*{3}" +
                        "[{4}]({5}){3}Количество новых комментариев: {6}",
                Smile.COMMENT, projectKey, repositorySlug, Smile.HR, pullRequestName, pullRequestUrl, commentCount
        );
    }
}
