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
    private int distance;
    @OneToMany
    private List<ScheduleItem> schedule;
}
