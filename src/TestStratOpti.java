import java.text.DecimalFormat;

public class TestStratOpti {
    
    private static double[] probabilites = new double[20];
    private static int[] des = new int[20];
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Stratégie optimale (Choisir le dé en fonction de n) :");
        System.out.println(" n : dé : gagnant %");
        remplirTab();
        for (int i = 0; i < probabilites.length; i++)
            System.out.println((i < 9 ? " ": "") + (i + 1) + " : " + des[i] + " : " + df.format(probabilites[i] * 100) + "%");
        System.out.println();
        
    }

    public static void remplirTab(){
        for(int i = 0; i < probabilites.length; i++){
            probabilites[i] = choisirDeOpti(i + 1);
        }
    }

    public static double choisirDeOpti(int n){
        double d4 = calcProba(4, n);
        double d6 = calcProba(6, n);
        double d8 = calcProba(8, n);
        if(d4 > d6 && d4 > d8){
            des[n - 1] = 4;
            return d4;
        }
        else if(d6 > d4 && d6 > d8){
            des[n - 1] = 6;
            return d6;
        }
        else{
            des[n - 1] = 8;
            return d8;
        }
    }

    public static double calcProba(int de, int n){
        double d = 0;
        for (int i = 1; i <= de; i++) {
            if (n - i == 0)
                d += 1;
            if (n - i > 0)
                d += probabilites[n - i - 1];
        }
        return d / de;
    }
}
