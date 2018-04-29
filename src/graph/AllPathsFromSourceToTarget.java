package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-75/problems/all-paths-from-source-to-target/
public class AllPathsFromSourceToTarget {

  public static void main(String[] args) {
    int[][] graph = {{1, 2}, {3}, {3}, {}};
    //int[][] graph = {{},{0},{1},{3}};
    //int[][] graph = {{}};
    //int[][] graph = {{1},{0,2},{1,3},{2}}; --> cyclic
    List<List<Integer>> result = process(graph);
    System.out.println(result);
  }

  private static List<List<Integer>> process(int[][] graph) {
    List<List<Integer>> paths = new LinkedList<>();
    getDFSPath(graph, 0, graph.length - 1, new ArrayList<>(), paths);
    return paths;
  }

  private static Boolean getDFSPath(int[][] graph, int source, int destination,
      List<Integer> path, List<List<Integer>> paths) {
    path.add(source);
    if (source == destination) {
      return true;
    }
    if (graph[source].length == 0) {
      return false;
    }
    for (int i = 0; i < graph[source].length; i++) {
      List<Integer> newPath = new LinkedList<>(path);
      if (getDFSPath(graph, graph[source][i], destination, newPath,paths)) {
        paths.add(newPath);
      }
    }
    return false;
  }
}
