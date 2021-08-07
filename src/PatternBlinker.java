public class PatternBlinker extends Pattern {
    private int sizeX = 2;
    private int sizeY = 2;
    private boolean[][] init = {
            {false, false, false},
            {true, true, true},
            {false, false, false}
    };

    @Override
    public int getSizeX() { return sizeX; }

    @Override
    public int getSizeY() {
        return  sizeY;
    }

    @Override
    public boolean getCell(int x, int y) {
        return init[x][y];
    }
}



