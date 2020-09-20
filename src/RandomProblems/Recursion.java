package RandomProblems;

class Recursion {
    public static void main(String[] args) {
        System.out.println(sumOfIntsUpTo(6));
        System.out.println(recusiveMultiplication(4, 7));
        System.out.println(recursiveExponent(8, 2));
    }

    private static double recursiveExponent(int num1, int num2) {
        if (num2 == 0) {
            return 1;
        }
        if (num2 < 0) {
            num2 = Math.abs(num2);
            return 1 / recursiveExponent(num1, num2);
        }
        return num1 * recursiveExponent(num1, num2 - 1);
    }

    private static int recusiveMultiplication(int num1, int num2) {
        if (num1 == 0) {
            return 0;
        }
        return num2 + recusiveMultiplication(num1 - 1, num2);
    }

    public static int sumOfIntsUpTo(int limit) {
        int rtn = 0;
        if (limit == 0) {
            return 0;
        }
        return limit + sumOfIntsUpTo(limit - 1);
    }
}
