package com.uhg.utility.objects.Level_three;

import com.uhg.utility.objects.Level_two.DailyCount;
import com.uhg.utility.objects.Level_two.Ytd;

public abstract class LevelThree {
    private DailyCount daily_count;
    private Ytd ytd;

    public LevelThree(DailyCount daily_count, Ytd ytd) {
        this.daily_count = daily_count;
        this.ytd = ytd;
    }

    public LevelThree() {
    }

    public DailyCount getDaily_count() {
        return daily_count;
    }

    public void setDaily_count(DailyCount daily_count) {
        this.daily_count = daily_count;
    }

    public Ytd getYtd() {
        return ytd;
    }

    public void setYtd(Ytd ytd) {
        this.ytd = ytd;
    }

    @Override
    public String toString() {
        return "LevelThree{" +
                "daily_count=" + daily_count +
                ", ytd=" + ytd +
                '}';
    }
}
