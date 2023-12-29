package Graph;
import java.util.*;

// Kelas untuk merepresentasikan Graf Berbobot (Directed Graph)
class Edge {
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge berbobot
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk membuat graf baru
    public WeightedGraph() {
        // Inisialisasi adjacencyList sebagai HashMap
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graf
    public void addNode(String node) {
        // Menambahkan node ke dalam adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge berbobot ke dalam graf
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke node sumber
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Metode untuk mencetak struktur graf berbobot
    public void printGraph() {
        // Iterasi setiap node dalam graf
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");

            // Iterasi setiap edge dari node
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();  // Pindah baris setelah mencetak edge dari suatu node
        }
    }

    // Metode utama untuk menjalankan contoh graf berbobot
    public static void main(String[] args) {
        // Membuat objek graf berbobot
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan node-node ke dalam graf
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge berbobot ke dalam graf
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak struktur graf berbobot
        graph.printGraph();
    }
}
