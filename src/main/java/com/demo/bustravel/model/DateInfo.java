package com.demo.bustravel.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class DateInfo {
    private String date;
    private int timezone_type;
    private String timezone;
}
