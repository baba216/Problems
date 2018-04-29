package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

  private HashMap<Integer, Node> nodeLookup = new HashMap<>();


  private static class Node {

    private int id;
    LinkedList<Node> adjacent = new LinkedList<>();

    private Node(int id) {
      this.id = id;
    }
  }

  public void addEdge(int source, int destination) {
    Node s = getNode(source);
    Node d = getNode(destination);
    s.adjacent.add(d);
  }

  private Node getNode(int source) {
    return nodeLookup.get(source);
  }

  public boolean hasPathDFS(int source, int destination) {
    Node s = getNode(source);
    Node d = getNode(destination);
    HashSet<Integer> visited = new HashSet<>();
    return hasPathDFS(s, d, visited);
  }

  private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
    if (visited.contains(source.id)) {
      return false;
    } else {
      visited.add(source.id);
      if (source == destination) {
        return true;
      }
      for (Node child : source.adjacent) {
        if (hasPathDFS(child, destination, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean hasPathBHS(Node source, Node destination){
    LinkedList<Node> nextToVisit = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    nextToVisit.add(source);
    while (!nextToVisit.isEmpty()){
      Node node = nextToVisit.remove();
      if(node == destination){
        return true;
      }
      if(visited.contains(node.id)){
        continue;
      }
      visited.add(node.id);
      nextToVisit.addAll(node.adjacent);
    }
    return false;
  }
}