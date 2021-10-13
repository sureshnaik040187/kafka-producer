package com.snaik.task;

import com.snaik.dao.QueryExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DbTask {

    @Autowired
    private QueryExecutor queryExecutor;

    @Scheduled(fixedRate = 20000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);
        queryExecutor.executeQuery();
    }
}
