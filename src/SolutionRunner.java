package src;

import src.solutions.ConvertToString;
import src.solutions.IterateOverList;
import src.solutions.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionRunner {
    public static void main(String[] args) {
        Solution[] strategies =
                new Solution[]{
                        new ConvertToString(),
                        new IterateOverList(),
                };
        var input = new ListNode[][]{
                // test cases
                new ListNode[]{
                        listToListNode(Collections.singletonList(1)),
                        listToListNode(Collections.singletonList(2))
                },
                new ListNode[]{
                        listToListNode(Collections.singletonList(9)),
                        listToListNode(Collections.singletonList(9))
                },
                new ListNode[]{
                        listToListNode(Arrays.asList(1, 2, 3, 4)),
                        listToListNode(Arrays.asList(1, 2, 3, 4))
                },
                new ListNode[]{
                        listToListNode(Arrays.asList(9, 9, 9, 9)),
                        listToListNode(Collections.singletonList(1))
                },
                new ListNode[]{
                        listToListNode(Arrays.asList(9, 9, 9, 9)),
                        listToListNode(Arrays.asList(2, 0, 0, 0, 1))
                },
        };
        var output = new ListNode[]{
                listToListNode(Collections.singletonList(3)),
                listToListNode(Arrays.asList(8, 1)),
                listToListNode(Arrays.asList(2, 4, 6, 8)),
                listToListNode(Arrays.asList(0, 0, 0, 0, 1)),
                listToListNode(Arrays.asList(1, 0, 0, 0, 2))
        };
        ListNode result;
        int errors = 0;
        int nTestCases = input.length;
        for (Solution s : strategies) {
            for (int i = 0; i < nTestCases; i++) {
                result = s.solve(input[i][0], input[i][1]);
                if(!output[i].equals(result)) {
                    System.out.println("Solution " + s.getClass().getName() + " wrong for input " + Arrays.toString(input[i]));
                    System.out.println("Expected: " + output[i] + " but got: " + result);
                    System.out.println();
                    errors++;
                }
            }
        }
        printResults(errors, nTestCases);
    }

    private static ListNode listToListNode(List<Integer> list) {
        if(list == null){
            return null;
        }
        if(list.size() == 1){
            return new ListNode(list.get(0));
        }
        ListNode listNode = new ListNode(list.get(0));
        listNode.next = listToListNode(list.subList(1,list.size()));
        return listNode;
    }

    private static void printResults(int errors, int nTestCases) {
        if(errors == 0) {
            System.out.println("All tests passed!");
        } else {
            System.out.println(errors + " tests failed.");
            System.out.println(nTestCases - errors + " tests passed.");
            System.out.println((0.0 + nTestCases - errors) / nTestCases * 100  + "% of tests passed.");
        }
    }
}

