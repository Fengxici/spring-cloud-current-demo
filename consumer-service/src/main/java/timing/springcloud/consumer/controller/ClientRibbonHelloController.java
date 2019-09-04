package timing.springcloud.consumer.controller;

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
public class ClientRibbonHelloController {
    private final RestTemplate restTemplate;

    @Autowired
    public ClientRibbonHelloController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "ribbon/get")
    public String ribbonGet() {
        return restTemplate.getForEntity("http://PROVIDER-SERVICE/get?para={0}", String.class, "client_ribbon").getBody();
    }

    @PostMapping(value = "ribbon/post")
    public String ribbonPost() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<>();
        parammap.add("para", "ribbon_client");
        HttpEntity<Map> entity = new HttpEntity<>(parammap,headers);
        return restTemplate.postForEntity("http://PROVIDER-SERVICE/post",entity, String.class ).getBody();
    }

    @PutMapping(value = "ribbon/put")
    public void ribbonPut() {
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, Object> parammap = new LinkedMultiValueMap<>();
        parammap.add("para", "ribbon_client");
        HttpEntity<Map> entity = new HttpEntity<>(parammap,headers);
        restTemplate.put("http://PROVIDER-SERVICE/put", entity);
    }

    @DeleteMapping(value = "ribbon/delete")
    public void ribbonDelete() {
        Map<String, String> params = new HashMap<>();
        params.put("para", "ribbon_client");
        restTemplate.delete("http://PROVIDER-SERVICE/delete/{para}", params);
    }
}
