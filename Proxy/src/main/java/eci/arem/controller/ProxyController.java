package eci.arem.controller;

import eci.arem.service.ProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProxyController {

    @Autowired
    ProxyService proxyService;
    @GetMapping
    public String getSequence(@RequestParam int n) throws Exception{
        return proxyService.route(n);
    }
}
