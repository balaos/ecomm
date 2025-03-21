package com.sample.ecomm.hacker.graph;

import java.util.*;

public class AlefMazeEscape {
    static int rows, cols;
    static char[][] maze;
    static double[][] prob;
    static boolean[][] visited;
    static int startX, startY;
    static Map<String, String> tunnels = new HashMap<>();
    static int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    static int[] dy = {0, 0, -1, 1};

    public static double escapeProbability() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        prob[startX][startY] = 1.0;
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            if (maze[x][y] == '%') continue; // Exit reached
            if (maze[x][y] == '*') { // Mine reached
                prob[x][y] = 0;
                continue;
            }

            if (tunnels.containsKey(x + "," + y)) {
                String[] tunnelExit = tunnels.get(x + "," + y).split(",");
                int nx = Integer.parseInt(tunnelExit[0]);
                int ny = Integer.parseInt(tunnelExit[1]);
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    prob[nx][ny] += prob[x][y];
                    queue.add(new int[]{nx, ny});
                }
                continue;
            }

            List<int[]> validMoves = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (maze[nx][ny] != '#' && !visited[nx][ny]) {
                    validMoves.add(new int[]{nx, ny});
                }
            }

            if (validMoves.isEmpty()) continue; // No valid moves

            double splitProb = prob[x][y] / validMoves.size();
            for (int[] move : validMoves) {
                int nx = move[0], ny = move[1];
                prob[nx][ny] += splitProb;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        double escapeProb = 0.0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == '%') {
                    escapeProb += prob[i][j];
                }
            }
        }
        return escapeProb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        int numTunnels = sc.nextInt();
        sc.nextLine();

        maze = new char[rows][cols];
        prob = new double[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = line.charAt(j);
                if (maze[i][j] == 'A') {
                    startX = i;
                    startY = j;
                }
            }
        }

        for (int i = 0; i < numTunnels; i++) {
            int x1 = sc.nextInt() - 1, y1 = sc.nextInt() - 1;
            int x2 = sc.nextInt() - 1, y2 = sc.nextInt() - 1;
            tunnels.put(x1 + "," + y1, x2 + "," + y2);
            tunnels.put(x2 + "," + y2, x1 + "," + y1);
        }

        System.out.printf("%.6f\n", escapeProbability());
        sc.close();
    }
}
