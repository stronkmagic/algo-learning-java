package algoexpert;

import java.util.*;

public class TaskAssignment {

    public static void main(String[] args) {

        int testK = 3;
        ArrayList<Integer> testTasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));

        long startTime2 = System.nanoTime();
        taskAssignmentQueue(testK, testTasks);
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long startTime = System.nanoTime();
        taskAssignment(testK, testTasks);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);
    }

    public static ArrayList<ArrayList<Integer>> taskAssignmentQueue(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> taskAssignments = new ArrayList<ArrayList<Integer>>();
        long startTime2 = System.nanoTime();
        HashMap<Integer, ArrayList<Integer>> indiciesMap = getIndicesMap(tasks);
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long startTime = System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(tasks);
        //priorityQueue.addAll(tasks);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        long startTime1 = System.nanoTime();
        int count = 0;
        while (!priorityQueue.isEmpty() && count < k) {

            int task = priorityQueue.poll();
            ArrayList<Integer> taskIndexes = indiciesMap.get(task);
            int taskIdx = taskIndexes.remove(taskIndexes.size() - 1);
            ArrayList<Integer> workerTasks = new ArrayList<>();
            workerTasks.add(taskIdx);
            taskAssignments.add(workerTasks);
            count++;
        }


        for (int i = taskAssignments.size() - 1; i >= 0; i--) {
            int task = priorityQueue.poll();
            ArrayList<Integer> taskIndexes = indiciesMap.get(task);
            int taskIdx = taskIndexes.remove(taskIndexes.size() - 1);
            ArrayList<Integer> workerTasks = taskAssignments.get(i);
            workerTasks.add(taskIdx);
            count++;
        }
        long stopTime1 = System.nanoTime();
        System.out.println(stopTime1 - startTime1);

        return taskAssignments;
    }

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        ArrayList<ArrayList<Integer>> taskAssignments = new ArrayList<ArrayList<Integer>>();
        long startTime2 = System.nanoTime();
        HashMap<Integer, ArrayList<Integer>> indiciesMap = getIndicesMap(tasks);
        long stopTime2 = System.nanoTime();
        System.out.println(stopTime2 - startTime2);

        long startTime = System.nanoTime();
        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        long startTime1 = System.nanoTime();
        for (int idx = 0; idx < k; idx++) {
            int task1 = sortedTasks.get(idx);
            ArrayList<Integer> task1Indexes = indiciesMap.get(task1);
            int task1Idx = task1Indexes.remove(task1Indexes.size() - 1);
            int task2 = sortedTasks.get(sortedTasks.size() - 1 - idx);
            ArrayList<Integer> task2Inexes = indiciesMap.get(task2);
            int task2Idx = task2Inexes.remove(task2Inexes.size() - 1);
            ArrayList<Integer> workerTasks = new ArrayList<>();
            workerTasks.add(task1Idx);
            workerTasks.add(task2Idx);
            taskAssignments.add(workerTasks);
        }
        long stopTime1 = System.nanoTime();
        System.out.println(stopTime1 - startTime1);

        return taskAssignments;
    }

    private static HashMap<Integer, ArrayList<Integer>> getIndicesMap(ArrayList<Integer> tasks) {
        HashMap<Integer, ArrayList<Integer>> indicesMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int idx = 0; idx < tasks.size(); idx++) {
            Integer taskDuration = tasks.get(idx);
            if (indicesMap.containsKey(taskDuration)) {
                indicesMap.get(taskDuration).add(idx);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(idx);
                indicesMap.put(taskDuration, tmp);
            }
        }
        return indicesMap;
    }
}
//8+8+7+10+8+7 = 49