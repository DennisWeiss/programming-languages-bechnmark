import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = (int) Math.pow(10, 7);

        Float[] arr = new Float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (float) Math.random();
        }

        double start = System.nanoTime();

        Float[] arr2 = Arrays.stream(arr)
                .map(n -> n + 1.5f)
                .toArray(Float[]::new);

        double time = (System.nanoTime() - start) / Math.pow(10, 6);

        System.out.println("Addition of " + size + " elements took " + time + "ms...");
    }
}