public class PatternGlider extends Pattern {
    private int sizeX = 2;
    private int sizeY = 2;
    private boolean[][] init = {
            {true, false, true},
            {false, true, true},
            {false, true, false}
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



