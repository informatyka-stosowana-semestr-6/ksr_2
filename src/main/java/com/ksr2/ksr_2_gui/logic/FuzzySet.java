package com.ksr2.ksr_2_gui.logic;


import com.ksr2.ksr_2_gui.logic.classicSet.ClassicSet;
import com.ksr2.ksr_2_gui.logic.classicSet.Crisp;
import com.ksr2.ksr_2_gui.logic.membershipFunction.MembershipFunction;

public class FuzzySet {
    private MembershipFunction membershipFunction;
    private ClassicSet universe;

    public FuzzySet(MembershipFunction membershipFunction) {
        this.membershipFunction = membershipFunction;
// TODO
        //        this.universe = universe;
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

    public ClassicSet getUniverse() {
        return universe;
    }

    public void setUniverse(ClassicSet universe) {
        this.universe = universe;
    }
}
