package com.demo.bustravel.controller;

import com.demo.bustravel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    @GetMapping("/getPaths")
    public void getPaths(
            @RequestParam String start,
            @RequestParam String end
    ){
        try{
            //Result in console
            routeService.findPaths(start, end);
        }
        catch (Exception e){
            System.out.println("help: " + e.getMessage());
        }
    }
}
