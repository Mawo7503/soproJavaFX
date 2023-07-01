package de.mawo.withSpring;
/**
 * Nothing special to see here.
 * Only important thing to know here:
 * If you want to use a Tableview, remember that Tableview.setItems uses a .get*VarName*() standard, so a Record will create Errors!
 * */
public class Modul {

    private String modulname;
    private int lp;
    private Double note;

    public Modul(String name, int lp, double note) {
        this.modulname = name;
        this.lp = lp;
        this.note = note;
    }

    public String getModulname() {
        return modulname;
    }

    public void setModulname(String modulname) {
        this.modulname = modulname;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

}
