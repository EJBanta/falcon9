package Falcon9;

import RocketAndLiftoff.Rocket;

// import java.awt.Graphics;

public class Falcon9 extends Rocket {
    private final double G = 6.6473 * Math.pow(10, -11);
    private final double ME = 5.972 * Math.pow(10, 24);
    private final double RE = 6.3781 * Math.pow(10, 6);
    private double DT;
    private double DM;
    private final double FT = 6806000;

    private double m;
    private double fg;
    private double f;
    private double h;
    private double t;
    
    public Falcon9(double x, double y, double width, double height) {
        super(x, y, width, height);

        setV(0);
        setA(0);
        m = 541300;
        h = 0;
        fg = G * ((m * ME) / Math.pow(RE + h, 2));
        f = FT - fg;
        t = 0;

        DT = 0.001;
        DM = 398900 * (DT / 162);
    }

    public Falcon9(int x, int y, int width, int height, double m, double fg, double f, double a, double v, double h, double t, double dt) {
        super(v, a);
        
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);

        this.m = m;
        this.fg = fg;
        this.f = f;
        this.h = h;
        this.t = t;
        this.DT = dt;
    }

    public void move() {
        setM(getM() - getDM());
        setFg(getG() * (getME() * getM()) / Math.pow(getRE() + getH(), 2));
        setF(getFT() - getFg());
        setA(getF() / getM());
        setV(getV() + getA() * getDT());
        setH(getH() + getV() * getDT());
        setT(getT() + getDT());

        // draw(g);
    }

    // Constant Getters
    public double getG() {
        return G;
    }

    public double getME() {
        return ME;
    }

    public double getRE() {
        return RE;
    }

    public double getDT() {
        return DT;
    }

    public double getDM() {
        return DM;
    }

    public double getFT() {
        return FT;
    }

    // Field Getters
    public double getM() {
        return m;
    }

    public double getFg() {
        return fg;
    }

    public double getF() {
        return f;
    }

    public double getH() {
        return h;
    }

    public double getT() {
        return t;
    }

    // Field (+DT, +DM) Setters
    public void setM(double m) {
        this.m = m;
    }

    public void setFg(double fg) {
        this.fg = fg;
    }

    public void setF(double f) {
        this.f = f;
    }

    public void setH(double h) {
        this.h = h;
    }

    public void setT(double t) {
        this.t = t;
    }

    public void setDT(double dt) {
        this.DT = dt;
    }
    
    public void setDM(double dm) {
        this.DM = dm;
    }

}
