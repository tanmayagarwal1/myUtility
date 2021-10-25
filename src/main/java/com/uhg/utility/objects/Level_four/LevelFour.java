package com.uhg.utility.objects.Level_four;

import com.uhg.utility.objects.Level_three.*;

public abstract class LevelFour {
    private OleSubmissions ole_submissions;
    private OleSuccess ole_success;
    private OleLastYear ole_last_year;
    private FailedOle failed_ole;
    private AbandonedOle abandonedOle;

    public LevelFour(OleSubmissions ole_submissions, OleSuccess ole_success, OleLastYear ole_last_year, FailedOle failed_ole, AbandonedOle abandonedOle) {
        this.ole_submissions = ole_submissions;
        this.ole_success = ole_success;
        this.ole_last_year = ole_last_year;
        this.failed_ole = failed_ole;
        this.abandonedOle = abandonedOle;
    }

    public LevelFour() {
    }

    public OleSubmissions getOle_submissions() {
        return ole_submissions;
    }

    public void setOle_submissions(OleSubmissions ole_submissions) {
        this.ole_submissions = ole_submissions;
    }

    public OleSuccess getOle_success() {
        return ole_success;
    }

    public void setOle_success(OleSuccess ole_success) {
        this.ole_success = ole_success;
    }

    public OleLastYear getOle_last_year() {
        return ole_last_year;
    }

    public void setOle_last_year(OleLastYear ole_last_year) {
        this.ole_last_year = ole_last_year;
    }

    public FailedOle getFailed_ole() {
        return failed_ole;
    }

    public void setFailed_ole(FailedOle failed_ole) {
        this.failed_ole = failed_ole;
    }

    public AbandonedOle getAbandonedOle() {
        return abandonedOle;
    }

    public void setAbandonedOle(AbandonedOle abandonedOle) {
        this.abandonedOle = abandonedOle;
    }

    @Override
    public String toString() {
        return "LevelFour{" +
                "ole_submissions=" + ole_submissions +
                ", ole_success=" + ole_success +
                ", ole_last_year=" + ole_last_year +
                ", failed_ole=" + failed_ole +
                ", abandonedOle=" + abandonedOle +
                '}';
    }
}
