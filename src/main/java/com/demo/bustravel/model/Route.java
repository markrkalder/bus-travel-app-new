package com.demo.bustravel.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Route {

    @Id
    private String id;
    @ManyToOne
    private Town from;
    @ManyToOne
    private Town to;
    //TODO: Make sure there are no floats in distacne
    private int distance;
    @OneToMany
    private List<ScheduleItem> schedule;
}
