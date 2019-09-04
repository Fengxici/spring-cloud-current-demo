package timing.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 该注解指定项目为springboot，由此类当作程序入口自动装配 web 依赖的环境
 **/
//jar包方式
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
//war包方式
//@SpringBootApplication
//public class DemoApplication extends SpringBootServletInitializer {
//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(DemoApplication.class);
//    }
//}
