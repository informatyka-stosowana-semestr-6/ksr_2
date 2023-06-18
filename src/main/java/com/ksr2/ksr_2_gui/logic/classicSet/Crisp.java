package com.ksr2.ksr_2_gui.logic.classicSet;


public class Crisp implements ClassicSet{
    @Override
    public boolean isIn(double value) {
        return false;
    }

    @Override
    public double getSize() {
        return 0;
    }

    @Override
    public double getBottom() {
        return 0;
    }

    @Override
    public double getTop() {
        return 0;
    }

    @Override
    public ClassicSet add(ClassicSet set) {
        return null;
    }

    @Override
    public ClassicSet getProduct(ClassicSet set) {
        return null;
    }
}
