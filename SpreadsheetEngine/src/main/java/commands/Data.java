package commands;

public class Data {
    private String command;
    private String col;
    private int row;
    private String value;

    public Data() {}

    Data(String command, String col, int row, String value) {
        this.command = command;
        this.col = col;
        this.row = row;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return this.command == null || this.col == null || this.row == 0 || this.value == null;
    }
}
