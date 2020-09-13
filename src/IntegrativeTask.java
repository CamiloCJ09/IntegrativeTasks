import java.util.Scanner;
public class IntegrativeTask {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = AskCountArticles();
        
        String [] nameOfMaterials = new String[x];
        double [] amountOfMaterials = new double[x];
        double [] priceOfMaterialsHomecenter = new double[x];
        double [] priceOfMaterialsDownTownGrocery = new double[x];
        double [] priceOfMaterialsNeihborhood = new double[x];

        //Calls
        Object [] array = new Object[x]; //We use this array to say the type of work
        
        nameOfMaterials = NameOfObjets(nameOfMaterials, x);
        amountOfMaterials = AssingAmount(amountOfMaterials, nameOfMaterials, x);
        array = TypeOfWorks(array,nameOfMaterials,x);
        priceOfMaterialsHomecenter = AssingPricesHomecenter(amountOfMaterials, nameOfMaterials, x);
        priceOfMaterialsDownTownGrocery = AssingPricesDownTownGrocery(amountOfMaterials, nameOfMaterials, x);
        priceOfMaterialsNeihborhood = AssingPricesNehiborhoodStore(amountOfMaterials, nameOfMaterials, x);


        /*for(int i = 0; i<x;i++){
            System.out.println(nameOfMaterials[i]); //Imprimir los el tipo de obra que va a ser
        }
        */

    }

    public static int AskCountArticles() {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much materials do you want to buy?");
        x = sc.nextInt();
        return x;
    }
    public static String [] NameOfObjets(String [] nameOfMaterials,int x) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x;i++){
            System.out.println("Imput the name of the material "+(i+1));
            nameOfMaterials[i] = sc.nextLine();
        }
        return nameOfMaterials;
    }
    public static double [] AssingAmount(double [] amountOfMaterials,String [] nameOfMaterials,int x){
        Scanner sc  = new Scanner(System.in);
        for(int i = 0; i<x ;i++){
            System.out.println("How much "+nameOfMaterials[i]+" do you want?");
            amountOfMaterials[i] = sc.nextDouble();
        }
        return amountOfMaterials;
    }
    public static double [] AssingPricesHomecenter(double [] pricesOfMaterialsInHomecenter,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Homecenter?");
            pricesOfMaterialsInHomecenter[i] = sc.nextDouble();
        }
        return pricesOfMaterialsInHomecenter;
    }
    public static double [] AssingPricesDownTownGrocery(double [] pricesOfMaterialsInDownTownGrocery,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x ; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in DownTown Grocery?");
            pricesOfMaterialsInDownTownGrocery[i] = sc.nextDouble();
        }
    return pricesOfMaterialsInDownTownGrocery;
    }
    public static double [] AssingPricesNehiborhoodStore(double [] priceOfMaterialsNeihborhood,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Neihborhood store?");
            priceOfMaterialsNeihborhood[i] = sc.nextDouble();
        }
        return priceOfMaterialsNeihborhood;
    }
    public static Object [] TypeOfWorks(Object [] theTypeOfWork,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<x){
            System.out.println("Para que tipo de obra es el material "+nameOfMaterials[i]+" 1 blanca, 2 negra, 3 pintura");
            int var = sc.nextInt();
            switch(var){
                case 1:
                theTypeOfWork[i] = TypeOfWork.WHITE; 
                break;
                case 2:
                theTypeOfWork[i] = TypeOfWork.BLACK;
                break;
                case 3:
                theTypeOfWork[i] = TypeOfWork.PAINT;
                break;
            }
            i++;
        }
        return theTypeOfWork;
    }
}
