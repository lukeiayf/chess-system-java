package chess;

import boardGame.Position;

public class ChessPosition {
    private final char column;
    private final int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row <1 || row >8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        //by subtracting the values from the ASCII code of the chars you can get the position on the matrix
        return new Position(8 - this.row, this.column - 'a');
    }

    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char)('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        //this is a workaround to tell the compiler this is a concatenation not an arithmetic operation
        return "" + column + row;
    }
}
