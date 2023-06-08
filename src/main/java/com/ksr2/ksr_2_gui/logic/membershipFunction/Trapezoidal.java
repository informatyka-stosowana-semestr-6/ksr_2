package com.ksr2.ksr_2_gui.logic.membershipFunction;


public class Trapezoidal implements MembershipFunction{
    private final double leftDown;
    private final double leftUp;
    private final double rightUp;
    private final double rightDown;

    public Trapezoidal(double leftDown, double leftUp, double rightUp, double rightDown) {
        this.leftDown = leftDown;
        this.leftUp = leftUp;
        this.rightUp = rightUp;
        this.rightDown = rightDown;
    }

    public double getMembership(double x) {
        if (x < this.leftDown) {
            return 0;
        } else if (x < this.leftUp) {
            return (x - this.leftDown) / (this.leftUp - this.leftDown);
        } else if (x < this.rightUp) {
            return 1;
        } else if (x < this.rightDown) {
            return (this.rightDown - x) / (this.rightDown - this.rightUp);
        } else {
            return 0;
        }
    }
    public double getSupport(){
        return this.rightDown - this.leftDown;
    }
}
