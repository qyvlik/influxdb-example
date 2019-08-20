package io.github.qyvlik.influxdbexample.modules.tsdb.service;

import io.github.qyvlik.influxdbexample.modules.tsdb.entity.CostTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TSDBServiceTest {
    @Test
    public void showRP() throws Exception {
        tsdbService.showRP();
    }

    @Test
    public void getCostTimeList() throws Exception {
        tsdbService.getCostTimeList();
    }

    @Autowired
    private TSDBService tsdbService;

    @Test
    public void saveCostTime() throws Exception {
        CostTime costTime = new CostTime();
        costTime.setMeasurement("place_order_elapsed");
        costTime.setSymbol("btc-usdt");
        costTime.setCost(100L);

        tsdbService.saveCostTime(costTime);
    }

}