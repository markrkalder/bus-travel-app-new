package com.demo.bustravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Route {

    @Id
    private String id;
    private Town from;
    private Town to;
    //TODO: Make sure there are no floats in distacne
    private int distance;
    private List<ScheduleItem> schedule;
    //TODO: nuputa valja kuidas metadatat/ see teine id jms expiredate saveida
}
