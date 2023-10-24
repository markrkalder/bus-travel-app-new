package com.demo.bustravel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<String, List<WeightedEdge>> adjacencyList;
    private final List<String> nodes;
    private final List<Tuple<List<WeightedEdge>, Integer>> result;

    public Graph() {
        adjacencyList = new HashMap<>();
        nodes = new ArrayList<>();
        result = new ArrayList<>();
    }

    public void addEdge(String source, String destination, int weight){
        WeightedEdge weightedEdge = new WeightedEdge(destination, weight);
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(weightedEdge);
        if (!nodes.contains(source)) {
            nodes.add(source);
        }
        if (!nodes.contains(destination)) {
            nodes.add(destination);
        }
    }

    public List<Tuple<List<WeightedEdge>, Integer>> findPathsHelper(String source, String destination) {
        List<WeightedEdge> path = new ArrayList<>();
        path.add(new WeightedEdge(source, 0));
        boolean[] visited = new boolean[nodes.size()];
        int totalWeight = 0;
        if (adjacencyList.containsKey(source)){
            findPaths(source, destination, visited, path, totalWeight);
        }
        return result;
    }

    private void findPaths(String source, String destination, boolean[] visited, List<WeightedEdge> path, int totalWeight) {
        if (source.equals(destination)) {
            printPath(path, totalWeight);
            result.add(new Tuple<>(path, totalWeight));
            return;
        }
        // It is not the destination node, but doesn't have any edges going out either.
        if (!adjacencyList.containsKey(source)) return;

        List<WeightedEdge> neighbors = adjacencyList.get(source);
        //For nodes with no edges
        if (neighbors == null) return;

        visited[getIndex(source)] = true;
        for (WeightedEdge neighbor : neighbors){
            if (!visited[getIndex(neighbor.getDestination())]) {
                path.add(neighbor);
                totalWeight += neighbor.getWeight();
                findPaths(neighbor.getDestination(), destination, visited, path, totalWeight);
                path.remove(path.size() - 1);
                totalWeight -= neighbor.getWeight();
                visited[getIndex(source)] = false;
            }
        }
    }

    private int getIndex(String node) {
        return nodes.indexOf(node);
    }

    private void printPath(List<WeightedEdge> path, int totalWeight) {
        StringBuilder pathString = new StringBuilder("Path: ");
        for (WeightedEdge edge : path) {
            pathString.append(edge.getDestination()).append(" (Weight: ").append(edge.getWeight()).append(") -> ");
        }
        pathString.setLength(pathString.length() - 4); // Remove the last " -> "
        pathString.append("\nTotal Weight: ").append(totalWeight);
        System.out.println(pathString.toString());
    }
}
