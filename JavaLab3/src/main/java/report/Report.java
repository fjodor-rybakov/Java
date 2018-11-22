package report;

import java.util.ArrayList;

public class Report implements IReport {
    private ArrayList<String> dataReport = new ArrayList<>();

    public ArrayList<String> getDataReport() {
        return dataReport;
    }

    public void setDataReport(ArrayList<String> dataReport) {
        this.dataReport = dataReport;
    }
}
