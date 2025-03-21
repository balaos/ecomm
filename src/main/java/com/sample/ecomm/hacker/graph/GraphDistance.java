package com.sample.ecomm.hacker.graph;

import java.util.*;

class GraphDistance {
    static class Node {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<Integer, List<Node>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node neighbor : graph.getOrDefault(u, new ArrayList<>())) {
                int v = neighbor.vertex, weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Node(1, 4), new Node(2, 1)));
        graph.put(1, Arrays.asList(new Node(3, 1)));
        graph.put(2, Arrays.asList(new Node(1, 2), new Node(3, 5)));
        graph.put(3, Arrays.asList());

        dijkstra(graph, 0);
    }
}

