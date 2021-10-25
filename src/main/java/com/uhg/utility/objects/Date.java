package com.uhg.utility.objects;

public class Date {
    private String date;
    private String last_year_date;

    public Date(String date, String last_year_date) {
        this.date = date;
        this.last_year_date = last_year_date;
    }

    public Date() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLast_year_date() {
        return last_year_date;
    }

    public void setLast_year_date(String last_year_date) {
        this.last_year_date = last_year_date;
    }

    @Override
    public String toString() {
        return "Date{" +
                "date='" + date + '\'' +
                ", last_year_date='" + last_year_date + '\'' +
                '}';
    }
}
