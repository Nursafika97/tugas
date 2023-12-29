package Graph;

import java.util.*;

class Edge implements Comparable<Edge> {
    String source;
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge berbobot
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        // Mengimplementasikan metode compareTo untuk mengurutkan edge berdasarkan bobotnya
        return Integer.compare(this.weight, other.weight);
    }
}

public class PrimGraphTraversal {

    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk membuat objek graph
    public PrimGraphTraversal() {
        // Inisialisasi adjacencyList sebagai HashMap
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan node baru ke dalam graph
    public void addNode(String node) {
        // Menambahkan node ke dalam adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan edge berbobot ke dalam graph
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge berbobot dan tambahkan edge sebaliknya untuk graph tidak terarah
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight));
    }

    // Metode untuk mendapatkan daftar tetangga dan bobot dari suatu node
    public List<Edge> getNeighbors(String node) {
        // Mengembalikan daftar tetangga dan bobot dari node, atau daftar kosong jika node tidak ditemukan
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Algoritma Prim untuk mencari Minimum Spanning Tree (MST)
    public void primMST(String start) {
        // PriorityQueue untuk memilih edge dengan bobot terkecil
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> inMST = new HashSet<>();
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan node awal
        inMST.add(start);
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }

        int totalWeight = 0; // Variabel untuk menyimpan total bobot MST
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination)) continue;

            inMST.add(edge.destination);
            System.out.println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");
            totalWeight += edge.weight; // Menambahkan bobot edge ke total bobot MST

            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot MST
    }

    // Metode utama untuk menjalankan contoh graph dengan algoritma Prim
    public static void main(String[] args) {
        PrimGraphTraversal graph = new PrimGraphTraversal();

        // Menambahkan node-node ke dalam graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // Menambahkan edge-edge berbobot ke dalam graph
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);

        // Menjalankan algoritma Prim dengan node awal "A"
        graph.primMST("A");
    }
}
