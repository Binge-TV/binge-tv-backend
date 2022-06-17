package org.cory.rice.bingetv;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("binge")
public record BingeTvConfigProperties(String apiKey) {
}
