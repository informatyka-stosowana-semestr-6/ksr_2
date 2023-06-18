package com.ksr2.ksr_2_gui.logic;


import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunction;

public class FuzzySet {
    private MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public double getMembership(double x){
        return this.membershipFunction.getMembership(x);
    }

    public void setMembershipFunction(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
    }
}
