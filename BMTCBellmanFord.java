import java.util.*;

class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class BMTCBellmanFord {

    static final int INF = Integer.MAX_VALUE;

    static void bellmanFord(int V, List<Edge> edges, int source) {

        int[] dist = new int[V];

        Arrays.fill(dist, INF);

        dist[source] = 0;

        // V-1 Relaxations
        for (int i = 1; i <= V - 1; i++) {

            for (Edge e : edges) {

                if (dist[e.u] != INF &&
                    dist[e.u] + e.weight < dist[e.v]) {

                    dist[e.v] = dist[e.u] + e.weight;
                }
            }
        }

        // Negative Cycle Check
        for (Edge e : edges) {

            if (dist[e.u] != INF &&
                dist[e.u] + e.weight < dist[e.v]) {

                System.out.println("Negative Cycle Detected!");
                return;
            }
        }

        String[] hubs = {
            "MJC",
            "KEM",
            "JAY",
            "KOR",
            "WHF",
            "HBR",
            "MRT"
        };

        System.out.println("Shortest Distance from MJC:");

        for (int i = 0; i < V; i++) {
            System.out.println(
                hubs[i] + " : " + dist[i] + " min"
            );
        }
    }

    public static void main(String[] args) {

        int V = 7;

        List<Edge> edges = new ArrayList<>();

        // Graph Edges

        edges.add(new Edge(0, 1, 8));    // MJC -> KEM
        edges.add(new Edge(0, 2, 5));    // MJC -> JAY
        edges.add(new Edge(1, 3, 4));    // KEM -> KOR
        edges.add(new Edge(2, 3, 7));    // JAY -> KOR
        edges.add(new Edge(1, 5, 10));   // KEM -> HBR
        edges.add(new Edge(2, 5, 9));    // JAY -> HBR
        edges.add(new Edge(3, 4, 3));    // KOR -> WHF
        edges.add(new Edge(3, 6, 6));    // KOR -> MRT
        edges.add(new Edge(4, 6, -3));   // WHF -> MRT
        edges.add(new Edge(5, 4, 11));   // HBR -> WHF
        edges.add(new Edge(5, 6, 12));   // HBR -> MRT

        bellmanFord(V, edges, 0);
    }
}