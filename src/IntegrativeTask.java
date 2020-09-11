import java.util.Scanner;
public class IntegrativeTask {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int countOfItems = AskCountArticles(x);
        String [] nameOfMaterials = new String[x];
        double [] amountOfMaterials = new double[x];
        double [] priceOfMaterialsHomecenter = new double[x];
        double [] priceOfMaterialsDownTownGrocery = new double[x];
        double [] priceOfMaterialsNeihborhood = new double[x];
   
    }
    public static int AskCountArticles(int countOfItems) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How much materials do you want to buy?");
        countOfItems = sc.nextInt();
        return countOfItems;
    }
    public static String [] AssingValues(String [] nameOfMaterials,int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x;i++){
            nameOfMaterials[i] = sc.nextLine();
        }
        return nameOfMaterials;
    }
    public static double [] AssingAmount(double [] amountOfMaterials,int x){
        Scanner sc  = new Scanner(System.in);
        for(int i = 0; i<x ;i++){
            amountOfMaterials[i] = sc.nextDouble();
        }
        return amountOfMaterials;
    }
    public static double [] AssingPricesHomecenter(double [] pricesOfMaterialsInHomecenter, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            pricesOfMaterialsInHomecenter[i] = sc.nextDouble();
        }
        return pricesOfMaterialsInHomecenter;
    }
    public static double [] AssingPricesDownTownGrocery(double [] pricesOfMaterialsInDownTownGrocery, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x ; i++){
            pricesOfMaterialsInDownTownGrocery[i] = sc.nextDouble();
        }
    return pricesOfMaterialsInDownTownGrocery;
    }
    public static double [] AssingPricesNehiborhoodStore(double [] priceOfMaterialsNeihborhood, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            priceOfMaterialsNeihborhood[i] = sc.nextDouble();
        }
        return priceOfMaterialsNeihborhood;
    }
}
