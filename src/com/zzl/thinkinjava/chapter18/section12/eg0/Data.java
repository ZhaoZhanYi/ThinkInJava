package com.zzl.thinkinjava.chapter18.section12.eg0;

import java.io.Serializable;

public class Data implements Serializable {
    private int n;
    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
