package report;

import java.util.HashMap;
import java.util.Map;

public class Report {
    private Map<String, Integer> dataReport = new HashMap<String, Integer>();

    public Map<String, Integer> getDataReport() {
        return this.dataReport;
    }

    public void setDataReport(String nameProduct, int countProduct) {
        this.dataReport.put(nameProduct, countProduct);
    }
}
