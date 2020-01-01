import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/** https://www.hackerrank.com/challenges/greedy-florist/problem */
public class Solution {

    static int getMinimumCost(int k, int[] c) {
        int totalCost = 0;

        ArrayList<Integer> priceList = new ArrayList<Integer>();
        for (int price : c) {
            priceList.add(price);
        }
        priceList.sort(Collections.reverseOrder());

        for (int i = 0; i < priceList.size(); i++) {
            int multiplier = (int) (i / k);
            totalCost += priceList.get(i) * (multiplier + 1);
        }
        return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
