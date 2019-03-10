public class Employment2016 {
    private int totalLaborForce;
    private int emplyedLaborForce;
    private int unemployedLaborForce;
    private double unemployedPercent;

    public Employment2016(int totalLaborForce, int emplyedLaborForce, int unemployedLaborForce, double unemployedPercent){
        this.totalLaborForce = totalLaborForce;
        this.emplyedLaborForce = emplyedLaborForce;
        this.unemployedLaborForce = unemployedLaborForce;
        this.unemployedPercent = unemployedPercent;
    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmplyedLaborForce() {
        return emplyedLaborForce;
    }

    public void setEmplyedLaborForce(int emplyedLaborForce) {
        this.emplyedLaborForce = emplyedLaborForce;
    }

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public double getUnemployedPercent() {
        return unemployedPercent;
    }

    public void setUnemployedPercent(double unemployedPercent) {
        this.unemployedPercent = unemployedPercent;
    }
}
