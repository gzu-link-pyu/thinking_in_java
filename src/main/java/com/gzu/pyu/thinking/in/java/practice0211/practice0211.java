package com.gzu.pyu.thinking.in.java.practice0211;

public class practice0211 {
    public static void main(String[] args) {
        /**
         * 0211.1
         */
        ScopVarlibe scopVarlibe=new ScopVarlibe();
        System.out.println(scopVarlibe.toString());
    }
}

class ScopVarlibe {
    boolean is;
    char ch;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;

    public boolean isIs() {
        return is;
    }

    public void setIs(boolean is) {
        this.is = is;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public byte getB() {
        return b;
    }

    public void setB(byte b) {
        this.b = b;
    }

    public short getS() {
        return s;
    }

    public void setS(short s) {
        this.s = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "ScopVarlibe{" +
                "is=" + is +
                ", ch=" + ch +
                ", b=" + b +
                ", s=" + s +
                ", i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                '}';
    }
}
