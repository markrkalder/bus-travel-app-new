package com.demo.bustravel;

import com.demo.bustravel.model.Route;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class RouteDataResponse {
    private String id;
    private Expiry expires;
    private List<Route> routes;

    @Data
    public static class Expiry {
        private Timestamp date;
        private int timezone_type;
        private String timezone;
    }
}