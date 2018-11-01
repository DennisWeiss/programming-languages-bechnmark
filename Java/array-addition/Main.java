

public class Main {

    public static void main(String[] args) {
        int size = (int) Math.pow(10, 7);

        float[] arr = new float[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (float) Math.random();
        }

        double start = System.nanoTime();

        for (int i = 0; i < size; i++) {
            arr[i] += 1.5f;
        }

        double time = (System.nanoTime() - start) / Math.pow(10, 6);

        System.out.println("Addition of " + size + " elements took " + time + "ms...");
    }
}