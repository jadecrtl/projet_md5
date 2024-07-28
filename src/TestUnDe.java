import java.text.DecimalFormat;

public class TestUnDe {

    private static double[] probabilites;
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // Dé 4 :
        probabilites = new double[20];
        getProba(4);
        System.out.println("Dé à 4 faces :");
        System.out.println(" n: win %");
        print();
        
        // Dé 6 :
        probabilites = new double[20];
        getProba(6);
        System.out.println("Dé à 6 faces :");
        System.out.println(" n: win %");
        print();
        
        // Dé 8 :
        probabilites = new double[20];
        getProba(8);
        System.out.println("Dé à 8 faces :");
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
    public static void getProba(int de) {
        for (int i = 0; i < 20; i++) {
            if (probabilites[i] == 0) {
                probabilites[i] = calcProba(de, i + 1);
            }
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
            d += calcProba(de, n - i);
        return d / de;
    }
    
}
