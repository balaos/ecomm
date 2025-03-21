package com.sample.ecomm.hacker.graph;

import java.util.*;

class CityShortestPath {
    static class Node {
        String name;
        int time;
        public Node(String name, int time) {
            this.name = name;
            this.time = time;
        }
    }

    public static void dijkstra(Map<String, List<Node>> graph, String source) {
        // Step 1: Initialize distances for ALL nodes
        Map<String, Integer> dist = new HashMap<>();
        for (String node : graph.keySet()) dist.put(node, Integer.MAX_VALUE);
        dist.put(source, 0); // Source node distance = 0

        // Step 2: Min Heap (Priority Queue) to find shortest paths
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            String u = current.name;

            // Step 3: Relaxation step
            for (Node neighbor : graph.getOrDefault(u, new ArrayList<>())) {
                // Ensure neighbor exists in dist map
                dist.putIfAbsent(neighbor.name, Integer.MAX_VALUE);

                int newDist = dist.get(u) + neighbor.time;
                if (newDist < dist.get(neighbor.name)) {
                    dist.put(neighbor.name, newDist);
                    pq.add(new Node(neighbor.name, newDist));
                }
            }
        }

        System.out.println("Shortest travel times: " + dist);
    }

    public static void main(String[] args) {
        Map<String, List<Node>> cityMap = new HashMap<>();
        cityMap.put("Home", Arrays.asList(new Node("A", 5)));
        cityMap.put("A", Arrays.asList(new Node("B", 2), new Node("C", 1)));
        cityMap.put("B", Arrays.asList(new Node("Office", 3)));
        cityMap.put("C", Arrays.asList(new Node("Office", 4)));

        // Ensure all nodes exist in graph (even if they have no outgoing edges)
        cityMap.putIfAbsent("Office", new ArrayList<>());

        dijkstra(cityMap, "Home");
    }
}


