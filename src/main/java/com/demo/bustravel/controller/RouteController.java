package com.demo.bustravel.controller;

import com.demo.bustravel.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping("/loadData")
    public ResponseEntity<String> loadData(){
        try{
            routeService.loadData();
            return ResponseEntity.ok("Data loaded.");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + e.getMessage());
        }
    }
}
