package Graph;

import java.util.*;
// Kelas Sisi merepresentasikan sisi dalam graf. Setiap sisi memiliki tujuan (destination) dan bobot (weight).// Kelas Sisi merepresentasikan sisi dalam graf. Setiap sisi memiliki tujuan (destination) dan bobot (weight).
class Sisi {
    String destination;  // Node tujuan sisi
    int weight;          // Bobot sisi

    // Konstruktor untuk membuat sisi baru dengan tujuan dan bobot tertentu.
    public Sisi(String destination, int weight) {
        this.destination = destination; 
        this.weight = weight;
    }
}

// Kelas DijkstraGraphTraversal mengimplementasikan algoritma Dijkstra untuk mencari jarak terpendek dalam graf.
public class DijkstraGraphTraversal {
    // Map adjacencyList menyimpan daftar tetangga setiap node berserta bobot sisi.
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    // Metode untuk menambahkan node ke graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan sisi (edge) ke graf dengan sumber, tujuan, dan bobot tertentu.
    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        // Tambahkan sisi ke daftar tetangga node sumber dengan tujuan dan bobot yang sesuai.
        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    // Metode untuk menjalankan algoritma Dijkstra dan mengembalikan jarak terpendek dari node awal ke node tujuan.
    public int dijkstra(String start, String end) {
        // PriorityQueue untuk menyimpan pasangan (node, jarak) dengan prioritas berdasarkan jarak terpendek.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        // Map distances menyimpan jarak terpendek dari node awal ke setiap node lainnya.
        Map<String, Integer> distances = new HashMap<>();

        // Set settled menyimpan node yang sudah diproses.
        Set<String> settled = new HashSet<>();

        // Inisialisasi jarak dari node awal ke semua node lainnya dengan nilai tak terhingga.
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        // Jarak dari node awal ke dirinya sendiri adalah 0.
        distances.put(start, 0);

        // Tambahkan node awal ke PriorityQueue.
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        // Algoritma Dijkstra
        while (!pq.isEmpty()) {
            // Ambil node dengan jarak terpendek dari PriorityQueue.
            String current = pq.poll().getKey();

            // Jika node yang diambil adalah node tujuan, kembalikan jaraknya.
            if (current.equals(end)) {
                return distances.get(end);
            }

            // Jika node sudah diproses, lanjut ke iterasi berikutnya.
            if (settled.contains(current)) {
                continue;
            }

            // Tandai node sebagai sudah diproses.
            settled.add(current);

            // Iterasi melalui semua tetangga dari node saat ini.
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                // Jika tetangga belum diproses.
                if (!settled.contains(edge.destination)) {
                    // Hitung jarak baru.
                    int newDistance = distances.get(current) + edge.weight;

                    // Jika jarak baru lebih kecil dari jarak yang sudah tersimpan.
                    if (newDistance < distances.get(edge.destination)) {
                        // Update jarak terpendek ke tetangga.
                        distances.put(edge.destination, newDistance);

                        // Tambahkan tetangga ke PriorityQueue untuk diproses lebih lanjut.
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        // Jika tidak ada jalur dari node awal ke node tujuan, kembalikan nilai tak terhingga.
        return distances.get(end);
    }

    // Metode main untuk menjalankan algoritma Dijkstra dan menampilkan hasilnya.
    public static void main(String[] args) {
        // Membuat objek dari kelas DijkstraGraphTraversal.
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();
        
        // Tambahkan sisi-sisi ke graf sesuai kebutuhan.
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);
        
        // Menjalankan algoritma Dijkstra dari node "A" ke node "E" dan menampilkan hasilnya.
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari Node Awal ke Node Akhir adalah " + distance);
    }
}
