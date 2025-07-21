public class Main {
   public static void main(String[] args) {
        System.out.println("Hello World");
        int array[] = {1,1,3};
        int k = 1;
        System.out.println(PracticeProblems.countOccurences(array, k));
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