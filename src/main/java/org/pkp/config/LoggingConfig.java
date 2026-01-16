package org.pkp.config;

import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    public LoggingConfig(LoggingSystem loggingSystem) {
        loggingSystem.setLogLevel("ROOT",LogLevel.DEBUG );
    }
}
