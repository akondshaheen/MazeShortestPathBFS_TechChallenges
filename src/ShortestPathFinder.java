import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathFinder {

   // Directions the user authorised to go asre up/down/left/right
    int[][] directions = {{1, 0},{0, 1},{-1, 0},{0, -1} };

    /**
     * Find path with BFS
     * @param maze Given Maze
     * @return sum of Path
     */
    public int BFSPathFInder(int[][] maze) {
        int pathCount = 0;
        int rowLength = maze.length;
        int columnLength = maze[0].length;
        int initialItem = maze[0][0];
        int endItem = maze[rowLength - 1][columnLength - 1];
        boolean[][] isVisited = new boolean[rowLength][columnLength];


       // if start or end have block items, maze explore fails
            if (initialItem == 1 || endItem == 1) {
            return -1;
        }

        //Define Queu to add path
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;

       //Check if Queue is not empty for explore
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] CurrentPoll = queue.poll();

                if (CurrentPoll[0] == rowLength - 1 && CurrentPoll[1] == columnLength - 1) {
                    return pathCount + 1;
                }

                //add directions to the queue if they are not visited
                   for (int[] dir : directions) {
                    int x = dir[0] + CurrentPoll[0];
                    int y = dir[1] + CurrentPoll[1];

                    if (x >= 0 && x < rowLength && y >= 0 && y < columnLength && maze[x][y] == 0 && !isVisited[x][y]) {
                        queue.add(new int[]{x, y});
                        isVisited[x][y] = true;
                    }
                }
            }
            pathCount++;
        }
        return -1;
    }
}
