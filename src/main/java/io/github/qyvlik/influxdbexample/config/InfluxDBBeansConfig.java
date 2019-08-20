package io.github.qyvlik.influxdbexample.config;

import io.github.qyvlik.influxdbexample.config.properties.InfluxDBProperties;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(InfluxDBProperties.class)
public class InfluxDBBeansConfig {

    private InfluxDBProperties properties;

    public InfluxDBBeansConfig(InfluxDBProperties properties) {
        this.properties = properties;
    }

    @Bean
    public InfluxDB influxDB() {
        InfluxDB influxDB = InfluxDBFactory.connect(
                properties.getUrl(),
                properties.getUsername(),
                properties.getPassword());
        influxDB.setDatabase(properties.getDatabase());

        if (properties.getRetentionPolicy() != null && !"".equalsIgnoreCase(properties.getRetentionPolicy())) {
            influxDB.setRetentionPolicy(properties.getRetentionPolicy());
        }

        // Flush every 2000 Points, at least every 100ms
        // influxDB.enableBatch(BatchOptions.DEFAULTS.actions(2000).flushDuration(100));

        influxDB.enableBatch(properties.buildBatchOptions());

        return influxDB;
    }
}
