package com.github.jvanheesch;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.spring31.properties.EncryptablePropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

public class EncryptedPropertySourceFactory implements PropertySourceFactory {
    private static final String PASSWORD = "j22r+yODMj4Ndfewkr/ThoCJFi/N6YnE";

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        return new EncryptablePropertiesPropertySource(
                "encryptedProperties",
                PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.properties")),
                standardPBEStringEncryptor(environmentStringPBEConfig())
        );
    }

    public StandardPBEStringEncryptor standardPBEStringEncryptor(EnvironmentStringPBEConfig environmentStringPBEConfig) {
        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setConfig(environmentStringPBEConfig);
        return standardPBEStringEncryptor;
    }

    public EnvironmentStringPBEConfig environmentStringPBEConfig() {
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndTripleDES");
        environmentStringPBEConfig.setPassword(PASSWORD);
        return environmentStringPBEConfig;
    }
}
