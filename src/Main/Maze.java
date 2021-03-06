package Main;

import java.util.Random;

public class Maze {
    private int n;                 // dimension of maze
    private boolean[][] north;     // is there a wall to north of cell i, j
    private boolean[][] east;
    private boolean[][] south;
    private boolean[][] west;
    private boolean[][] visited;
    private Random rand;

    public Maze(int n) {
        this.n = n;
        init();
        generate();
    }

    private void init() {
    	
    	rand = new Random();
    	
        // initialize border cells as already visited
        visited = new boolean[n+2][n+2];
        for (int x = 0; x < n+2; x++) {
            visited[x][0] = true;
            visited[x][n+1] = true;
        }
        for (int y = 0; y < n+2; y++) {
            visited[0][y] = true;
            visited[n+1][y] = true;
        }


        // initialze all walls as present
        north = new boolean[n+2][n+2];
        east  = new boolean[n+2][n+2];
        south = new boolean[n+2][n+2];
        west  = new boolean[n+2][n+2];
        for (int x = 0; x < n+2; x++) {
            for (int y = 0; y < n+2; y++) {
                north[x][y] = true;
                east[x][y]  = true;
                south[x][y] = true;
                west[x][y]  = true;
            }
        }
    }


    // generate the maze
    private void generate(int x, int y) {
        visited[x][y] = true;

        // while there is an unvisited neighbor
        while (!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]) {

            // pick random neighbor (could use Knuth's trick instead)
            while (true) {
                double r = rand.nextInt(4);
                if (r == 0 && !visited[x][y+1]) {
                    south[x][y] = false;
                    north[x][y+1] = false;
                    generate(x, y + 1);
                    break;
                }
                else if (r == 1 && !visited[x+1][y]) {
                    east[x][y] = false;
                    west[x+1][y] = false;
                    generate(x+1, y);
                    break;
                }
                else if (r == 2 && !visited[x][y-1]) {
                    north[x][y] = false;
                    south[x][y-1] = false;
                    generate(x, y-1);
                    break;
                }
                else if (r == 3 && !visited[x-1][y]) {
                    west[x][y] = false;
                    east[x-1][y] = false;
                    generate(x-1, y);
                    break;
                }
            }
        }
    }

    // generate the maze starting from lower left
    private void generate() {
        generate(1, 1);

/*
        // delete some random walls
        for (int i = 0; i < n; i++) {
            int x = 1 + StdRandom.uniform(n-1);
            int y = 1 + StdRandom.uniform(n-1);
            north[x][y] = south[x][y+1] = false;
        }

        // add some random walls
        for (int i = 0; i < 10; i++) {
            int x = n/2 + StdRandom.uniform(n/2);
            int y = n/2 + StdRandom.uniform(n/2);
            east[x][y] = west[x+1][y] = true;
        }
*/
     
    }
    
    public int[][] map()
    {
    	int[][] map = new int[n*8+1][n*8+1];
    	
    	for (int i = 0; i < n*8+1; i++)
    	{
    		for (int j = 0; j < n*8+1; j++)
    		{
    			map[i][j] = 5;
    		}
    	}
    	
    	for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x][y])
                {
                	for (int i = 0; i < 9; i++)
                	{
                		map[((x-1)*8) + i][((y-1)*8) + 8] = 3;
                	}
                }
                if (north[x][y]) 
                {
                	for (int i = 0; i < 9; i++)
                	{
                		map[((x-1)*8) + i][((y-1)*8)] = 3;
                	}
                }
                if (west[x][y])  
                {
                	for (int i = 0; i < 9; i++)
                	{
                		map[((x-1)*8)][((y-1)*8) + i] = 3;
                	}
                }
                if (east[x][y])  
                {
                	for (int i = 0; i < 9; i++)
                	{
                		map[((x-1)*8) + 8][((y-1)*8) + i] = 3;
                	}
                }
            }
        }
    	
    	Random rand = new Random();
    	
    	int randX = rand.nextInt(n);
    	int randY = rand.nextInt(n);
    	
    	while(randX == 0 && randY == 0)
    	{
    		randX = rand.nextInt(n);
        	randY = rand.nextInt(n);
    	}
    	
    	map[(randX*8) + 4][(randY*8) + 4] = 6;
    	
    	return map;
    }
}