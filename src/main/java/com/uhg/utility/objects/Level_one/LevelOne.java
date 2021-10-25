package com.uhg.utility.objects.Level_one;

public abstract class LevelOne {
    private int MA;
    private int PDP;
    private int MAPD;
    private int CSNPSilver;
    private int SNP;
    private int DSNP;
    private int CSNPStandard;

    public LevelOne(int MA, int PDP, int MAPD, int CSNPSilver, int SNP, int DSNP, int CSNPStandard) {
        this.MA = MA;
        this.PDP = PDP;
        this.MAPD = MAPD;
        this.CSNPSilver = CSNPSilver;
        this.SNP = SNP;
        this.DSNP = DSNP;
        this.CSNPStandard = CSNPStandard;
    }

    public LevelOne() {
    }

    public int getMA() {
        return MA;
    }

    public void setMA(int MA) {
        this.MA = MA;
    }

    public int getPDP() {
        return PDP;
    }

    public void setPDP(int PDP) {
        this.PDP = PDP;
    }

    public int getMAPD() {
        return MAPD;
    }

    public void setMAPD(int MAPD) {
        this.MAPD = MAPD;
    }

    public int getCSNPSilver() {
        return CSNPSilver;
    }

    public void setCSNPSilver(int CSNPSilver) {
        this.CSNPSilver = CSNPSilver;
    }

    public int getSNP() {
        return SNP;
    }

    public void setSNP(int SNP) {
        this.SNP = SNP;
    }

    public int getDSNP() {
        return DSNP;
    }

    public void setDSNP(int DSNP) {
        this.DSNP = DSNP;
    }

    public int getCSNPStandard() {
        return CSNPStandard;
    }

    public void setCSNPStandard(int CSNPStandard) {
        this.CSNPStandard = CSNPStandard;
    }

    @Override
    public String toString() {
        return "LevelOne{" +
                "MA=" + MA +
                ", PDP=" + PDP +
                ", MAPD=" + MAPD +
                ", CSNPSilver=" + CSNPSilver +
                ", SNP=" + SNP +
                ", DSNP=" + DSNP +
                ", CSNPStandard=" + CSNPStandard +
                '}';
    }
}
