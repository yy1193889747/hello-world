package com.ocly.task;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ocly
 * @date 2018/1/21 17:27
 */

@Log4j2
@Component
public class Task {

    @Scheduled(fixedRate = 5000)
    public void logs() {
        log.info("hello world");
        log.error("byebye world");
    }
}
