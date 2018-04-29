package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/contest/weekly-contest-75/problems/all-paths-from-source-to-target/
public class NumberOfPathsFromSourceToTarget {

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    //int[][] graph = {{},{0},{1},{3}};
    //int[][] graph = {{}};
    //int[][] graph = {{1},{0,2},{1,3},{2}}; --> cyclic
    int result = process(graph);
    System.out.println(result);
  }

  private static int process(int[][] graph) {
    Map<Integer, Node> nodeMap = new HashMap<>();
    for (int i = 0; i < graph.length; i++) {
      Node currentNode = nodeMap.get(i);
      if (currentNode == null) {
        currentNode = new Node(i);
        nodeMap.put(i, currentNode);
      }
      if (graph[i].length > 0) {
        currentNode.adjacentNode = new LinkedList<>();
        for (int j = 0; j < graph[i].length; j++) {
          Node destinationNode = nodeMap.get(graph[i][j]);
          if (destinationNode == null) {
            destinationNode = new Node(graph[i][j]);
            nodeMap.put(graph[i][j], destinationNode);
          }
          currentNode.adjacentNode.add(destinationNode);
        }
      }
    }
    /*nodeMap.forEach((integer, node) -> {
      System.out.println();
      System.out.println("TreeNode:" + integer);
      System.out.println("Values:");
      if (node.adjacentNodes != null) {
        node.adjacentNodes.forEach(node1 -> System.out.print(" " + node1.id));
      }
    });*/
    return numberOfDFSPath(nodeMap.get(0), nodeMap.get(graph.length - 1));
  }

  private static int numberOfDFSPath(Node source, Node destination) {
    //System.out.println("Function called with Source:" + source.id);
    if (source.id == destination.id) {
      return 1;
    }
    if (source.adjacentNode == null) {
      return 0;
    }
    int sum = 0;
    for (Node child : source.adjacentNode) {
      //System.out.println("Going to call function with child:" + child.id);
      int paths = numberOfDFSPath(child, destination);
      //System.out.println("Path Returned with child:"+child.id+",path:"+paths);
      sum += paths;
    }
    return sum;
  }

  private static class Node {
    int id;
    List<Node> adjacentNode;

    public Node(int id) {
      this.id = id;
    }

    @Override public String toString() {
      return "TreeNode{" + "id=" + id + ", adjacentNodes=" + adjacentNode + '}';
    }
  }

}
