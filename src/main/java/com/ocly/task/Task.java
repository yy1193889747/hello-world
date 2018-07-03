package com.ocly.task;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Message;
import com.dianping.cat.message.Transaction;
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

    @Scheduled(fixedRate = 6000)
    public void testFunc() {
        Transaction tran = null;
        try {
            tran = Cat.newTransaction("URL", "cond-server");
            System.out.println("Hello World!");
            Cat.logEvent("URLTest.TestServer", "127.0.0.1", Event.SUCCESS, "ip=server127.0.0.1&test");
            Cat.logMetricForCount("TestMetric", 1);
            tran.setStatus(Message.SUCCESS);
        } finally {
            if (tran != null) {
                tran.complete();
            }
        }
    }
}
