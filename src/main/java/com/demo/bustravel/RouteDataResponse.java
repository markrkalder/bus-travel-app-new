package com.demo.bustravel;

import com.demo.bustravel.model.Route;
import lombok.Data;

import java.util.List;

@Data
public class RouteDataResponse {
    private String id;
    private Expiry expires;
    private List<Route> routes;

    @Data
    public static class Expiry {
        private String date;
        private int timezone_type;
        private String timezone;
    }
}