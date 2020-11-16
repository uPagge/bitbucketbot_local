FROM openjdk:8-jdk-alpine
MAINTAINER uPagge <upagge@ya.ru>
RUN apk add --no-cache bash && \
    addgroup -S bitbucketbot && \
    adduser -S bitbucketbot -G bitbucketbot && \
    mkdir -p /bot && \
    chown -R bitbucketbot:bitbucketbot /bot
WORKDIR /bot
USER bitbucketbot:bitbucketbot
COPY target/bitbucketbot-local.jar app.jar
VOLUME logs
ENV TELEGRAM_ID=TELEGRAM_ID DATASOURCE_URL=DATASOURCE_URL \
    DATASOURCE_PASSWORD=DATASOURCE_PASSWORD DATASOURCE_USERNAME=DATASOURCE_USERNAME \
    BITBUCKET_LOGIN=BITBUCKET_LOGIN BITBUCKET_TOKEN=BITBUCKET_TOKEN \
    TELEGRAM_BOT_TOKEN=TELEGRAM_BOT_TOKEN TELEGRAM_BOT_USERNAME=TELEGRAM_BOT_USERNAME \
    BITBUCKET_URL=BITBUCKET_URL
ENTRYPOINT java -Dspring.profiles.active=prod -DTELEGRAM_BOT_USERNAME=${TELEGRAM_BOT_USERNAME} \
                    -DTELEGRAM_BOT_TOKEN=$TELEGRAM_BOT_TOKEN \
                    -DTELEGRAM_ID=$TELEGRAM_ID \
                    -DDATASOURCE_URL=$DATASOURCE_URL \
                    -DDATASOURCE_PASSWORD=$DATASOURCE_PASSWORD \
                    -DDATASOURCE_USERNAME=$DATASOURCE_USERNAME \
                    -DBITBUCKET_LOGIN=$BITBUCKET_LOGIN \
                    -DBITBUCKET_TOKEN=$BITBUCKET_TOKEN \
                    -DBITBUCKET_URL=$BITBUCKET_URL \
                    -jar app.jar
