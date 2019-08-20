package io.github.qyvlik.influxdbexample.config.properties;

import org.influxdb.InfluxDB;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

@ConfigurationProperties(prefix = "influxdb")
public class InfluxDBProperties {
    private String url;
    private String username;
    private String password;
    private String database;
    private String retentionPolicy;
    private BatchOptions batch;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getRetentionPolicy() {
        return retentionPolicy;
    }

    public void setRetentionPolicy(String retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
    }

    public BatchOptions getBatch() {
        return batch;
    }

    public void setBatch(BatchOptions batch) {
        this.batch = batch;
    }

    public org.influxdb.BatchOptions buildBatchOptions() {

        org.influxdb.BatchOptions batchOptions = org.influxdb.BatchOptions.DEFAULTS;

        if (this.getBatch().getActions() != null) {
            batchOptions = batchOptions.actions(this.getBatch().getActions());
        }

        if (this.getBatch().getFlushDuration() != null) {
            batchOptions = batchOptions.flushDuration(this.getBatch().getFlushDuration());
        }

        if (this.getBatch().getJitterDuration() != null) {
            batchOptions = batchOptions.jitterDuration(this.getBatch().getJitterDuration());
        }

        if (this.getBatch().getBufferLimit() != null) {
            batchOptions = batchOptions.bufferLimit(this.getBatch().getBufferLimit());
        }

        if (this.getBatch().getPrecision() != null) {
            batchOptions = batchOptions.precision(this.getBatch().getPrecision());
        }

        if (this.getBatch().getConsistency() != null && !"".equalsIgnoreCase(this.getBatch().getConsistency())) {
            batchOptions.consistency(InfluxDB.ConsistencyLevel.valueOf(this.getBatch().getConsistency().toUpperCase()));
        }

        return batchOptions;
    }

    public static class BatchOptions {
        private Integer actions;
        private Integer flushDuration;              // unit : ms
        private Integer jitterDuration;             // unit : ms
        private Integer bufferLimit;
        private TimeUnit precision;
        private String consistency;

        public Integer getActions() {
            return actions;
        }

        public void setActions(Integer actions) {
            this.actions = actions;
        }

        public Integer getFlushDuration() {
            return flushDuration;
        }

        public void setFlushDuration(Integer flushDuration) {
            this.flushDuration = flushDuration;
        }

        public Integer getJitterDuration() {
            return jitterDuration;
        }

        public void setJitterDuration(Integer jitterDuration) {
            this.jitterDuration = jitterDuration;
        }

        public Integer getBufferLimit() {
            return bufferLimit;
        }

        public void setBufferLimit(Integer bufferLimit) {
            this.bufferLimit = bufferLimit;
        }

        public TimeUnit getPrecision() {
            return precision;
        }

        public void setPrecision(TimeUnit precision) {
            this.precision = precision;
        }

        public String getConsistency() {
            return consistency;
        }

        public void setConsistency(String consistency) {
            this.consistency = consistency;
        }
    }

}
