package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class DemoService {

    @Value("${app.url-demo3}")
    private String url;
    private final WebClient webClient;

    public DemoService(WebClient webClient){
        this.webClient=webClient;
    }

    public Demo3Model getDataDemo3(){
        ResponseEntity<Demo3Model> responseEntity = webClient.get()
                .uri(url+"/api/v1/demo/get-demo3")
                .retrieve()
                .toEntity(Demo3Model.class)
                .block();
        log.info("{}", responseEntity.getBody());
        return responseEntity.getBody() == null ? new Demo3Model() : responseEntity.getBody();
    }
}
