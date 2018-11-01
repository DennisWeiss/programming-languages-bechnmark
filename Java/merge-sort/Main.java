import java.util.concurrent.ThreadLocalRandom;


public class Main {

    static final int size = 1000000;

    public static void main(String args[]) {
        int a[] = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = ThreadLocalRandom.current().nextInt(0, 100000);
        }

        double start = System.nanoTime();

        sort(a);

        double time = (System.nanoTime() - start) / Math.pow(10, 6);

        System.out.println("Sorting " + size + " elements took " + time + "ms...");
    }

    public static void sort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int a[], int low, int high) {
        int mid = (low + high) / 2;
        if (low + 1 < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
        }
        if (low < high) {
            merge(a, low, mid, high);
        }
    }

    private static void merge(int a[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;

        int temp[] = new int[high - low + 1];
        for (int index = 0; index < temp.length; index++) {
            temp[index] = a[low + index];
        }

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }

        int l = low;
        int m = 0;

        while (l <= high) {
            a[l] = temp[m];
            l++;
            m++;
        }
    }
}