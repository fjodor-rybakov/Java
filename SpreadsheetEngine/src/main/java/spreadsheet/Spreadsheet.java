package spreadsheet;

import cell.Cell;

import java.util.*;

public class Spreadsheet {
    private TreeMap<String, TreeMap<Integer, Cell>> spreadsheet = new TreeMap<>();
    private CalculateFormula calculateFormula = new CalculateFormula(this);

    public TreeMap<String, TreeMap<Integer, Cell>> getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(TreeMap<String, TreeMap<Integer, Cell>> spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public void setSpreadsheetFormula(String col, int row, String value) {
        String[] splittingValue = value.split(" ");
        calculateFormula.calculate(splittingValue);
    }

    public void setSpreadsheetValue(String col, int row, String value) {
        if (spreadsheet.containsKey(col)) {
            TreeMap<Integer, Cell> newValue = spreadsheet.get(col);
            newValue.put(row, new Cell(col, row, value));
        } else {
            TreeMap<Integer, Cell> newValue = new TreeMap<>();
            newValue.put(row, new Cell(col, row, value));
            spreadsheet.put(col, newValue);
        }
    }

    public void printSpreadsheet() {
        System.out.print("\t");
        for (Map.Entry entry : spreadsheet.entrySet())
            System.out.printf("%s\t\t\t", entry.getKey());
        System.out.println();

        Set<Integer> uniqueRowIndex = new HashSet<>();
        for (Map.Entry<String, TreeMap<Integer, Cell>> col : spreadsheet.entrySet())
            for (Map.Entry<Integer, Cell> row : col.getValue().entrySet())
                if (!uniqueRowIndex.contains(row.getKey())) {
                    this.printDataCell(row);
                    uniqueRowIndex.add(row.getKey());
                }
    }

    private void printDataCell(Map.Entry<Integer, Cell> row) {
        System.out.print(row.getKey() + "\t");
        for (Map.Entry<String, TreeMap<Integer, Cell>> entry : spreadsheet.entrySet())
            for (Map.Entry<Integer, Cell> cell : entry.getValue().entrySet())
                if (cell.getKey().equals(row.getKey()))
                    System.out.printf("%s\t\t", cell.getValue().getCell());
        System.out.println();
    }

    public String getSpreadsheetValue(String col, int row) {
        return spreadsheet.get(col).get(row).getCell();
    }
}
