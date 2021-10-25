package com.uhg.utility.objects.Level_two;

import com.uhg.utility.objects.Level_one.CurrentYear;

public class Ytd{
    private CurrentYear currentYear;

    public Ytd(CurrentYear currentYear) {
        this.currentYear = currentYear;
    }

    public Ytd() {
    }

    public CurrentYear getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(CurrentYear currentYear) {
        this.currentYear = currentYear;
    }

    @Override
    public String toString() {
        return "Ytd{" +
                "currentYear=" + currentYear +
                '}';
    }
}
