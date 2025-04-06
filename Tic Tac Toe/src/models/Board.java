package models;

public class Board {
    private int dimension;
    private Cell[][] board;
    public Board(int dimension) {
        this.dimension = dimension;
        board = new Cell[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = new Cell(i,j);

            }
        }

    }

    public Cell[][] getBoard() {

        for(Cell[] row : board) {
            for(Cell cell : row) {
                if(cell.getCellState() == CellState.Empty){
                    System.out.println("| |");
                }
                else{
                    System.out.println("|" + cell.getPlayer().getSymbol());
                }
                System.out.println();
            }
        }
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }
}