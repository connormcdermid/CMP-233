package org.mcdermid;

import org.mcdermid.exception.ListException;
import org.mcdermid.interfaces.ListInterface;

public class Main {

    public static void main(String[] args) {
        ListInterface<String> mylst = new AList<String>(50);
        System.out.println("Mylist contains:\n" + mylst);
        try {
            mylst.add("Bread");
            mylst.add("Water");
            mylst.add("Eggs");
            mylst.add("Ground Beef");
        } catch (ListException e) {
            System.out.println(e);
        }
        System.out.println("Mylist contains:\n" + mylst);
        try {
            mylst.add("Milk");
        } catch (ListException e) {
            System.out.println(e);
        }
        System.out.println("Mylist now contains:\n" + mylst);
        String tmp = null;
        try {
            tmp = mylst.delete();
        } catch (ListException e) {
            System.out.println(e);
        }
        System.out.println("Deleted " + tmp + ".\nMylist now contains: " + mylst);
    }
}
