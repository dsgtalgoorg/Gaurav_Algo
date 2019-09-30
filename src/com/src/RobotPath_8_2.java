import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class RobotPath_8_2 {
    public List<String> robotPath(int[][] grid) {
        List<String> path = new ArrayList<>();
        Set<Point> visited = new HashSet<>();
        recurser(0, 0, path, grid.length - 1, grid[0].length - 1, false, grid, visited);
        System.out.println(path);
        return path;
    }

    private boolean recurser(int r, int c, List<String> path, int tgtR, int tgtC, boolean found, int[][] grid, Set<Point> visited) {
        System.out.println(">>>>>>>> r = " + r + " | c = " + c);
        Point currentPoint = new Point(c, r);
        visited.add(currentPoint);

        if (r == tgtR && c == tgtC) {
            return true;
        } else {
            if (!visited.contains(new Point(c + 1, r)) && !found && c < tgtC && grid[r][c + 1] != -1) {
                path.add("R");
                found = recurser(r, c + 1, path, tgtR, tgtC, found, grid, visited);
            }
            if (!visited.contains(new Point(c, r + 1)) && !found && r < tgtR && grid[r + 1][c] != -1) {
                path.add("D");
                found = recurser(r + 1, c, path, tgtR, tgtC, found, grid, visited);
            }

            if (!found) {
                System.out.println(">>>>>> deleting");
                path.remove(path.size() - 1);
            }

            return found;
        }
    }

    @Test
    public void test1() {
        int[][] grid = {
                { 0,  0, -1,  0},
                { 0, -1,  0, -1},
                { 0,  0, -1,  0},
                {-1,  0,  0,  0}
        };

        String[] expected = {"D", "D", "R", "D", "R", "R"};
        List<String> list = robotPath(grid);
        String[] output = list.toArray(new String[0]);

//        System.out.println(">>>>>>>>>> " + Arrays.toString(output));
        assertArrayEquals(expected, output);
    }

    @Test
    public void test2() {
        int[][] grid = {
                { 0,  0,  0, -1},
                { 0, -1,  0, -1},
                { 0,  0, -1,  0},
                {-1,  0,  0,  0}
        };

        String[] expected = {"D", "D", "R", "D", "R", "R"};
        List<String> list = robotPath(grid);
        String[] output = list.toArray(new String[0]);

//        System.out.println(">>>>>>>>>> " + Arrays.toString(output));
        assertArrayEquals(expected, output);
    }

    @Test
    public void test3() {
        int[][] grid = {
                //0   1   2   3   4
                { 0,  0,  0,  0, -1}, // 0
                { 0,  0,  0,  0,  0}, // 1
                {-1,  0, -1,  0,  0}, // 2
                {-1,  0,  0, -1, -1}, // 3
                {-1,  0,  0,  0,  0}  // 4
        };

        String[] expected = {"R", "D", "D", "D", "R", "D", "R", "R"};
        List<String> list = robotPath(grid);
        String[] output = list.toArray(new String[0]);

//        System.out.println(">>>>>>>>>> " + Arrays.toString(output));
        assertArrayEquals(expected, output);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(RobotPath_8_2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}

