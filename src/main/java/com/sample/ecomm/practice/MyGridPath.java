package com.sample.ecomm.practice;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.*;

public class MyGridPath {
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m , n;
    static Map<String, Integer> blockHits = new HashMap<>();

    public static boolean canReach (int sx , int sy, int dx, int dy) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx, sy});
        visited[sx][sy] = true;


        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0]; int y = cell[1];

            if (x == dx && y == dy) {
                return true;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nx = cell[0] + MyGridPath.dx[i];
                int ny = cell[1] + MyGridPath.dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (grid[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    } else if (grid[nx][ny] == '*') {
                        String key = nx+","+ny;
                        blockHits.put(key , blockHits.getOrDefault(key,0)+1);
                        if (blockHits.getOrDefault(key,0) > 1) {
                            grid[nx][ny] = '.';
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }

            System.out.println("next cycle");
        }


        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        grid = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0 ; i < m ; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        int sx = sc.nextInt() - 1;
        int sy = sc.nextInt() - 1;
        int dx = sc.nextInt() - 1;
        int dy = sc.nextInt() - 1;

        System.out.println("Can reach : " + (canReach(sx, sy, dx, dy) ? "YES" : "NO"));

    }

}
