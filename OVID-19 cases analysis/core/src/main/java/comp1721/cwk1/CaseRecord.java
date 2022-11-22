package comp1721.cwk1;

import java.time.LocalDate;

public class CaseRecord {
    private LocalDate date;
    private int staffCases;
    private int studentCases;
    private int otherCases;
    // TODO: Write stub for constructor
    public CaseRecord(LocalDate date, int staffCases, int studentCases, int otherCases) {
        super();
        this.date = date;
        this.staffCases = staffCases;
        this.studentCases = studentCases;
        this.otherCases = otherCases;
    }
    // TODO: Write stubs for four getter methods

    public LocalDate getDate() {
        return date;
    }

    public int getStaffCases() {
        return staffCases;
    }

    public int getStudentCases() {
        return studentCases;
    }

    public int getOtherCases() {
        return otherCases;
    }

    // TODO: Write stub for totalCases()
    public int totalCases(){
        return (staffCases+studentCases+otherCases);
    }
  // TODO: Write stub for toString()
    @Override
    public String toString() {
        return "CaseRecord{" +
                "date=" + date +
                ", staffCases=" + staffCases +
                ", studentCases=" + studentCases +
                ", \notherCases=" + otherCases +
                '}';
    }
}
