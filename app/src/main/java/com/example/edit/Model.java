package com.example.edit;

public class Model {
    String Quetion, oa, ob, oc, od ,ans;
    public Model(){

    }

    public Model(String quetion, String oa, String ob, String oc, String od, String ans) {
        Quetion = quetion;
        this.oa = oa;
        this.ob = ob;
        this.oc = oc;
        this.od = od;
        this.ans = ans;
    }

    public String getQuetion() {
        return Quetion;
    }

    public void setQuetion(String quetion) {
        Quetion = quetion;
    }

    public String getOa() {
        return oa;
    }

    public void setOa(String oa) {
        this.oa = oa;
    }

    public String getOb() {
        return ob;
    }

    public void setOb(String ob) {
        this.ob = ob;
    }

    public String getOc() {
        return oc;
    }

    public void setOc(String oc) {
        this.oc = oc;
    }

    public String getOd() {
        return od;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
