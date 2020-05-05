
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

/**
 * @author Anna
 */
public class SimpleSwap {

    private static Log log = LogFactory.getLog(SimpleSwap.class.getName());

    final static Random random = new Random();

    public static void main(String[] args) {

        try {
            int size = 10;
            int[] array = new int[size];

            fillArray(array);
            printArray(array);

            System.out.println(swap(1,4, array));

            printArray(array);
        } catch(NegativeArraySizeException e) {
            log.error(e, e.fillInStackTrace());
        } catch(ArrayIndexOutOfBoundsException e) {
            log.error(e, e.fillInStackTrace());
        }
    }

    public static boolean swap(int i, int j, int[] anArray) {
        if (i < anArray.length && j < anArray.length && i > -1 && j > -1) {
            int temp = anArray[i];
            anArray[i] = anArray[j];
            anArray[j] = temp;

            return true;
        } else {
            return false;
        }
    }

    public static void fillArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            anArray[i] = random.nextInt(100);
        }
    }

    public static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            System.out.printf("%4d", anArray[i]);
        }
        System.out.println();
    }
}
