package web.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import web.app.service.JdaService;

@RestController
public class DiscordRestController {

//    private final JdaService jdaService;
//
//    public JdaRestController(JdaService jdaService) {
//        this.jdaService = jdaService;
//    }

    @GetMapping
    public void sendRequest() {

    }
}
