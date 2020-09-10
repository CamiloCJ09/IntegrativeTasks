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
    public static String [] AssingValues(String [] nameOfMaterials){
        
        return nameOfMaterials;
    }
}
