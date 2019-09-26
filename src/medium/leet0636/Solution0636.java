package medium.leet0636;

import java.util.List;
import java.util.Stack;

public class Solution0636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        int id, startTime, endTime, runTime;
        for (String log : logs) {
            String[] split = log.split(":");
            if ("start".equals(split[1])) {
                id = Integer.parseInt(split[0]);
                startTime = Integer.parseInt(split[2]);
                stack.push(new int[]{id, startTime});
            } else if ("end".equals(split[1])){
                int[] pop = stack.pop();
                id = pop[0];
                startTime = pop[1];
                endTime = Integer.parseInt(split[2]);
                runTime = endTime - startTime + 1;
                res[id] += runTime;

                if (!stack.empty()) {
                    int topId = stack.peek()[0];
                    res[topId] -= runTime;
                }
            }
        }
        return res;
    }
}
