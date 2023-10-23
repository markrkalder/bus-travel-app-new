package com.demo.bustravel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Company {
    @Id
    private String id;
    private String state;
}
