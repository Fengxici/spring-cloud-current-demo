package timing.springcloud.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {
    @Value("${test.uri:http://localhost:9090}")
    String uri;

    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(t -> t.path("/baidu")
                        .and()
                        .uri("http://baidu.com"))
                .route(t -> t.path("/**")
                        .and()
                        .uri(uri))
                .build();
    }
}
