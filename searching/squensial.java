package searching;

import java.util.Scanner;

public class squensial{

    // membuat fungsi dari sequential untuk membuat nilai array nya dan target nya
    public static int sequentislsearch(int[] array, int target) {
        for (int i = 0; i< array.length; i++){ // Melakukan pengulangan dengan pencarian selama nilai awal tidak melebihi nilai akhir dan target

            // membuat kondisi jika nilai dari array (index) itu sama dengan angka yang dicari (target)
            if (array[i] == target) {
                // membuat fungsi mengembalikan nilai jika nilai yang dicari ditemukan
                return i;
            }
        }

        // membuat fungsi mengembalikan nilai jika tidak ada nilai didalam index
        return -1;

    }
    // membuat fungsi menampilkan data-data mulai dari index 0 sampai ke 9 beserta nilainya
    public static void main(String[] args) {
        int[] Data = {12,15,21,23,25,40,45,55,87,90};

        // membuat dan melanjutkan fungsi scanner untuk memasukkan input nilai index yang ingin dicari
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan Angka Yang Ingin Dicari: ");
        int target = scanner.nextInt();

        // membuat deklarasi isi index dengan tipe data integer
        int index = sequentislsearch(Data, target);

        // membuat kondisi tertentu untuk mencari index dan menentukan nilai nya
        if(index == -1){ // membuat kondisi jika nilai yang dicari itu tidak ada pada indeks maka target tidak ditemukan
            System.out.println("Target Tidak Ditemukan");
        } else { // membuat kondisi jika nilai yang dicari itu ada pada indeks maka target ditemukan
            System.out.println("Target Ditemukan pada index " + index);
        }
    }


}