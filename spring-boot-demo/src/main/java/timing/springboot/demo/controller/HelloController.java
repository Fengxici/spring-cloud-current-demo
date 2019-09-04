package timing.springboot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public String helloworld() {
        logger.info("收到了一个请求！");
        return "hello,world! I am spring boot!";
    }
}
