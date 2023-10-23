package com.demo.bustravel;

import com.demo.bustravel.model.Route;
import com.demo.bustravel.model.ScheduleItem;
import com.demo.bustravel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class RouteData {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private ScheduleItemRepository scheduleItemRepository;

    public void fetchData(){
        String url = "https://assignments.novater.com/v1/bus/schedule";
        String username = "your-name";
        String password = "your-password";

        HttpHeaders httpHeaders = new HttpHeaders();
        String auth = username + ":" + password;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(encodedAuth);
        httpHeaders.set("Authorization", authHeader);

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RouteDataResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                RouteDataResponse.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            RouteDataResponse responseBody = response.getBody();
            if (responseBody != null && responseBody.getRoutes() != null){
                for (Route route : responseBody.getRoutes()) {
                    townRepository.save(route.getFrom());
                    townRepository.save(route.getTo());

                    for (ScheduleItem scheduleItem : route.getSchedule()) {
                        companyRepository.save(scheduleItem.getCompany());
                        scheduleItemRepository.save(scheduleItem);
                    }
                    routeRepository.save(route);
                }
            }
        }
    }
}
