package fr.florianclaisse.TD6.Models;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.stream.Stream;

public class Graph<T> {
    private final Set<Node<T>> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }
    
    public boolean isConnected() {
        if (nodes.size() == 0) {
            return true;
        }
        Node<T> node = nodes.iterator().next();
        Set<Node<T>> visited = new HashSet<>();
        dfs(node, visited);
        return visited.size() == nodes.size();
    }

    public Graph<T> aStart() {
        return null;
    }

    public void addNode(T data) { this.nodes.add(new Node<>(data)); }

    public Node<T> getNode(T data) {
        for (Node<T> node : this.nodes) {
            if (node.getData().equals(data)) return node;
        }
        return null;
    }

    public Set<Node<T>> getNodes() { return this.nodes; }

    private void dfs(Node<T> node, Set<Node<T>> visited) {
        visited.add(node);
        for (Node<T> neighbour : node.getNeighbours()) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited);
            }
        }
    }
}
