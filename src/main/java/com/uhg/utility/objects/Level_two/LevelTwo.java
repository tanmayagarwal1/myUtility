package com.uhg.utility.objects.Level_two;

import com.uhg.utility.objects.Level_one.CurrentYear;
import com.uhg.utility.objects.Level_one.FutureYear;

public abstract class LevelTwo {
    CurrentYear current_year;
    FutureYear future_year;

    public LevelTwo(CurrentYear current_year, FutureYear future_year) {
        this.current_year = current_year;
        this.future_year = future_year;
    }

    public LevelTwo() {
    }

    public CurrentYear getCurrent_year() {
        return current_year;
    }

    public void setCurrent_year(CurrentYear current_year) {
        this.current_year = current_year;
    }

    public FutureYear getFuture_year() {
        return future_year;
    }

    public void setFuture_year(FutureYear future_year) {
        this.future_year = future_year;
    }

    @Override
    public String toString() {
        return "LevelTwo{" +
                "current_year=" + current_year +
                ", future_year=" + future_year +
                '}';
    }
}
