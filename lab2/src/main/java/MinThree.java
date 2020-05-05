/**
 * @author Anna
 */
public class MinThree {
    public static void main(String[] args) {

        System.out.println(min(1,2,3));
    }

    public static int min(int a, int b, int c) {
        int min = a;

        if (min > b || min > c) {
            if (b > c) {
                min = c;
            } else {
                min = b;
            }
        }

        return min;
    }
}
