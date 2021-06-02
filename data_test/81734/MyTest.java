import net.bqc.oasis.junit.JavaReflection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyTest {
    static Board board;
    static Game game;


    @Before
    public void initBoard() {
        board = new Board();
        ArrayList<Piece> pieces = new ArrayList<>();
        Bishop bishopWhite1 = new Bishop(2, 2, "white");
        Bishop bishopWhite2 = new Bishop(7, 2, "white");
        Bishop bishopWhite3 = new Bishop(2, 7, "black");
        Bishop bishopWhite4 = new Bishop(7, 7, "black");
        pieces.add(bishopWhite1);
        pieces.add(bishopWhite2);
        pieces.add(bishopWhite3);
        pieces.add(bishopWhite4);
        board.setPieces(pieces);
        game = new Game(board);
    }


    @Test
    public void test_addPiece_method_in_board() {
        Assert.assertEquals(4, board.getPieces().size());
        Bishop newBishop = new Bishop(4, 3, "white");
        try {
            Method boardAddPieceMethod = JavaReflection.getMethod(Board.class, "addPiece", void.class, "", "", Piece.class);
            if (boardAddPieceMethod == null) {
                Assert.fail("Can't not get method 'addPiece(Piece)'");
            }
            boardAddPieceMethod.invoke(board, newBishop);
            Assert.assertEquals("Add valid Bishop object to Board, check 'pieces' size:", 5, board.getPieces().size());
            boardAddPieceMethod.invoke(board, newBishop);
            Assert.assertEquals("Add duplicate Bishop object to Board, check 'pieces' size:", 5, board.getPieces().size());
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }

    @Test
    public void test_validate_method_in_board() {
        Method boardValidateMethod = JavaReflection.getMethod(Board.class, "validate", boolean.class, "", "", int.class, int.class);
        if (boardValidateMethod == null) {
            Assert.fail("Can't not get method 'validate(int,int):boolean'");
        }

        try {
            boolean valid = (boolean) boardValidateMethod.invoke(board, 1, 2);
            Assert.assertEquals("Test 'validate(int,int):boolean' method with input = (1,2): ", true, valid);

            valid = (boolean) boardValidateMethod.invoke(board, -1, 5);
            Assert.assertEquals("Test 'validate(int,int):boolean' method with input = (-1,5): ", false, valid);

            valid = (boolean) boardValidateMethod.invoke(board, 4, 9);
            Assert.assertEquals("Test 'validate(int,int):boolean' method with input = (4,9): ", false, valid);

        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }

    @Test
    public void test_removeAt_method_in_board() {
        Method boardRemoveAtMethod = JavaReflection.getMethod(Board.class, "removeAt", void.class, "", "", int.class, int.class);
        if (boardRemoveAtMethod == null) {
            Assert.fail("Can't not get method 'removeAt(int,int):void'");
        }
        try {
            boardRemoveAtMethod.invoke(board, 2, 2);
            Assert.assertEquals("Remove existed Piece at (2,2), check 'pieces' size:", 3, board.getPieces().size());
            boardRemoveAtMethod.invoke(board, 8, 8);
            Assert.assertEquals("Remove not existed Piece at (8,8), check 'pieces' size:", 3, board.getPieces().size());
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }

    @Test
    public void test_getAt_method_in_board() {

        Method boardGetAtMethod = JavaReflection.getMethod(Board.class, "getAt", Piece.class, "", "", int.class, int.class);
        if (boardGetAtMethod == null) {
            Assert.fail("Can't not get method 'getAt(int,int):Piece'");
        }
        try {
            Piece piece = (Piece) boardGetAtMethod.invoke(board, 2, 2);
            Assert.assertEquals("Get Bishop at (2,2), check return not null: ", false, piece == null);
            Assert.assertEquals("Check type of Piece object at (2,2)", true, piece instanceof Bishop);
            Assert.assertEquals("Check x of Piece object at (2,2)", 2, piece.getCoordinatesX());
            Assert.assertEquals("Check y of Piece object at (2,2)", 2, piece.getCoordinatesY());
            Assert.assertEquals("Check color of Piece object at (2,2)", "white", piece.getColor());

            piece = (Piece) boardGetAtMethod.invoke(board, 5, 5);
            Assert.assertEquals("Get Piece at (5,5), check return null: ", true, piece == null);

            piece = (Piece) boardGetAtMethod.invoke(board, -8, 9);
            Assert.assertEquals("Get Piece at (-8,9), check return null: ", true, piece == null);
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }

    @Test
    public void test_toString_method_in_move() {
        try {
            Constructor moveConstructor5ParamMethod = Move.class.getConstructor(int.class, int.class, int.class, int.class, Piece.class);
            try {
                Constructor moveConstructor6ParamMethod = Move.class.getConstructor(int.class, int.class, int.class, int.class, Piece.class, Piece.class);

                try {
                    Move move = (Move) moveConstructor5ParamMethod.newInstance(2, 2, 4, 4, new Bishop(2, 2, "white"));
                    String s = move.toString();
                    Assert.assertEquals("Check 'toString():String' of Move(2,2,4,4,Bishop(2,2,'white'))", "white-Bd4", s);

                    move = (Move) moveConstructor6ParamMethod.newInstance(7, 2, 2, 7, new Bishop(7, 2, "white"), new Bishop(2, 7, "black"));
                    s = move.toString();
                    Assert.assertEquals("Check 'toString():String' of Move(7,2,2,7,Bishop(7,2,'white'),Bishop(2,7,'black'))", "white-Bb7", s);
                } catch (InstantiationException e) {
                    Assert.fail("Call constructor 'Move(int,int,int,int,Piece)' failed!!");
                } catch (IllegalAccessException e) {
                    Assert.fail("Access constructor 'Move(int,int,int,int,Piece)' failed!!");
                } catch (InvocationTargetException e) {
                    String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
                    Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
                }
            } catch (NoSuchMethodException e) {
                Assert.fail("Can't not get constructor Move(int,int,int,int,Piece,Piece)");
            }
        } catch (NoSuchMethodException e) {
            Assert.fail("Can't not get constructor Move(int,int,int,int,Piece)");
        }
    }

    @Test
    public void test_getSymbol_method_in_bishop() {
        Method bishopGetSymbolMethod = JavaReflection.getMethod(Bishop.class, "getSymbol", String.class, "", "");
        if (bishopGetSymbolMethod == null) {
            Assert.fail("Can't not access method 'getSymbol():string'");
        }
        try {
            Bishop bishop = new Bishop(1, 1, "white");
            String symbol = (String) bishopGetSymbolMethod.invoke(bishop);
            Assert.assertEquals("Check getSymbol() of Bishop return 'B'", "B", symbol);
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }

    @Test
    public void test_canMove_method_in_bishop() {
        Method bishopCanMoveMethod;
        bishopCanMoveMethod = JavaReflection.getMethod(Bishop.class, "canMove", boolean.class, "", "", Board.class, int.class, int.class);
        if (bishopCanMoveMethod == null) {
            Assert.fail("Can't not access method 'canMove(Board,int,int):string'");
        }
        try {
            Bishop bishopFirst = (Bishop) board.getPieces().get(0);
            Bishop bishopSecond = (Bishop) board.getPieces().get(1);
            boolean canMove = (boolean) bishopCanMoveMethod.invoke(bishopFirst, board, 3, 3);
            Assert.assertEquals("Check canMove() method, must return true when move Bishop from (2,2) to (3,3)", true, canMove);

            canMove = (boolean) bishopCanMoveMethod.invoke(bishopFirst, board, 1, 1);
            Assert.assertEquals("Check canMove() method, must return true when move Bishop from (2,2) to (1,1)", true, canMove);

            canMove = (boolean) bishopCanMoveMethod.invoke(bishopSecond, board, 2, 7);
            Assert.assertEquals("Check canMove() method, must return true when move Bishop from (7,2) to (2,7)", true, canMove);

            canMove = (boolean) bishopCanMoveMethod.invoke(bishopSecond, board, 1, 8);
            Assert.assertEquals("Check canMove() method, must return false when move Bishop from (7,2) to (1,8)", false, canMove);

            canMove = (boolean) bishopCanMoveMethod.invoke(bishopSecond, board, -1, -1);
            Assert.assertEquals("Check canMove() method, must return false when move Bishop from (7,2) to (-1,-1)", false, canMove);
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }


    @Test
    public void test_movePiece_method_in_game() {
        Method gameMovePieceMethod;
        gameMovePieceMethod = JavaReflection.getMethod(Game.class, "movePiece", void.class, "", "", Piece.class, int.class, int.class);
        if (gameMovePieceMethod == null) {
            Assert.fail("Can't not access method 'movePiece(Piece,int,int):void'");
        }
        try {
            Bishop bishop = (Bishop) board.getPieces().get(0);
            gameMovePieceMethod.invoke(game, bishop, 7, 7);
            Assert.assertEquals("Check moveHistory not null after moving one Piece", false, game.getMoveHistory() == null);
            Assert.assertEquals("Move White Bishop to (7,7), defeat black Bishop at (7,7), check moveHistory size", 1, game.getMoveHistory().size());
            Assert.assertEquals("Move White Bishop to (7,7), defeat black Bishop at (7,7), check new X position of movedPiece", 7, bishop.getCoordinatesX());
            Assert.assertEquals("Move White Bishop to (7,7), defeat black Bishop at (7,7), check new Y position of movedPiece", 7, bishop.getCoordinatesY());

            Bishop bishop1 = (Bishop) board.getAt(2, 7);
            Assert.assertEquals("Get Piece at (2,7), must return black bishop", false, bishop1 == null);

            gameMovePieceMethod.invoke(game, bishop1, 7, 2);
            Assert.assertEquals("Check moveHistory not null after 2 movements", false, game.getMoveHistory() == null);
            Assert.assertEquals("Move Black Bishop to (7,2), defeat white Bishop at (7,2), check moveHistory size", 2, game.getMoveHistory().size());
            Assert.assertEquals("Move Black Bishop to (7,2), defeat white Bishop at (7,2), check new X position of movedPiece", 7, bishop1.getCoordinatesX());
            Assert.assertEquals("Move Black Bishop to (7,2), defeat white Bishop at (7,2), check new Y position of movedPiece", 2, bishop1.getCoordinatesY());

            Bishop bishop1Empty = (Bishop) board.getAt(2, 7);
            Assert.assertEquals("Move Black Bishop from (2,7) to (7,2), check getPiece(2,7) must return null", true, bishop1Empty == null);
            Move firstMove = game.getMoveHistory().get(0);
            Assert.assertEquals("Check killedPiece at first move, must not null", true, !(firstMove.getKilledPiece() == null));
            Move secondMove = game.getMoveHistory().get(1);
            Assert.assertEquals("Check killedPiece at second move, must not null", true, !(secondMove.getKilledPiece() == null));
        } catch (IllegalAccessException e) {
            Assert.fail(e.getMessage());
        } catch (InvocationTargetException e) {
            String methodThrowExeption = e.getCause().getStackTrace()[0].getMethodName();
            Assert.fail(String.format("Catch exception '%s' while invoking method '%s'!", e.getCause().getMessage(), methodThrowExeption));
        }
    }
}
