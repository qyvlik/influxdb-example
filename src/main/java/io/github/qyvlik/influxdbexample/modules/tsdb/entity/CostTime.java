package io.github.qyvlik.influxdbexample.modules.tsdb.entity;

public class CostTime {
    private String measurement;
    private String symbol;
    private Long cost;

    public CostTime() {

    }

    public CostTime(String measurement, String symbol, Long cost) {
        this.measurement = measurement;
        this.symbol = symbol;
        this.cost = cost;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
