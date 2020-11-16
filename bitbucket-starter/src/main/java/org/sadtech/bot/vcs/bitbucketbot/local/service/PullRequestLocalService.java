package org.sadtech.bot.vcs.bitbucketbot.local.service;

import lombok.NonNull;
import org.sadtech.bot.vcs.bitbucketbot.local.domain.NewCommentNotify;
import org.sadtech.bot.vcs.bitbucketbot.local.domain.NewTaskNotify;
import org.sadtech.bot.vcs.core.config.properties.RatingProperty;
import org.sadtech.bot.vcs.core.service.impl.PullRequestsServiceImpl;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.entity.PullRequest;
import org.sadtech.bot.vsc.bitbucketbot.context.domain.filter.PullRequestFilter;
import org.sadtech.bot.vsc.bitbucketbot.context.repository.PullRequestsRepository;
import org.sadtech.bot.vsc.bitbucketbot.context.service.NotifyService;
import org.sadtech.bot.vsc.bitbucketbot.context.service.PullRequestsService;
import org.sadtech.bot.vsc.bitbucketbot.context.service.RatingService;
import org.sadtech.haiti.filter.FilterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * // TODO: 31.10.2020 Добавить описание.
 *
 * @author upagge 31.10.2020
 */
@Primary
@Service
public class PullRequestLocalService extends PullRequestsServiceImpl implements PullRequestsService {

    public PullRequestLocalService(
            PullRequestsRepository pullRequestsRepository,
            NotifyService notifyService,
            RatingService ratingService,
            @Qualifier("pullRequestFilterService") FilterService<PullRequest, PullRequestFilter> pullRequestsFilterService,
            RatingProperty ratingProperty
    ) {
        super(pullRequestsRepository, notifyService, ratingService, pullRequestsFilterService, ratingProperty);
    }

    @Override
    public PullRequest update(@NonNull PullRequest pullRequest) {
        final PullRequest oldPullRequest = findAndFillId(pullRequest);

        forgottenNotification(oldPullRequest);

        newCommentNotify(oldPullRequest, pullRequest);
        taskNotify(oldPullRequest, pullRequest);
        oldPullRequest.setTitle(pullRequest.getTitle());
        oldPullRequest.setDescription(pullRequest.getDescription());
        oldPullRequest.setOpenTaskCount(pullRequest.getOpenTaskCount());
        oldPullRequest.setCommentCount(pullRequest.getCommentCount());
        oldPullRequest.setResolvedTaskCount(pullRequest.getResolvedTaskCount());

        updateReviewers(oldPullRequest, pullRequest);
        oldPullRequest.setUpdateDate(pullRequest.getUpdateDate());
        updateBitbucketVersion(oldPullRequest, pullRequest);
        updateStatus(oldPullRequest, pullRequest);
        updateConflict(oldPullRequest, pullRequest);

        return pullRequestsRepository.save(oldPullRequest);
    }

    private void taskNotify(PullRequest oldPullRequest, PullRequest pullRequest) {
        if (pullRequest.getOpenTaskCount() > oldPullRequest.getOpenTaskCount()) {
            notifyService.send(
                    NewTaskNotify.builder()
                            .recipients(Collections.singleton(oldPullRequest.getAuthorLogin()))
                            .projectKey(oldPullRequest.getProjectKey())
                            .repositorySlug(oldPullRequest.getRepositorySlug())
                            .pullRequestName(pullRequest.getTitle())
                            .pullRequestUrl(oldPullRequest.getUrl())
                            .taskCount(pullRequest.getOpenTaskCount() - oldPullRequest.getOpenTaskCount())
                            .build()
            );
        }
    }

    private void newCommentNotify(PullRequest oldPullRequest, PullRequest pullRequest) {
        if (pullRequest.getCommentCount() > oldPullRequest.getCommentCount()) {
            notifyService.send(
                    NewCommentNotify.builder()
                            .recipients(oldPullRequest.getAuthorLogin())
                            .projectKey(oldPullRequest.getProjectKey())
                            .pullRequestName(pullRequest.getTitle())
                            .pullRequestUrl(oldPullRequest.getUrl())
                            .repositorySlug(oldPullRequest.getRepositorySlug())
                            .commentCount(pullRequest.getCommentCount() - oldPullRequest.getCommentCount())
                            .build()
            );
        }
    }

}
