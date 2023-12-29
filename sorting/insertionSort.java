package sorting;

public class insertionSort {
    // Fungsi untuk melakukan Insertion Sort pada array secara ascending
    static int[] insertion(int array[]) {
        int ukuran = array.length;
        int max, j;
        int i = 1;

        while (i < ukuran) {
            max = array[i];
            j = i;

            while (j > 0 && max < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }

            array[j] = max;
            i++;
        }
        return array;
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        System.out.println("Array sebelum diurutkan:");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        arr = insertion(arr);

        System.out.println("\nArray setelah diurutkan dengan Insertion Sort secara ascending:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}