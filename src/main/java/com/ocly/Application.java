package com.ocly;

import com.ocly.util.IpUtil;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Controller
@SpringBootApplication
@EnableRedisHttpSession
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnableScheduling
public class Application {

    private String uuid = UUID.randomUUID().toString();


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /* @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(Application.class);
     }
 */
    @GetMapping("/")
    public String hello(HttpServletRequest request, Model model) {
        model.addAttribute("uuid", request.getSession().getId());
        model.addAttribute("springip", IpUtil.getIp());
        model.addAttribute("ip", request.getRemoteAddr());
        model.addAttribute("rip", request.getHeader("X-Real-IP"));
        model.addAttribute("springid", uuid);
        return "index";
    }
}


