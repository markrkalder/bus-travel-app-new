package com.demo.bustravel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
public class ScheduleItem {

    @Id
    private String id;
    private float price;
    @JsonProperty("start")
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "start_date")),
            @AttributeOverride(name = "timezone_type", column = @Column(name = "start_timezone_type")),
            @AttributeOverride(name = "timezone", column = @Column(name = "start_timezone"))
    })
    private DateInfo start;
    @JsonProperty("end")
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "end_date")),
            @AttributeOverride(name = "timezone_type", column = @Column(name = "end_timezone_type")),
            @AttributeOverride(name = "timezone", column = @Column(name = "end_timezone"))
    })
    private DateInfo end;
    @ManyToOne
    @JoinColumn(name = "company_id", unique = false)
    private Company company;
}
