
public class Main {

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args1) {
        int n = 42;

        double start = System.nanoTime();

        int result = fib(n);

        double time = (System.nanoTime() - start) / Math.pow(10, 6);

        System.out.println("fib(" + n + ") = " + result);
        System.out.println("Computation took " + time + "ms...");
    }
}