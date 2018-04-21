import java.util.Scanner;

public class TicTacToeMain {

    private Board board;
    private GameStatus gameStatus;
    private PositionContent positionContent;
    private static Scanner in = new Scanner(System.in);
    private GameOutput gameOutput = new GameOutput();

    public static void main(String[] args) {
        new TicTacToeMain();
    }

    TicTacToeMain() {
        board = new Board();
        startGame();
        do {
            playerMove(positionContent);
            board.displayOnBoard();
            updateGame(positionContent);
            if (gameStatus == GameStatus.X_WON) {
                System.out.println("\nX won");
            } else if (gameStatus == GameStatus.O_WON) {
                System.out.println("\nO won");
            } else if (gameStatus == GameStatus.TIE) {
                System.out.println("\nIt's a tie");
            }
            positionContent = (positionContent == PositionContent.X) ? PositionContent.O : PositionContent.X;
        } while (gameStatus == GameStatus.PLAYING);
    }

    public void startGame() {
        board.startGame();
        positionContent = PositionContent.X;
        gameStatus = GameStatus.PLAYING;
    }

    public void playerMove(PositionContent positionContent) {
        boolean validInput = false;
        do {
            if (positionContent == PositionContent.X) {
                System.out.print("x > ");
            } else {
                System.out.print("o > ");
            }
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.positions[row][col].positionContent == PositionContent.EMPTY) {
                board.positions[row][col].positionContent = positionContent;
                gameOutput.currentRow = row;
                gameOutput.currentCol = col;
                validInput = true;
            } else {
                System.out.println("Invalid move");
            }
        } while (!validInput);
    }

    public void updateGame(PositionContent thePositionContent) {
        if (gameOutput.hasWon(thePositionContent)) {
            gameStatus = (thePositionContent == PositionContent.X) ? GameStatus.X_WON : GameStatus.O_WON;
        } else if (gameOutput.isTIE()) {
            gameStatus = GameStatus.TIE;
        }
    }
}