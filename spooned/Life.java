// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Life {
    public static void show(boolean[][] grid) {
        java.lang.String s = "";
        for (boolean[] row : grid) {
            for (boolean val : row)
                if (val)
                    s += "*";
                else
                    s += ".";
                
            s += "\n";
        }
        java.lang.System.out.println(s);
    }

    public static boolean[][] gen() {
        boolean[][] grid = new boolean[10][10];
        for (int r = 0 ; r < 10 ; r++)
            for (int c = 0 ; c < 10 ; c++)
                if ((java.lang.Math.random()) > 0.7)
                    grid[r][c] = true;
                
        return grid;
    }

    public static void main(java.lang.String[] args) {
        boolean[][] world = Life.gen();
        Life.show(world);
        java.lang.System.out.println();
        world = Life.nextGen(world);
        Life.show(world);
        java.util.Scanner s = new java.util.Scanner(java.lang.System.in);
        while ((s.nextLine().length()) == 0) {
            java.lang.System.out.println();
            world = Life.nextGen(world);
            Life.show(world);
        }
    }

    public static boolean[][] nextGen(boolean[][] world) {
        boolean[][] newWorld = new boolean[world.length][world[0].length];
        int num;
        for (int r = 0 ; r < (world.length) ; r++) {
            for (int c = 0 ; c < (world[0].length) ; c++) {
                num = Life.numNeighbors(world, r, c);
                if (Life.occupiedNext(num, world[r][c]))
                    newWorld[r][c] = true;
                
            }
        }
        return newWorld;
    }

    public static boolean occupiedNext(int numNeighbors, boolean occupied) {
        if (occupied && ((numNeighbors == 2) || (numNeighbors == 3)))
            return true;
        else if ((!occupied) && (numNeighbors == 3))
            return true;
        else
            return false;
        
    }

    private static int numNeighbors(boolean[][] world, int row, int col) {
        int num = world[row][col] ? -1 : 0;
        for (int r = row - 1 ; r <= (row + 1) ; r++)
            for (int c = col - 1 ; c <= (col + 1) ; c++)
                if ((Life.inbounds(world, r, c)) && (world[r][c]))
                    num++;
                
        return num;
    }

    private static boolean inbounds(boolean[][] world, int r, int c) {
        return (((r >= 0) && (r < (world.length))) && (c >= 0)) && (c < (world[0].length));
    }
}

