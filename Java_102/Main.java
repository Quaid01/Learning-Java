package Java_102;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Grid<Integer> grid = new Grid<>(5, 0);
        grid.set(2, 2, 4);
        grid.set(3, 3, 4);
        System.out.println(grid);
        System.out.println(grid.diagonal());
    }
}
