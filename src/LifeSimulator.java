import java.util.Arrays;

public class LifeSimulator {

    private int sizeX;
    private int sizeY;
    public boolean[][] world;

    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        world = new boolean[sizeX+2][sizeY+2];
//        for (int x=1; x<=sizeX; x++){
//            for(int y=1; y<=sizeY; y++){
//                world[x][y] = false;
//            }
//        }
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public boolean getCell(int x, int y) {
        return world[x+1][y+1];
    }

//    public int[] getAliveCellsX() {
//        int[] aliveX = {};
//        int[] aliveY = {};
//        for (int x=1; x<=sizeX; x++) {
//            for (int y = 1; y <= sizeY; y++) {
//                if (world[x][y]) {
//                    Arrays.copyOf(aliveX, aliveX.length + 1);
//                    aliveX[aliveX.length - 1] = x;
//                    Arrays.copyOf(aliveY, aliveY.length + 1);
//                    aliveX[aliveY.length - 1] = y;
//                }
//            }
//        }
//        return aliveX;
//    }

    public Coordinate[] getAliveCells() {
        Coordinate[] alive = {};
        for (int x=1; x < sizeX; x++) {
            for (int y = 1; y < sizeY; y++) {
                if (world[x][y]) {
                    alive = Arrays.copyOf(alive, alive.length + 1);
                    alive[alive.length-1] = new Coordinate(x,y);
                }
            }
        }
        return alive;
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        //TODO: check that pattern will fit
        for (int px = 0; px <= pattern.getSizeX(); px++){
            for (int py = 0; py <= pattern.getSizeY(); py++) {

                world[startX + px][startY + py] = pattern.getCell(px, py);
            }
        }
    }

    public void update() {
        boolean[][] updated = new boolean[sizeX+1][sizeY+1];

        //TODO: clean this for loop up
        for (int x=0; x<sizeX; x++) {
            for (int y=0; y<sizeY; y++) {
                int neighborsAlive = 0;
                if (!(x == 0 || y == 0)){

                    boolean n = world[x-1][y];
                    boolean ne = world[x-1][y+1];
                    boolean e = world[x][y+1];
                    boolean se = world[x+1][y+1];
                    boolean s = world[x+1][y];
                    boolean sw = world[x+1][y-1];
                    boolean w = world[x][y-1];
                    boolean nw = world[x-1][y- 1];

                    boolean[] directions = {
                            n,
                            ne,
                            e,
                            se,
                            s,
                            sw,
                            w,
                            nw,
                    };

                    for (int d=0; d < directions.length; d++) {
                        if (directions[d]) {
                            neighborsAlive++;
                        }
                    }
                }

                if (world[x][y] && (neighborsAlive == 2 || neighborsAlive == 3)){
                    updated[x][y] = true;
                } else {
                    updated[x][y] = false;
                }

                if (!(world[x][y]) && neighborsAlive == 3){
                    updated[x][y] = true;
                }
            //Wrap
//                if (updated[0][y]) {
//                    updated[0][y] = false;
//                    updated[sizeX-2][y] = true;
//                }
//                if (updated[x][0]) {
//                    updated[x][0] = false;
//                    updated[x][sizeY-2] = true;
//                }
//                if (updated[sizeX-1][y]) {
//                    updated[sizeX-1][y] = false;
//                    updated[1][y] = true;
//                }
//                if (updated[x][sizeY-1]) {
//                    updated[x][sizeY-1] = false;
//                    updated[x][1] = true;
//                }

            }

        }
        world = updated;
    }

}

