package com.demo.bustravel.service;

import com.demo.bustravel.Graph;
import com.demo.bustravel.RouteData;
import com.demo.bustravel.Tuple;
import com.demo.bustravel.WeightedEdge;
import com.demo.bustravel.model.Route;
import com.demo.bustravel.model.ScheduleItem;
import com.demo.bustravel.repository.RouteRepository;
import com.demo.bustravel.repository.ScheduleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private RouteData routeData;
    @Autowired
    ScheduleItemRepository scheduleItemRepository;


    public void findPaths(String start, String end){
        routeData.fetchData();
        Graph routeGraph = new Graph();
        loadEdges(routeGraph);
        List<Tuple<List<WeightedEdge>, Integer>> result = routeGraph.findPathsHelper(start, end);
    }

    public void findOptimalTimes(List<WeightedEdge> path){
        List<ScheduleItem> filteredScheduleItems = new ArrayList<>();

    }

    private void loadEdges(Graph routeGraph){
        List<Route> routeList = (List<Route>) routeRepository.findAll();
        for (Route route : routeList) {
            String source = route.getFrom().getName();
            String destination = route.getTo().getName();
            int distance = route.getDistance();
            routeGraph.addEdge(source, destination, distance);
        }
    }
}
