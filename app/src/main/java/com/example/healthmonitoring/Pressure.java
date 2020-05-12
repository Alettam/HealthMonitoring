package com.example.healthmonitoring;

import java.util.Date;

public class Pressure {
    int lower;
    int upper;
    int pulse;
    boolean tachicardia;
    String date;

    public Pressure(int lower, int upper, int pulse, boolean tachicardia, String date) {
        this.lower = lower;
        this.upper = upper;
        this.pulse = pulse;
        this.tachicardia = tachicardia;
        this.date = date;
    }
}
