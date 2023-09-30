package com.stepbros.skillwise;

import org.springframework.ai.client.AiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
    private final AiClient aiClient;

    @Autowired
    AIController(AiClient client){
        this.aiClient = client;
    }

    @GetMapping("/ai/hello")
    public Completion completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {

        return new Completion(aiClient.generate(message));

    }
}
