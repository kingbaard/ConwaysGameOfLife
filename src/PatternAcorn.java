public class PatternAcorn extends Pattern {
    private int sizeX = 6;
    private int sizeY = 2;
    private boolean[][] init = {
            {false, false, true},
            {true, false, true},
            {false, false, false},
            {false, true, false},
            {false, false, true},
            {false, false, true},
            {false, false, true}
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


