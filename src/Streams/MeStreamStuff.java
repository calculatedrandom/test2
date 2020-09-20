package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MeStreamStuff {

    public static void main(String[] args) {
        Integer[][] arr2D = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print2d(arr2D);
        System.out.println();

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        //Stream<String[]>
        print2d(data);
        Stream<String[]> temp = Arrays.stream(data);
        //Stream<String>, GOOD!
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
        stringStream.forEach(System.out::print);
        System.out.println();
        System.out.println();


        print2d(testStream());
        System.out.println();
        Integer[][] dest = new Integer[2][2];
        print2d(testStream(dest, arr2D,1,2));
    }

    static <T> T[][] testStream(T[][] destination, T[][] source,int startPos,int endPos) {
        IntStream.range(startPos, endPos).forEach(x ->
                IntStream.range(startPos, endPos).forEach(y ->
                        destination[endPos-x][endPos-y] = source[x][y]));
        return destination;
    }

    static String letters = "abcdefghijklmnopqrstuvwxyz";

    static String[][] testStream() {
        String[][] array = new String[3][3];
        IntStream.range(0, array.length).forEach(x ->
                IntStream.range(0, array[x].length).forEach(y ->
                        array[x][y] = String.format("%c%c", letter(x), letter(y)) + " "));
        return array;
    }

    public static char letter(int i) {
        return letters.charAt(i);
    }

    private static void printList(List<int[]> collect) {
        for (int[] arr : collect) {
            for (int item : arr) {
                System.out.print(item);
            }
            System.out.println();
        }
    }

    private static <T> void print2d(T[][] arr2D) {
        for (T[] arr : arr2D) {
            for (T item : arr) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
