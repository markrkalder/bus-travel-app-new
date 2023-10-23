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
    private Timestamp startDate;
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "company_id", unique = false)
    private Company company;
    private int startTimezoneType;
    private String startTimezone;
    private int endTimezoneType;
    private String endTimezone;
}
