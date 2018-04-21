class GameOutput {
    int currentRow, currentCol;
    Position[][] positions;

    GameOutput() {
        positions = new Position[Board.ROWS][Board.COLS];
        for (int row = 0; row < Board.ROWS; ++row) {
            for (int col = 0; col < Board.COLS; ++col) {
                positions[row][col] = new Position(row, col);
            }
        }
    }

    boolean hasWon(PositionContent positionContent) {

        boolean checkRowsForWin = positions[currentRow][0].positionContent == positionContent
                && positions[currentRow][1].positionContent == positionContent
                && positions[currentRow][2].positionContent == positionContent;

        boolean checkColsForWin = positions[0][currentCol].positionContent == positionContent
                && positions[1][currentCol].positionContent == positionContent
                && positions[2][currentCol].positionContent == positionContent;

        boolean checkDiagonalsForWin = positions[0][0].positionContent == positionContent
                && positions[1][1].positionContent == positionContent
                && positions[2][2].positionContent == positionContent
                || positions[0][2].positionContent == positionContent
                && positions[1][1].positionContent == positionContent
                && positions[2][0].positionContent == positionContent;

        return (checkRowsForWin || checkColsForWin || checkDiagonalsForWin);
    }

    boolean isTIE() {
        for (int row = 0; row < Board.ROWS; ++row) {
            for (int col = 0; col < Board.COLS; ++col) {
                if (positions[row][col].positionContent == PositionContent.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
