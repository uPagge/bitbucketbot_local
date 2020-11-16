package org.sadtech.bot.vcs.bitbucketbot.local.domain;

import lombok.Builder;
import lombok.Getter;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.EntityType;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.notify.Notify;
import org.sadtech.bot.vsc.bitbucketbot.context.utils.Smile;

import java.text.MessageFormat;
import java.util.Set;

/**
 * // TODO: 31.10.2020 Добавить описание.
 *
 * @author upagge 31.10.2020
 */
@Getter
public class NewTaskNotify extends Notify {

    private final String pullRequestUrl;
    private final String pullRequestName;
    private final String projectKey;
    private final String repositorySlug;
    private final Integer taskCount;

    @Builder
    public NewTaskNotify(
            Set<String> recipients,
            String pullRequestUrl,
            String pullRequestName,
            String projectKey,
            String repositorySlug,
            Integer taskCount
    ) {
        super(EntityType.PERSON, recipients);
        this.pullRequestUrl = pullRequestUrl;
        this.pullRequestName = pullRequestName;
        this.projectKey = projectKey;
        this.repositorySlug = repositorySlug;
        this.taskCount = taskCount;
    }

    @Override
    public String generateMessage() {
        return MessageFormat.format(
                "{0} *Новые задачи | {4} | {5}*{3}" +
                        "[{1}]({2}){3}Колличество новых задач: {6}",
                Smile.TASK, pullRequestName, pullRequestUrl, Smile.HR, projectKey, repositorySlug, taskCount
        );
    }
}
