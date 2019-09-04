package timing.springcloud.hystrixdashboard.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HystrixController {
    private final RestTemplate restTemplate;

    @Autowired
    public HystrixController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "ribbon/get")
    @HystrixCommand(fallbackMethod = "fallback")
    public String ribbonGet() {
        return restTemplate.getForEntity("http://PROVIDER-SERVICE/get?para={0}", String.class, "client_ribbon").getBody();
    }

    @PostMapping(value = "ribbon/post")
    @HystrixCommand(fallbackMethod = "fallback")
    public String ribbonPost() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<>();
        parammap.add("para", "ribbon_client");
        HttpEntity<Map> entity = new HttpEntity<>(parammap, headers);
        return restTemplate.postForEntity("http://PROVIDER-SERVICE/post", entity, String.class).getBody();
    }

    @PutMapping(value = "ribbon/put")
    @HystrixCommand(fallbackMethod = "fallback")
    public void ribbonPut() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<>();
        parammap.add("para", "ribbon_client");
        HttpEntity<Map> entity = new HttpEntity<>(parammap, headers);
        restTemplate.put("http://PROVIDER-SERVICE/put", entity);
    }

    @DeleteMapping(value = "ribbon/delete")
    @HystrixCommand(fallbackMethod = "fallback")
    public void ribbonDelete() {
        Map<String, String> params = new HashMap<>();
        params.put("para", "ribbon_client");
        restTemplate.delete("http://PROVIDER-SERVICE/delete/{para}", params);
    }

    public String fallback() {
        String temp = "testHystrix调用失败!" ;
        System.out.println(temp);
        return temp;
    }
}
