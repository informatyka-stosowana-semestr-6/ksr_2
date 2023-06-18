package ksr2.logic.membershipFunction;

public class Triangular implements MembershipFunction{
    private final double left;
    private final double top;
    private final double right;

    public Triangular(double left, double top, double right) {
        this.left = left;
        this.top = top;
        this.right = right;
    }

    public double getMembership(double x) {
        if (x < this.left) {
            return 0;
        } else if (x < this.top) {
            return (x - this.left) / (this.top - this.left);
        } else if (x == this.top) {
            return 1;
        } else if (x < this.right) {
            return (this.right - x) / (this.right - this.top);
        } else {
            return 0;
        }
    }
    public double getSupport(){
        return this.right - this.left;
    }
}
