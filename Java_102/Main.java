package Java_102;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LibraryItem[] thingies = {new Book("hi","1902","Bob",97), new DVD("Rad", "1928",1.28 )};
        thingies[0].checkOut();
        for (LibraryItem libraryItem : thingies) {
            System.out.println(libraryItem.available());
        }
        System.out.println(availableItems(thingies));
        returnAll(thingies);
        for (LibraryItem libraryItem : thingies) {
            System.out.println(libraryItem.available());
        }
    }

    static double sumArea(Shape[] shapes) {
    double sum = 0;
    for (Shape shape : shapes) {
        sum += shape.area();
    }
    return sum;
    }

    public static void returnAll(LibraryItem[] items) {
        for (LibraryItem thing : items) {
            thing.returnItem();
        }
    }

    public static ArrayList<LibraryItem> availableItems(LibraryItem[] items) {
        ArrayList<LibraryItem> things = new ArrayList<>(items.length);
        for (LibraryItem libraryItem : items) {
            if (libraryItem.available()){
                things.add(libraryItem);
            }
        }
        return things;
    }
}
