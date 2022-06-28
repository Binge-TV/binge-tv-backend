package org.cory.rice.bingetv;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("binge")
//record to map apikey in secrets.properties to hide secure info
public record BingeTvConfigProperties(String apiKey) {
}
