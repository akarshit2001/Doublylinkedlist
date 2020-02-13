package Main;

import Defination.Defination;

public class Main {
    public static void main(String[] args) {
        Defination<Integer> def = new Defination<Integer>();
        def.add(45);
        def.add(47);
        def.add(898);
        def.add(982);
        def.add(896);
        System.out.println(def.toString());

    }
}
