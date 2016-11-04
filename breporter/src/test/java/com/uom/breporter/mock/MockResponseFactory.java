package com.uom.breporter.mock;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by fotarik on 04/11/2016.
 */
@Component
public class MockResponseFactory {

    private String scenarioId = null;

    public MockResponseFactory() {
    }

    public InputStream getMockInputStream(String rqName) {
        String scenarioExt = scenarioId == null ? "" : "-" + scenarioId;
        String resourcePath = "/mocks/" + rqName + scenarioExt + ".xml";
        InputStream is = this.getClass().getResourceAsStream(resourcePath);

        if (is == null) {
            throw new RuntimeException("Unable to locate mock response: " + resourcePath);
        }

        return is;
    }
}
