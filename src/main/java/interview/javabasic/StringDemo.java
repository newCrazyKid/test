package interview.javabasic;

public class StringDemo {

    public static boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if (length <= 2) {
            return true;
        }
        int k = coordinates[1][1] - coordinates[0][1];
        int b = coordinates[1][0] * coordinates[0][1] - coordinates[0][0] * coordinates[1][1];
        int c = coordinates[1][0] - coordinates[0][0];

        for (int i = 2; i < length; i++) {
            if (c * coordinates[i][1] != k * coordinates[i][0] + b) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{2, 1}, {4, 2}, {6, 3}};
        System.out.println(checkStraightLine(a));
    }
}
