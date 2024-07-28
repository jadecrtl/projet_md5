import java.text.DecimalFormat;

public class TestPlusGRandDe {

    private static double[] probabilites = new double[20];
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        getProba();
        System.out.println("Dé avec le + de faces :");
        System.out.println(" n: win %");
        print();
    }

    /**
     * Affiche le tableau
     */
    public static void print() {
        for (int i = 0; i < probabilites.length; i++)
            System.out.println((i < 9 ? "0": "") + (i + 1) + ": " + df.format(probabilites[i] * 100) + "%");
        System.out.println();
    }

    /**
     * Rempli le tableau avec les probabilités en fonction du nombre
     * de faces du dé
     * @param de Le nombre de faces du dé
     */
    public static void getProba() {
        for (int i = 0; i < 20; i++) {
            if (probabilites[i] == 0) {
                probabilites[i] = chooseDe(i + 1);
            }
        }
    }

    /**
     * Renvoie le dé à utiliser en fonction de n
     * @param n Le nombre ciblé
     */
    public static double chooseDe(int n) {
        int de = 0;
        if (n > 8) {
            de = 8;
            return calcProba(de, n);
        }
        else if (n > 6) {
            de = 6;
            return calcProba(de, n);
        }
        else {
            de = 4;
            return calcProba(de, n);
        }
    }


    /**
     * Renvoie la probabilité de gagner le jeu en fonction de n et du dé
     * @param de Le nombre de faces du dé
     * @param n Le nombre ciblé
     * @return La probabilité de victoire
     */
    public static double calcProba(int de, int n) {
        if (n < 0)
            return 0;
        
        if (n == 0)
            return 1;
        
        double d = 0;
        for (int i = 1; i <= de; i++)
            d += chooseDe(n - i);
        return d / de;
    }
    
}
