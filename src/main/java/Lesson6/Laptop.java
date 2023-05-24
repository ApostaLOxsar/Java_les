package Lesson6;

public class Laptop {
    String name;
    Integer ram;
    Integer sizeHdd;
    String nameOS;
    String color;

    /* Есть ли неообходимость в таком решении?
    public String name() {
        return name;
    }*/

    @Override
    public String toString() {
        return String.format("Name: %s\t\tRam: %d\t\tSizeHDD: %d\t\tName OS: %s\t\tColor: %s",name, ram, sizeHdd, nameOS, color);
    }
}

