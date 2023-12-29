package Graph;
import java.util.*;

// Kelas untuk merepresentasikan Graf Berarah
class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat graf baru
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Menambahkan node ke dalam adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge ke dalam graf (hanya satu arah untuk graf berarah)
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Metode untuk mendapatkan daftar tetangga dari suatu node
    public List<String> getNeighbors(String node) {

        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // method untuk Mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
           
              // Iterasi setiap tetangga dari node
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode utama untuk menjalankan contoh graf berarah
    public static void main(String[] args) {
         // Membuat objek graf
        DirectedGraph graph = new DirectedGraph();
        // Menambahkan node-node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

         // Menambahkan edge-edge ke dalam graf
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak struktur graf
        graph.printGraph();
    }
}