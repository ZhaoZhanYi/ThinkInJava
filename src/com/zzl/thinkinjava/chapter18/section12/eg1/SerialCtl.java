package com.zzl.thinkinjava.chapter18.section12.eg1;

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient : " + bb;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        System.out.println("SerialCtl readObject");

        stream.defaultReadObject();
//        b = (String) stream.readObject();
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        System.out.println("SerialCtl writeObject");

        stream.defaultWriteObject();
//        stream.writeObject(b);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl ctl = new SerialCtl("feibai", "123");
        System.out.println("Before:\n" + ctl);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("f.txt"));
        out.writeObject(ctl);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
        SerialCtl clt2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + clt2);

    }

}
