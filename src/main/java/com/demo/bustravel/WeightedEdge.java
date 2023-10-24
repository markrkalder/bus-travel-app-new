package com.demo.bustravel;

public class WeightedEdge {
    private final String destination;
    private final int weight;

    public WeightedEdge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
