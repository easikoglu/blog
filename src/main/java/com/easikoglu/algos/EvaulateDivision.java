package com.easikoglu.algos;

import java.util.*;

public class EvaulateDivision {

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {

    Map<String, Map<String, Double>> graphMap = new HashMap<>();
    buildMap(equations, values, graphMap);
    double[] collect =
        queries.stream()
            .mapToDouble(
                strings -> {
                  String firstItem = strings.get(0);
                  String secondItem = strings.get(1);

                  return getPathWeight(graphMap, firstItem, secondItem, new HashSet<>());
                })
            .toArray();

    return collect;
  }

  private double getPathWeight(
      Map<String, Map<String, Double>> graphMap,
      String firstItem,
      String secondItem,
      Set<String> visited) {

    if (!graphMap.containsKey(firstItem)) {
      return -1.0;
    }
    if (graphMap.get(firstItem).containsKey(secondItem)) {
      return graphMap.get(firstItem).get(secondItem);
    }
    visited.add(firstItem);

    for (Map.Entry<String, Double> entry : graphMap.get(firstItem).entrySet()) {

      if (!visited.contains(entry.getKey())) {
        double pathWeight = getPathWeight(graphMap, entry.getKey(), secondItem, visited);
        if (pathWeight != -1.0) {
          return pathWeight * entry.getValue();
        }
      }
    }

    return -1.0;
  }

  private void buildMap(
      List<List<String>> equations, double[] values, Map<String, Map<String, Double>> graphMap) {

    for (int i = 0; i < equations.size(); i++) {
      List<String> firstPair = equations.get(i);

      String firstElement = firstPair.get(0);
      String secondElement = firstPair.get(1);
      double value = values[i];
      graphMap.putIfAbsent(firstElement, new HashMap<>());
      graphMap.get(firstElement).put(secondElement, value);
      graphMap.putIfAbsent(secondElement, new HashMap<>());
      graphMap.get(secondElement).put(firstElement, 1 / value);
    }
  }
}
