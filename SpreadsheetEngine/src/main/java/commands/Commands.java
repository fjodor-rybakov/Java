package commands;

import spreadsheet.Spreadsheet;

public class Commands {
    public Data parseData(Spreadsheet spreadsheet, String value) throws Exception {
        Data result = new Data();
        switch (value.split(" ")[0].toLowerCase()) {
            case "set":
                result = this.parseSet(value);
                System.out.println("OK");
                break;
            case "setformula":
                result = this.parseSetformula(value);
                System.out.println("OK");
                break;
            case "display":
                spreadsheet.printSpreadsheet();
                break;
            case "exit":
                break;
            default:
                throw new Exception("Такой команды нет");
        }
        return result;
    }

    public Data parseSet(String value) throws Exception {
        try {
            String command = value.split(" ")[0].toLowerCase();
            String col = value.split(" ")[1].split("")[0].toUpperCase();
            int row = Integer.parseInt(value.split(" ")[1].split("")[1]);
            String resultValue = value.split(" ")[2];
            return new Data(command, col, row, resultValue);
        } catch (Exception error) {
            throw new Exception("Ошибка чтения строки");
        }
    }

    public Data parseSetformula(String value) {
        return new Data();
    }
}
