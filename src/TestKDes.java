import java.text.DecimalFormat;

public class TestKDes {

    private static double[] probabilites = new double[20];
    private static int[] bestDie = new int[20];
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        getProba(3);
        print();
    }

    public static void print() {
        System.out.println(" n: win %  | Best die");
        for (int i = 0; i < probabilites.length; i++)
            System.out.println((i < 9 ? "0": "") + (i + 1) + ": "
            + df.format(probabilites[i] * 100) + "%"
            + " | " + bestDie[i]);
        System.out.println();
    }

    public static void getProba(int k) {
        for (int i = 0; i < 20; i++)
            for (int j = k; j <= 2 * k - 1; j++) {
                double proba = calcProba(j, i + 1);
                if (probabilites[i] <= proba) {
                    probabilites[i] = proba;
                    bestDie[i] = j;
                }
            }
    }

    public static double calcProba(int k, int n) {
        double d = 0;
        for (int i = 1; i <= k; i++) {
            if (n - i == 0)
                d += 1;
            if (n - i > 0)
                d += probabilites[n - i - 1];
        }
        return d / k;
    }
    
}
