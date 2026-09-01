class Solution {
    public int minMoves(String[] classroom, int maxEnergy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sx = -1, sy = -1;
        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litterCount++;
                }
            }
        }

        int totalLitter = litterCount;
        litterCount = 0;
        int[][] litterIdx = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i].charAt(j) == 'L') {
                    litterIdx[i][j] = litterCount++;
                } else {
                    litterIdx[i][j] = -1;
                }
            }
        }

        int targetMask = (1 << totalLitter) - 1;
        int[][][] maxEnergySeen = new int[m][n][1 << totalLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(maxEnergySeen[i][j], -1);
            }
        }

        java.util.Queue<int[]> queue = new java.util.ArrayDeque<>();
        queue.offer(new int[]{sx, sy, 0, maxEnergy, 0});
        maxEnergySeen[sx][sy][0] = maxEnergy;

        int[] dirs = {-1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int mask = curr[2];
            int e = curr[3];
            int steps = curr[4];

            if (mask == targetMask) {
                return steps;
            }

            if (e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d];
                int nc = c + dirs[d+1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X') continue;

                    int nextMask = mask;
                    if (cell == 'L') {
                        nextMask |= (1 << litterIdx[nr][nc]);
                    }

                    int nextEnergy = e - 1;
                    if (cell == 'R') {
                        nextEnergy = maxEnergy;
                    }

                    if (nextEnergy > maxEnergySeen[nr][nc][nextMask]) {
                        maxEnergySeen[nr][nc][nextMask] = nextEnergy;
                        queue.offer(new int[]{nr, nc, nextMask, nextEnergy, steps + 1});
                    }
                }
            }
        }

        return -1;
    }
}