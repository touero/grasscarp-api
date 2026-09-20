package top.weiensong.grasscarp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class EndpointLogger implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(EndpointLogger.class);

    private final RequestMappingHandlerMapping handlerMapping;

    public EndpointLogger(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    @Override
    public void run(String... args) {
        log.info("========== API ENDPOINTS ==========");

        handlerMapping.getHandlerMethods().forEach((mapping, method) -> {
            log.info("{} -> {}", mapping, method.getMethod());
        });

        log.info("===================================");
    }
}