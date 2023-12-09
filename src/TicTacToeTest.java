import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testValidMove() {
        TicTacToe ticTacToe = new TicTacToe();
        assertTrue(ticTacToe.isValidMove(0, 0));
        assertTrue(ticTacToe.isValidMove(1, 2));
        assertFalse(ticTacToe.isValidMove(-1, 1));
        assertFalse(ticTacToe.isValidMove(0, 3));
        assertTrue(ticTacToe.isValidMove(2, 2)); // Already occupied
    }

    @Test
    public void testCheckWin() {
        TicTacToe ticTacToe = new TicTacToe();
        //char[][] board = ticTacToe.getBoard();

        // Horizontal win
        ticTacToe.setBoard(0,0,'X');
        ticTacToe.setBoard(0,1,'X');
        ticTacToe.setBoard(0,2,'X');
        assertTrue(ticTacToe.checkWin());

        // Vertical win
        ticTacToe.resetBoard();
        ticTacToe.setBoard(0,0,'O');
        ticTacToe.setBoard(1,0,'O');
        ticTacToe.setBoard(2,0,'O');
        assertTrue(ticTacToe.checkWin());

        // Diagonal win (top-left to bottom-right)
        ticTacToe.resetBoard();
        ticTacToe.setBoard(0,0,'X');
        ticTacToe.setBoard(1,1,'X');
        ticTacToe.setBoard(2,2,'X');
        assertTrue(ticTacToe.checkWin());

        // Diagonal win (top-right to bottom-left)
        ticTacToe.resetBoard();
        ticTacToe.setBoard(0,2,'X');
        ticTacToe.setBoard(1,1,'X');
        ticTacToe.setBoard(2,0,'X');
        assertTrue(ticTacToe.checkWin());

        // No win
        ticTacToe.resetBoard();
        ticTacToe.setBoard(0,0,'X');
        ticTacToe.setBoard(1,1,'O');
        ticTacToe.setBoard(2,2,'X');
        assertFalse(ticTacToe.checkWin());
    }

    @Test
    public void testIsBoardFull() {
        TicTacToe ticTacToe = new TicTacToe();
        assertFalse(ticTacToe.isBoardFull());

        // Fill the board
        char[][] board = ticTacToe.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 'X';
            }
        }
        assertTrue(ticTacToe.isBoardFull());
    }

    // Additional tests can be added to cover more scenarios

}
