package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/contest/weekly-contest-79/problems/bus-routes/
// WA
public class BusRoutes {

  public static void main(String[] args) {
    //int[][] routes = {{1, 2, 7}, {3, 6, 7}}; output : 2
//    int S = 1;
  //  int T = 6;

    /*int[][] routes = {{1,2,3,4,5}};
    int S = 1;
    int T = 5;*/

    int[][] routes = {{1,2,3,4,5},{1,2,5,7}};
    int S = 1;
    int T = 7;

    List<Integer> numberOfBuses = process(routes, S, T);
    int min = Integer.MAX_VALUE;
    for (Integer numberOfBus : numberOfBuses) {
      if(numberOfBus < min){
        min = numberOfBus;
      }
    }
    System.out.println(min);
  }

  private static List<Integer> process(int[][] routes, int S, int T) {
    // creating graph
    Graph graph = new Graph();
    for (int busNumber = 0; busNumber < routes.length; busNumber++) {
      int[] busRoute = routes[busNumber];
      for (int j = 1; j < busRoute.length; j++) {
        // add node from
        int source = busRoute[j - 1];
        int destination = busRoute[j];
        graph.addEdge(source, destination, busNumber);
      }
      graph.addEdge(busRoute[busRoute.length - 1], busRoute[0], busNumber);
    }
    GraphNode source = graph.nodeLookUp.get(S);
    GraphNode destination = graph.nodeLookUp.get(T);
    List<Integer> minNumberOfBus = new LinkedList<>();
    graph.findMinNumberOfBuses(source, destination, new HashSet<>(), 0, -1, minNumberOfBus);
    return minNumberOfBus;
  }


  private static class GraphNode {
    int id;
    List<WeightedGraphEdge> adjacentNodes;

    public GraphNode(int id) {
      this.id = id;
      this.adjacentNodes = new LinkedList<>();
    }
  }


  private static class WeightedGraphEdge {
    GraphNode id;
    int busNumber;

    public WeightedGraphEdge(GraphNode destination, int busNumber) {
      this.id = destination;
      this.busNumber = busNumber;
    }
  }


  private static class Graph {

    private Map<Integer, GraphNode> nodeLookUp = new HashMap<>();

    public void addEdge(int source, int destination, int busNumber) {
      GraphNode sourceNode = nodeLookUp.getOrDefault(source, new GraphNode(source));
      GraphNode destinationNode = nodeLookUp.getOrDefault(destination, new GraphNode(destination));
      WeightedGraphEdge weightedGraphEdge = new WeightedGraphEdge(destinationNode, busNumber);
      sourceNode.adjacentNodes.add(weightedGraphEdge);
      nodeLookUp.putIfAbsent(source,sourceNode);
      nodeLookUp.putIfAbsent(destination,destinationNode);
    }

    public boolean findMinNumberOfBuses(GraphNode source, GraphNode destination,
        Set<Integer> visited, int numberOfBuses, int prevBus, List<Integer> minNumberOfBus) {
      if (visited.contains(source.id)) {
        return false;
      }
      visited.add(source.id);
      if (destination.id == source.id) {
        return true;
      }
      for (WeightedGraphEdge sibling : source.adjacentNodes) {
        if (prevBus != sibling.busNumber) {
          prevBus = sibling.busNumber;
          numberOfBuses++;
        }
        if (findMinNumberOfBuses(sibling.id, destination, visited, numberOfBuses, sibling.busNumber,
            minNumberOfBus)) {
          minNumberOfBus.add(numberOfBuses);
        }
      }
      return false;
    }
  }
}
