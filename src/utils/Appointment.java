package utils;

public class Appointment {
    private String report;

    public Appointment(String report) {
        this.report = report;
    }

    public void printReport() {
        System.out.println(this.report);
    }

    /**
     * @param report String
     * @return Appointment
     */
    public Appointment setReport(String report) {
        this.report = report;

        return this;
    }
}
