package com.uhg.utility.objects.Level_five;

import com.uhg.utility.objects.Level_four.Aarp;
import com.uhg.utility.objects.Level_four.Uhc;
import com.uhg.utility.objects.Level_four.Uhccp;

public abstract class LevelFive {
    private Aarp aarp;
    private Uhc uhc;
    private Uhccp uhccp;

    public LevelFive(Aarp aarp, Uhc uhc, Uhccp uhccp) {
        this.aarp = aarp;
        this.uhc = uhc;
        this.uhccp = uhccp;
    }

    public LevelFive() {
    }

    public Aarp getAarp() {
        return aarp;
    }

    public void setAarp(Aarp aarp) {
        this.aarp = aarp;
    }

    public Uhc getUhc() {
        return uhc;
    }

    public void setUhc(Uhc uhc) {
        this.uhc = uhc;
    }

    public Uhccp getUhccp() {
        return uhccp;
    }

    public void setUhccp(Uhccp uhccp) {
        this.uhccp = uhccp;
    }

    @Override
    public String toString() {
        return "LevelFive{" +
                "aarp=" + aarp +
                ", uhc=" + uhc +
                ", uhccp=" + uhccp +
                '}';
    }
}
