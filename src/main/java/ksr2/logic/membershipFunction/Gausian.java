package ksr2.logic.membershipFunction;

public class Gausian implements MembershipFunction {
    private final double top;
    private final double stdev;

    public Gausian(double top, double stdev) {
        this.top = top;
        this.stdev = stdev;
    }

    public double getMembership(double x) {
        double membership = Math.pow(Math.E, -0.5 * ((x - this.top) / (this.stdev * this.stdev)));

        // TODO verify if needed
        if (stdev > 1) {
            membership = 1 / membership;
        }
        return membership;
    }
}
