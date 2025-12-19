package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/demo/")
public class Controller {
    private final DemoService demoService;

    public Controller(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("get-demo2")
    public ResponseEntity<Demo2Model> getTest() {
        Demo3Model demo3Model = demoService.getDataDemo3();
        Demo2Model demo2Model = new Demo2Model();
        demo2Model.setDemo3(demo3Model.getMessage());
        demo2Model.setDemo2("Hallo, from demo2");
        log.info("get-demo2 - Data: {}", demo2Model);
        return ResponseEntity.ok(demo2Model);
    }
}
