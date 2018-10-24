package com.evtimov.landlordapp.backend.config;


import com.evtimov.landlordapp.backend.utils.DateProvider;
import com.evtimov.landlordapp.backend.utils.password.PasswordAgent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

import static java.time.ZoneOffset.UTC;


@Configuration
public class DateConfiguration {

    @Bean
    public PasswordAgent getAgentInstance() {
        return new PasswordAgent();
    }

    @Bean
    public DateProvider getInstance() {
        return new DateProvider();
    }

    @PostConstruct
    public void configure() {
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
    }

}
