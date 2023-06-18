package com.ksr2.ksr_2_gui.logic.membershipFunction;

public class Gaussian implements MembershipFunction {
    private final double top;
    private final double stdev;

    public Gaussian(double top, double stdev) {
        this.top = top;
        this.stdev = stdev;
    }

    public double getMembership(double x) {
        double membership = Math.pow(Math.E, -0.5 * ((x - this.top) / (this.stdev * this.stdev)));
        if (stdev > 1) {
            membership = 1 / membership;
        }
        return membership;
    }
    public double getSupport(){
        return this.stdev*2*2;
    }
}