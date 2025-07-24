public class Main {
   public static void main(String[] args) {
        System.out.println("Hello World");
        int array[][] = {{1,2},{3,4,5},{0,-5}};
        System.out.println("ok");
        System.out.println(PracticeProblems.fib(6));
    }
    static void printIntArray(int[] arr) {
    String str = "(";
    for (int i = 0; i < arr.length; i++) {
        str += arr[i];
        if (i != arr.length - 1) {
            str += ", ";
        }
    }
    str += ")";
    System.out.println(str);
}
}