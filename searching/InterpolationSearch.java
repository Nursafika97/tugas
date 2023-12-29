package searching;

public class InterpolationSearch {
    
    static int found;
    public static void main(String[] args) {
        // Contoh array string yang sudah diurutkan
        String[] sortedArray = {"Anjing", "Ayam", "Kucing", "Kelinci", "Kuda", "Sapi", "Singa", "Zebra"};

        // Menambahkan data ke dalam array
        addData("Kucing", sortedArray, 2);
        addData("Ayam", sortedArray, 1);
        addData("Kelinci", sortedArray, 3);

        // Melakukan pencarian string "Kelinci"
        boolean result = interpolation(sortedArray, "Kelinci");

        // Menampilkan hasil pencarian
        if (result) {
            System.out.println("String Kelinci ditemukan di index: " + getfound());
        } else {
            System.out.println("String Kelinci tidak ditemukan.");
        }
    }

    private static boolean interpolation(String[] sortedArray, String string) {
        return false;
    }

    static void addData(String data, String[] array, int index) {
        System.out.println("Data " + data + " ditambahkan di index: " + index);
        // Tambahkan logika sesuai kebutuhan untuk menambahkan data ke dalam array
        // Sebagai contoh, kita hanya mencetak pesan di sini.
    }
 // Metode pencarian interpolasi untuk array integer
    static boolean interpolation(int[] array, int find)
{
       boolean hasil= false;
       int high= array.length-1;
       int low=0;
       int mid;

       // Algoritma pencarian interpolasi
       while(low<high)
      {
        mid= low+(high-low)* ((find-array[low])/ (array[high]-array[low]));
        if (mid>high)
            mid=high;

         // Memeriksa apakah string ditemukan pada indeks mid
        if (find==array[mid])    
        {
            hasil =true;
            found=mid;
            break;
        } else if (find> array[mid])
               low=mid+1;
        else 
            high=mid-1;
      }
      return hasil;
    }
     // Metode untuk mendapatkan indeks tempat elemen ditemukan
    static int getfound()
    {
        return found;
    }
}
 