package com.fsocity.security.springboot.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/html")
public class HTMLRestController {

    // HTML
    @GetMapping(value = {"/", "/demo"})
    public String demo() {
        return "<html><body>demo</body></html>";
    }

    @GetMapping("/message/{message}")
    public String pathVarible(@PathVariable String message) {
        return "<html><body>" + message + "</body></html>";
    }

    @GetMapping("/param")
    public String param(
            @RequestParam(value = "p", required = false, defaultValue = "empty") String param,
            HttpServletRequest request
    ) {
        String param2 = request.getParameter("p2");
        return "<html><body> Request Parameter value: " + param + " , Parameter2: " + param2 + "</body></html>";
    }

    @GetMapping("/header")
    public String header(
            @RequestHeader(value = "Accept") String accept
    ) {
        return "<html><body>Accept : " + accept + "</body></html>";
    }

    @GetMapping("/entity")
    public ResponseEntity<String> entity() {
        // 返回自定义 header
        HttpHeaders headers = new HttpHeaders();
        headers.put("MyHeader", Arrays.asList("MyHeaderValue"));

        ResponseEntity responseEntity = new ResponseEntity("<html><body>ResponseEntity</body></html>",
                headers, HttpStatus.OK);
        return responseEntity;
    }

}
