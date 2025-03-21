package com.sample.ecomm.practice;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

class Node {
    String name;
    int time;

    public Node (String name, int time) {
        this.name = name;
        this.time = time;
    }
}

public class MyCityGraph {

    public static void findShortDist (Map<String, List<Node>> graph , String source) {

        Map<String, Integer> dist = new HashMap<>();

        for (String key : graph.keySet()) {
            dist.put(key , Integer.MAX_VALUE);
        }
        dist.put(source, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt((Node a) -> a.time).reversed());
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node neighbour : graph.getOrDefault(current.name, new ArrayList<>())) {
                int newDist = dist.get(current.name) + neighbour.time;
                if (newDist < dist.get(neighbour.name)) {
                    dist.put(neighbour.name, newDist);
                    pq.add(new Node(neighbour.name, newDist));
                }
            }
        }

        System.out.println("Shortest distance : "+dist);

    }

    public static void main(String[] args) {
        Map<String, List<Node>>  graph = new HashMap<>();
        graph.put("Home", Arrays.asList(new Node("A", 2)));
        graph.put("A", Arrays.asList(new Node("B", 1), new Node("C", 5)));
        graph.put("B", Arrays.asList(new Node("office", 3)));
        graph.put("C", Arrays.asList(new Node("office", 1)));
        graph.put("office", new ArrayList<>());

        findShortDist(graph, "Home");
    }
}
