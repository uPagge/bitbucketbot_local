package org.sadtech.bot.vcs.bitbucketbot.local.service;

import lombok.NonNull;
import org.sadtech.bot.vcs.bitbucketbot.local.config.property.BitbucketUserProperty;
import org.sadtech.bot.vcs.core.config.properties.BitbucketProperty;
import org.sadtech.bot.vcs.bitbucket.core.AbstractPullRequestBitbucketParser;
import org.sadtech.bot.vsc.bitbucketbot.context.service.PullRequestsService;
import org.sadtech.bot.vsc.context.service.PullRequestParser;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * // TODO: 25.10.2020 Добавить описание.
 *
 * @author upagge 25.10.2020
 */
@Service
public class BitbucketPullRequestParser extends AbstractPullRequestBitbucketParser implements PullRequestParser {

    private final BitbucketUserProperty bitbucketUserProperty;
    private final BitbucketProperty bitbucketProperty;

    protected BitbucketPullRequestParser(
            PullRequestsService pullRequestsService,
            ConversionService conversionService,
            BitbucketUserProperty bitbucketUserProperty,
            BitbucketProperty bitbucketProperty
    ) {
        super(pullRequestsService, conversionService);
        this.bitbucketUserProperty = bitbucketUserProperty;
        this.bitbucketProperty = bitbucketProperty;
    }

    @Override
    protected Set<Long> getExistsPullRequestIds(@NonNull String bitbucketUrl) {
        return updateOldPullRequests(bitbucketUrl, bitbucketUserProperty.getToken());
    }

    @Override
    public void parsingOldPullRequest() {
        processingOldPullRequests(bitbucketProperty.getUrlPullRequestOpen(), bitbucketProperty.getUrlPullRequestClose());
    }

    @Override
    public void parsingNewPullRequest() {
        createNewPullRequest(bitbucketProperty.getUrlPullRequestOpen(), bitbucketUserProperty.getToken());
    }

}
