package com.uom.breporter.config;

import com.uom.breporter.mock.MockBugServiceImpl;
import com.uom.breporter.service.bug.BugService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fotarik on 04/11/2016.
 */
@Configuration
@ComponentScan({"com.uom.breporter.mock"})
public class MockBReporterSpringConfig {
    private static final Logger log = LoggerFactory.getLogger(MockBReporterSpringConfig.class);

    public MockBReporterSpringConfig() {

    }

    @Bean(name = "bugService")
    public BugService bugService() {
        log.debug("Initialize mock crbms service bean");
        return new MockBugServiceImpl();
    }
}
