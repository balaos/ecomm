package com.sample.ecomm.others.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Component;

@Component
@Validated
@ConfigurationProperties(prefix = "app")
public class ValidatedConfig {

    @NotBlank
    private String name;

    @Pattern(regexp = "^[0-9]+\\.[0-9]+\\.[0-9]+$", message = "Version must follow semantic versioning (e.g., 1.0.0)")
    private String version;

    // Getters and Setters
}
