package Falcon9;

import RocketAndLiftoff.Rocket;

import java.awt.Graphics;

public class Falcon9 extends Rocket {
    private final double G = 6.6473 * Math.pow(10, -11);
    private final double ME = 5.972 * Math.pow(10, 24);
    private final double RE = 6.3781 * Math.pow(10, 6);
    private double DT;
    private double DM;
    private double FT;

    private double m;
    private double fg;
    private double fd;
    private double f;
    private double h;
    private double t;

    private double scale;
    
    public Falcon9(double x, double y, double width, double height) {
        super(x, y, width, height);

        setV(0);
        setA(0);
        m = 541300;
        h = 0;
        fg = G * ((m * ME) / Math.pow(RE + h, 2));
        fd = ((1.44766 * Math.pow(0.999859, h)) * 10.7521008569 * 0.342 * Math.pow(0, 2)) / 2;
        f = FT - fg;
        t = 0;

        DT = 0.001;
        DM = 398900 * (DT / 162);
        FT = 6806000;
        
        scale = 0.000951903833155;
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

    public void move() { // No draw for tester
        setM(getM() - getDM());
        setFg(getG() * (getME() * getM()) / Math.pow(getRE() + getH(), 2));
        setFd(((1.44766 * Math.pow(0.999859, getH())) * 10.7521008569 * 0.342 * Math.pow(0, 2)) / 2);
        setF(getFT() - getFg() - getFd());
        setA(getF() / getM());
        setV(getV() + getA() * getDT());
        setH(getH() + getV() * getDT());
        setT(getT() + getDT());
    }

    public void move(int HEIGHT, Graphics g) {
        setM(getM() - getDM());
        setFg(getG() * (getME() * getM()) / Math.pow(getRE() + getH(), 2));
        setFd(((1.44766 * Math.pow(0.999859, getH())) * 10.7521008569 * 0.342 * Math.pow(0, 2)) / 2);
        setF(getFT() - getFg() - getFd());
        setA(getF() / getM());
        setV(getV() + getA() * getDT());
        setH(getH() + getV() * getDT());
        setT(getT() + getDT());

        setY((int)(HEIGHT - getH() * getScale()));

        draw(g);
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

    public double getFd() {
        return fd;
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

    public double getScale() {
        return scale;
    }

    // Field (+DT, +DM, +FT, +Scale) Setters
    public void setM(double m) {
        this.m = m;
    }

    public void setFg(double fg) {
        this.fg = fg;
    }

    public void setFd(double fd) {
        this.fd = fd;
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

    public void setFT(double ft) {
        this.FT = ft;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

}
