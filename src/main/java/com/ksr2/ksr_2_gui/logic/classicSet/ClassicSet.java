package com.ksr2.ksr_2_gui.logic.classicSet;

public interface ClassicSet {
    boolean isIn(double value);

    double getSize();

    double getBottom();

    double getTop();

    ClassicSet add(ClassicSet set);

    ClassicSet getProduct(ClassicSet set);
}
