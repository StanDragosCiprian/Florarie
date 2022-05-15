package sample;

import javafx.scene.control.Button;

public class ModelTable{
    String den,var,can,tip;



    public ModelTable(String den, String var, String can, String tip) {
        this.den = den;
        this.var = var;
        this.can = can;
        this.tip = tip;


    }




    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getCan() {
        return can;
    }

    public void setCan(String can) {
        this.can = can;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

}
