class Solution {

    //比较难想，要多写几遍
    // 首先定义坐标系，东南西北方向
    //North direction=0 directions[direction]={0,1}
    //South direction=1 directions[direction]={0,-1}
    //West direction=2 directions[direction]={-1,0}
    //East direction=3 directions[direction]={1,0}
    //当右转时，direction + 1；当左转时，direction - 1 或者 + 3

    //然后定义障碍物

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = {{0,1}, {1,0},{0,-1},{-1,0}};
        //定义障碍物
        Set<String> obstaclesSet = new HashSet<>();
        for(int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistSquare = 0;
        for(int i = 0; i < commands.length; i++) {
            //左转
            if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            }
            //右转
            else if (commands[i] == -1) {
                direction = (direction + 1) % 4;
            }
            //向前走 commands[i] 步
            else {
                int step = 0;
                while (step < commands[i] && !obstaclesSet.contains((x + directions[direction][0]) + " " + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }
        return maxDistSquare;
    }

}