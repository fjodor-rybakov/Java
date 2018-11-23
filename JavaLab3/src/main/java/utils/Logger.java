package utils;

public class Logger {
    private boolean isLog;

    public Logger(boolean isLog) {
        this.isLog = isLog;
    }

    public void printLog(String log) {
        if (isLog) {
            System.out.println(log);
        }
    }
}
