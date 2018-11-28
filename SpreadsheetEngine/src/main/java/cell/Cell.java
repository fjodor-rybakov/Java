package cell;

public class Cell {
    private String cell;
    private String col;
    private int row;

    public Cell(String col, int row, String line) {
        this.cell = line;
        this.col = col;
        this.row = row;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
