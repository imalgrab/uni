import java.util.Random;

public class GameBoard {
    private int boardWidth, boardHeight;
    private Field[][] board;
    private Kid[] kids;

    public GameBoard(int N, int M) {
        this.boardHeight = N;
        this.boardWidth = M;
        this.board = new Field[N][M];
        this.kids = new Kid[10];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                board[i][j] = new Field();
            }
        }
        for (int i = 0; i < kids.length; i++) {
            Random rand = new Random();
            int row = rand.nextInt(boardWidth);
            int col = rand.nextInt(boardHeight);
            if (i % 2 == 0) kids[i] = new Kid(row, col, "Santa/awake.png", false);
            else kids[i] = new Kid(row, col, "Santa/sleeper.png", true);
            board[col][row].setKidOnField();
        }

        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {

                /*
                if (i == 0 && j == 0) {
                    board[i][j].setNorth(board[boardHeight - 1][j]);
                    board[i][j].setSouth(board[i + 1][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][boardWidth - 1]);
                } else if (i == 0 && j == boardWidth - 1) {
                    board[i][j].setNorth(board[boardHeight - 1][j]);
                    board[i][j].setSouth(board[i + 1][j]);
                    board[i][j].setEast(board[i][0]);
                    board[i][j].setWest(board[i][boardWidth - 1]);
                } else if (i == boardHeight - 1 && j == 0) {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[0][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][boardWidth - 1]);
                } else if (i == boardHeight - 1 && j == boardWidth - 1) {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[0][j]);
                    board[i][j].setEast(board[i][0]);
                    board[i][j].setWest(board[i][boardWidth - 1]);
                } else if (i == 0 && j > 0 && j < boardWidth - 1) {
                    board[i][j].setNorth(board[boardHeight - 1][j]);
                    board[i][j].setSouth(board[i + 1][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][j - 1]);
                } else if (i == boardHeight - 1 && j > 0 && j < boardWidth - 1) {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[0][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][j - 1]);
                } else if (i > 0 && i < boardHeight - 1 && j == 0) {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[0][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][boardWidth - 1]);
                } else if (i > 0 && i < boardHeight - 1 && j == boardWidth - 1) {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[0][j]);
                    board[i][j].setEast(board[i][0]);
                    board[i][j].setWest(board[i][j - 1]);
                } else {
                    board[i][j].setNorth(board[i - 1][j]);
                    board[i][j].setSouth(board[i + 1][j]);
                    board[i][j].setEast(board[i][j + 1]);
                    board[i][j].setWest(board[i][j - 1]);
                }
                */
            }
        }
    }

    public Field[][] getBoard() {
        return board;
    }

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public Kid[] getKids() {
        return kids;
    }

    public int getNumOfKids() {
        return kids.length;
    }
}
