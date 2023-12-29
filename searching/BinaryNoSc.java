package searching;

public class BinaryNoSc{
    // Metode Binary Search untuk mencari elemen dalam array.
    public static int binarySearch(int[] array, int target) {
        int low = 0; // membuat fungsi untuk menunjuk dan menentukan indeks pertama atau nilai awal dari data
        int high = array.length - 1; // membuat fungsi untuk menunjuk dan menentukan indeks terakhir atau nilai akhir dari data

        // Melakukan pencarian selama rentang pencarian masih valid.
        while (low <= high) {
            int mid = low + (high - low) / 2; // Menghitung posisi perkiraan nilai tengah (mid) untuk binary search.
            if (array[mid] == target) { // menampilkan kondisi jika array dari nilai tengah itu nilainya sama dengan nilai yang dicari(target)
                return mid; // Elemen ditemukan di indeks ini.
            } else if (array[mid] < target) { // menampilkan kondisi jika array dari nilai tengah itu nilainya lebih kecil dari nilai yang dicari(target)
                low = mid + 1; // Pencarian dilanjutkan ke sebelah kanan dari indeks tengah.
            } else { // menampilkan kondisi jika array dari nilai tengah itu nilainya lebih besar dari nilai yang dicari(target)
                high = mid - 1; // Pencarian dilanjutkan ke sebelah kiri dari indeks tengah.
            }
        }

        // Elemen tidak ditemukan dalam array.
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90}; // menampilkan urutan data-data yang ingin dicari (menampilkan indeks)
        int x = 25; // Nilai yang ingin dicari.

        // Memanggil metode binarySearch untuk mencari elemen target dalam array
        int indeks = binarySearch(arr, x);

        // membuat dan menampilkan hasil dari indeks
        if (indeks == -1) { // membuat kondisi jika nilai yang dicari itu tidak ada pada indeks maka target tidak ditemukan
            System.out.println("Element " + x + " tidak ditemukan ");
        } else { // membuat kondisi jika nilai yang dicari itu ada pada indeks maka target ditemukan
            System.out.println("element " + x + " ditemukan di index " + indeks);
        }
    }
}