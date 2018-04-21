class Position {

    PositionContent positionContent;
    private int row;
    private int col;


    Position(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }


    void clear() {
        positionContent = PositionContent.EMPTY;
    }


    void displayOnBoard() {
        switch (positionContent) {
            case X:  System.out.print(" X ");
            break;
            case O: System.out.print(" O ");
            break;
            case EMPTY:  System.out.print("   ");
            break;
        }
    }
}