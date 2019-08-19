package io.github.qyvlik.influxdbexample.modules.tsdb.service;

import io.github.qyvlik.influxdbexample.modules.tsdb.entity.CostTime;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TSDBService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private InfluxDB influxDB;

    public void saveCostTime(CostTime costTime) {
        Point influxDBPoint = Point.measurement(costTime.getMeasurement())
                // .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("symbol", costTime.getSymbol())
                .addField("cost", costTime.getCost())
                .build();

        influxDB.write(influxDBPoint);
    }

    public void getCostTimeList() {
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM place_order_cost"));
        logger.info("getCostTimeList:{}", queryResult);
    }

}
