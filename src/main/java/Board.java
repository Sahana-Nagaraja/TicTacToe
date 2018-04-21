class Board {

    static final int ROWS = 3;
    static final int COLS = 3;
    Position[][] positions;

    Board() {
        positions = new Position[ROWS][COLS];
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                positions[row][col] = new Position(row, col);
            }
        }
    }

    void displayOnBoard() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                positions[row][col].displayOnBoard();
                if (col < COLS - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROWS - 1) {
                System.out.println("-----------");
            }
        }
    }

    void startGame() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                positions[row][col].clear();
            }
        }
    }
}