package sorting;

public class select{
    public static void main(String[] args) {
        int[] arr = {44, 33, 55, 22, 11};
        int n = arr.length;

        // Menampilkan array sebelum diurutkan
        System.out.println("Array sebelum diurutkan:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Memanggil metode selectionSort untuk mengurutkan array
        selectionSort(arr);

        // Menampilkan array setelah diurutkan
        System.out.println("\nArray setelah diurutkan:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Metode untuk melakukan pengurutan seleksi
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Mencari nilai terkecil dalam array yang belum terurut
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Menukar elemen terkecil dengan elemen pertama dalam array yang belum terurut
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
