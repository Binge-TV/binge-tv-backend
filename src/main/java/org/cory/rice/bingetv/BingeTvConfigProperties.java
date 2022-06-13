package org.cory.rice.bingetv;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;


@ConfigurationProperties("binge")
public record BingeTvConfigProperties(String apiKey) {
}
