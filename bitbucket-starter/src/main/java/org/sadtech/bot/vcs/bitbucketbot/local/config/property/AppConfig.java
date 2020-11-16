package org.sadtech.bot.vcs.bitbucketbot.local.config.property;

import org.sadtech.bot.godfather.telegram.config.TelegramPollingConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties("telegram-config")
    public TelegramPollingConfig telegramConfig() {
        return new TelegramPollingConfig();
    }

    @Bean
    public ConversionService conversionService(Converter... converters) {
        final DefaultConversionService defaultConversionService = new DefaultConversionService();
        Arrays.stream(converters).forEach(defaultConversionService::addConverter);
        return defaultConversionService;
    }

}
