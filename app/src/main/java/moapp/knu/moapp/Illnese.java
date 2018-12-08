package moapp.knu.moapp;

import android.database.sqlite.SQLiteDatabase;

public class Illnese {
    private String name;
    private Integer mandatory;
    private Integer vaccin_ok;
    private String vaccin_date;
    private String next_date;

    public Illnese(String name, Integer mandatory) {
        this.name = name;
        this.mandatory = mandatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMandatory() {
        return mandatory;
    }

    public void setMandatory(Integer mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getVaccin_ok() {
        return vaccin_ok;
    }

    public void setVaccin_ok(Integer vaccin_ok) {
        this.vaccin_ok = vaccin_ok;
    }

    public String getVaccin_date() {
        return vaccin_date;
    }

    public void setVaccin_date(String vaccin_date) {
        this.vaccin_date = vaccin_date;
    }

    public String getNext_date() {
        return next_date;
    }

    public void setNext_date(String next_date) {
        this.next_date = next_date;
    }
}
