import commands.Commands;
import commands.Data;
import spreadsheet.Spreadsheet;
import java.util.Scanner;

public class SpreadsheetEngine {
    public static void main(String[] args) {
        Commands commands = new Commands();
        Spreadsheet spreadsheet = new Spreadsheet();
        Scanner input = new Scanner(System.in);
        String value = "";
        Data result;

        while (!value.equals("exit")) {
            value = input.nextLine();
            try {
                result = commands.parseData(spreadsheet, value);
                if (!result.isEmpty()) {
                    if (result.getCommand().equals("set")) {
                        spreadsheet.setSpreadsheetValue(result.getCol(), result.getRow(), result.getValue());
                    } else if (result.getCommand().equals("setformula")) {
                        spreadsheet.setSpreadsheetFormula(result.getCol(), result.getRow(), result.getValue());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
