package fr.florianclaisse.TD6.Models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Graph<T> {
    private final Set<Node<T>> nodes;

    public Graph() {
        this.nodes = new HashSet<>();
    }

    public void addNode(T data) { this.nodes.add(new Node<>(data)); }

    public Node<T> getNode(T data) {
        Stream<Node<T>> stream = this.nodes.stream().filter(node -> node.getData() == data);
        if (stream.findFirst().isPresent()) { return stream.findFirst().get(); }
        else return null;
    }

    public Set<Node<T>> getNodes() { return this.nodes; }
}
