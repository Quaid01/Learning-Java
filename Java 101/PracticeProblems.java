public class PracticeProblems {
    static int countOccurences(int[] array, int n) {
        int count = 0;
        for (int i : array) {
            if (i==n) {
                count += 1;
            }
        }
        return count;
    }
    static int[] reverseArray(int[] array) {
        int[] rev_arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            rev_arr[i] = array[array.length-i-1];
        }
        return rev_arr;
    }
    static int sumGrid(int[][] array) {
        int sum = 0;
        for (int[] n : array) {
            for (int k : n){
                sum += k;
            }
        }
        return sum;
    }
    static int fib(int n) {
        int last = 0;
        int current = 1;
        int next = last + current;
        for (int i = 0; i < n-1; i++) {
            last = current;
            current = next;
            next = last + current;
        }
        return last;
    }
}
