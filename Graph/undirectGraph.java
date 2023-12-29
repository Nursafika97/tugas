package Graph;

import java.util.*;

// Kelas untuk merepresentasikan Graf Tidak Berarah
class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat graf baru
    public UndirectedGraph() {
        // Inisialisasi adjacencyList sebagai HashMap
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Menambahkan node ke dalam adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge ke dalam graf (tambahkan di kedua arah untuk graf tidak terarah)
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode untuk mendapatkan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dari node, atau daftar kosong jika node tidak ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk mencetak struktur graf
    public void printGraph() {
        // Iterasi setiap node dalam graf
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");

            // Iterasi setiap tetangga dari node
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();  // Pindah baris setelah mencetak tetangga dari suatu node
        }
    }

    // Metode utama untuk menjalankan contoh graf tidak terarah
    public static void main(String[] args) {
        // Membuat objek graf
        UndirectedGraph graph = new UndirectedGraph();

        // Menambahkan node-node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge ke dalam graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak struktur graf
        graph.printGraph();
    }
}
