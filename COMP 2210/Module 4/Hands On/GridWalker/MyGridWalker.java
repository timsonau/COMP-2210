import java.util.Arrays;

public class MyGridWalker {
    //2d area to traverse, search space
    //calculate the shortest path
    //the grid would modle a map in casese
    private int[][] grid;

    //visited positions so we do not go to a place we have visited. "BreadCrumbs"
    private boolean[][] visited;

    //dimensions of the grid
    private int numRows;
    private int numColumns;

    //max number of neighbors that can be visited. Up down left right diagonal
    private final int MAX_NEIGHBORS = 8;
    //counts the orer int at which the position was visited.
    private int order;
    //constructs a 4 by 4 grid default
    public MyGridWalker() {
        this(4, 4);
    }

    public MyGridWalker(int rows, int columns) {
        //makes a grid based on passed in parameters
        grid = new int[rows][columns];
        numRows = rows;
        numColumns = columns;

    }

    public MyGridWalker(int[][] gridIn) {
        //makes a copy of the grid based on the parameter
        numRows = gridIn.length;
        numColumns = gridIn[0].length;

        grid = new int[numRows][numColumns];

        int currRow = 0;
        //for each row in the grid
        for(int[] row : gridIn) {
            int currColumn = 0;
            //copy each value from that row to the grid.
            for(int val : row) {
                grid[currRow][currColumn] = val;
                currColumn++;
            }
            currRow++;
        }
        markAllUnvisited();
    }

    //intialized the visisted 2D array
    public void markAllUnvisited() {
        visited = new boolean[numRows][numColumns];
        for(int x = 0; x < numRows; x++) {
            for(int y = 0; y < numColumns; y++) {
                visited[x][y] = false;
            }
        }
    }

    public String gridToString() {
        String result = "";
        for(int x = 0; x < numRows; x++) {
            for(int y = 0; y < numColumns; y++) {
                result += "["+ grid[x][y] + "]";
            }
            result += "\n";
        }
        return result;
    }

       /**
    * Returns a string representation of the current grid.
    */
   @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        int fieldWidth = 4;
        for (int i = 0; i < fieldWidth * numRows; i++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int[] row : grid) {
            for (int entry : row) {
                sb.append(String.format("%" + fieldWidth + "d", entry));
            }
            sb.append("\n");
        }
        for (int i = 0; i < fieldWidth * numRows; i++) {
            sb.append("*");
        }
        sb.append("\n");
        return sb.toString();
    }

    //checks if the position is a valid postion in the grid
    private boolean isValid(Position p) {
        return (p.x < numRows) && (p.y < numColumns) && (p.x >= 0) && (p.y >= 0);
    }

    private boolean isVisited(Position p) {
        //if visisted that cell should be true
        return visited[p.x][p.y];
    }

    //eneter in a postion you want to visit
    private void visit(Position p) {
        visited[p.x][p.y] = true;
    }

    private void prcoess(Position p) {
        grid[p.x][p.y] = order++;
    }

    //purpose is to model a (x,y) position in the grid
    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")"; 
        }

        //for breath it needs all the neighbors
        //for depth we still need it to pick one neighbor out of neighbors
        //we need position for every neighbor
        public Position[] neigbors() {
            Position[] neighbors = new Position[MAX_NEIGHBORS];

            int count = 0;
            for(int i = -1; i <= 1; i++) {
                for(int j = -1; j <= 1; j++) {
                    if(!(i == 0) && !(j == 0)) {
                        //the real position of the neighbors in respect to the current position of the postion object calling this method
                        Position p = new Position(x + i, y + j);
                        if(isValid(p)) {
                            neighbors[count++] = p;
                        }
                    }
                }
            }
            return Arrays.copyOf(neighbors, count);
        }
    }
}
