package org.mcdermid;

import org.mcdermid.exception.ListException;
import org.mcdermid.interfaces.ListInterface;

import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ListInterface<House> hlist = new AList<>(5);
        System.out.println("List created. Contents: " + hlist);
        try {
            hlist.add(new House("31 Main", 300000d));
            hlist.add(new House("50 Central", 357000d));
            hlist.add(new House("8 Jarrison", 600000));
        } catch (ListException e) {
            System.out.println(e);
        }
        System.out.println("The contents of the list are:");
        System.out.println(hlist);

        //testing insert
        try {
            hlist.insert(2, new House("10 East", 800000d));
        } catch (ListException e) {
            System.out.println(e);
        }

        //testing ability of insert() to handle exceptional conditions
        ListInterface<House> yList = new AList<>(3);
        try {
            yList.insert(1, new House("doesn't matter", 11));
        } catch (ListException e) {
            System.out.println("Success!");
            System.out.println(e);
        }
        try {
            hlist.insert(8, new House("also doesn't matter", 45));
        } catch (ListException e) {
            System.out.println("Success 2 Electric Boogaloo!");
            System.out.println(e);
        }
        try {
            hlist.insert(1, null);
        } catch (ListException e) {
            System.out.println("Success 3");
            System.out.println(e);
        }

    }
}
