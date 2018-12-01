package spreadsheet;

public class CalculateFormula {
    private Spreadsheet spreadsheet;

    CalculateFormula(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public String calculate(String[] value) {
        return "result string...";
    }

    private String baseMethods(String value1, String value2, String operator) {
        String result = null;

        switch (operator) {
            case "+":
                result = sumValues(parseValueCell(value1), parseValueCell(value2));
                break;
        }

        return result;
    }

    private String parseValueCell(String value) {
        try {
            String col = value.split("")[0];
            int row = Integer.parseInt(value.split("")[1]);
            return spreadsheet.getSpreadsheetValue(col, row);
        } catch (Exception errorParseCoords) {
            return value;
        }
    }

    private String sumValues(String value1, String value2) {
        return "sum values...";
    }
}
