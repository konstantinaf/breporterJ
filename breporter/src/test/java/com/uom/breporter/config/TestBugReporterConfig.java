package com.uom.breporter.config;

import com.uom.breporter.service.bug.BugService;
import com.uom.breporter.service.bug.impl.BugServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fotarik on 04/11/2016.
 */
@Configuration
public class TestBugReporterConfig {

    @Bean(name = "bugService")
    public BugService bugService() {
        BugService bugService = new BugServiceImpl();
        return bugService;
    }
}
