package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {44, 33, 55, 22, 11};
        int n = arr.length;
        // variabel untuk menyimpan nilai elemen yang akan ditukar
        int temp = 0;

        // memanggil array yang kita simpan/ sebelum diurutkan
        System.out.println("array sebelum di urutkan: ");
        for(int i=0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        //perulangan untuk pengurutan data
       //perulangan 1 untuk mengatur berapa kali melakukan perulangan
        for(int i=0; i < n; i++){
            //membandingkan dan jika perlu menukar elemen-elemen array yang berdekatan.
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("\nArray setelah diurutkan:");
        for(int i=0; i < n; i++){
            System.out.println(arr[i] + " ");
        }
    }
}