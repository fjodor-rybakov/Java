package report;

import java.util.ArrayList;

public class Report implements IReport {
    private ArrayList<String> dataReport = new ArrayList<>();

    public ArrayList<String> getDataReport() {
        return this.dataReport;
    }
}
