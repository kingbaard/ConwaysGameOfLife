public class PatternBlock extends Pattern {
    private int sizeX = 1;
    private int sizeY = 1;
    private boolean[][] init = {
            {true, true},
            {true, true}
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