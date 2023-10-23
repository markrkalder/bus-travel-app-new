package com.demo.bustravel.service;

import com.demo.bustravel.RouteData;
import com.demo.bustravel.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteData routeData;

    private void makeReservation(String firstName, String lastName){

    }

    private void findShortestPath(){

    }

    public void loadData(){
        routeData.fetchData();
    }
}
