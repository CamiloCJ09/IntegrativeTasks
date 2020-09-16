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
        double sumHomecenter = 0;
        double sumDownTown = 0;
        double sumNeighboor = 0;

        //Calls
        Object [] array = new Object[x]; //We use this array to say the type of work
        
        nameOfMaterials = NameOfObjets(nameOfMaterials, x);
        amountOfMaterials = AssingAmount(amountOfMaterials, nameOfMaterials, x);
        array = TypeOfWorks(array,nameOfMaterials,x);
        priceOfMaterialsHomecenter = AssingPricesHomecenter(priceOfMaterialsHomecenter, nameOfMaterials, x);
        priceOfMaterialsDownTownGrocery = AssingPricesDownTownGrocery(priceOfMaterialsDownTownGrocery, nameOfMaterials, x);
        priceOfMaterialsNeihborhood = AssingPricesNehiborhoodStore(priceOfMaterialsNeihborhood, nameOfMaterials, x);


        for(int i = 0; i<x;i++){
            System.out.println(priceOfMaterialsHomecenter[i]); //Imprimir los el tipo de obra que va a ser
        }
        for(int j = 0; j<x;j++){
            System.out.println(priceOfMaterialsDownTownGrocery[j]); //Imprimir los el tipo de obra que va a ser
        }
        for(int k = 0; k<x;k++){
            System.out.println(priceOfMaterialsNeihborhood[k]); //Imprimir los el tipo de obra que va a ser
        }
        sumHomecenter = SumPerStore(nameOfMaterials, priceOfMaterialsHomecenter, amountOfMaterials, array, x);
        sumDownTown = SumPerStore(nameOfMaterials, priceOfMaterialsDownTownGrocery, amountOfMaterials, array, x);
        sumNeighboor = SumPerStore(nameOfMaterials, priceOfMaterialsNeihborhood, amountOfMaterials, array, x);
        System.out.println("The sum of materials in Homecenter is: "+sumHomecenter+"\n"+"The sum of materials in DownTown Grocery is: "+sumDownTown+"\n"+"The sum of materials in Neihgborhood store is: "+sumNeighboor);

        WhereisBetterToBuy(priceOfMaterialsHomecenter, priceOfMaterialsDownTownGrocery, priceOfMaterialsNeihborhood, x, nameOfMaterials);
        
        System.out.println("the materials of which work you want to know");
        int deploy = sc.nextInt();
        String [] namesPerType = deployMaterials(array, nameOfMaterials, x, deploy);
        for(int i = 0; i<x;i++){
            if(namesPerType[i]!=null){
                System.out.println(namesPerType[i]);
            }
        }
        
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
    public static double SumPerStore(String [] nameOfMaterials,double [] imputMaterial,double [] amountOfMaterials,Object [] typeObject, int x){
        double valueFromStore = 0;
        int white = 0;
        int black = 0;
        int paint = 0;
        double imptmaterial = 0;
        double amntMaterial = 0;
        double [] array = new double[x];
        for(int i = 0; i<x; i++){
            System.out.println(nameOfMaterials[i]);
            imptmaterial = imputMaterial[i];
            amntMaterial = amountOfMaterials[i];
            
            array[i] = imptmaterial*amntMaterial; //Comprobación de funcionamiento
            System.out.println("A: "+amountOfMaterials[i]);
            System.out.println("B: "+imputMaterial[i]);
            System.out.println("T: "+array[i]);
        }
        for(int j = 0; j<x; j++){
            valueFromStore += array[j];
        }
        for(int k = 0; k<x;k++){
            if(typeObject[k]==TypeOfWork.BLACK){
                black++;
            }
            if(typeObject[k]==TypeOfWork.WHITE){
                white++;
            }
            if(typeObject[k]==TypeOfWork.PAINT){
                paint++;
            }
        }
        System.out.println(valueFromStore);
        if(black>0){
            valueFromStore += 1300000;
        }
        if(white>0){
            valueFromStore += 2600000;
        }
        if(paint>0){
            valueFromStore += 980000;
        }
        return valueFromStore;
    }
    public static void WhereisBetterToBuy(double [] PricesHomencenter, double [] PricesDownTown, double [] PricesNeihborghood, int x,String [] NameOfMaterial){
        for(int i = 0; i<x; i++){
            if((PricesHomencenter[i]<PricesDownTown[i])&&(PricesHomencenter[i]<PricesNeihborghood[i])){
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in Homecenter");
            }else if((PricesDownTown[i]<PricesHomencenter[i])&&(PricesDownTown[i]<PricesNeihborghood[i])){
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in DownTown");
            }else{
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in Neihgborhood Store");
            }
        }
    }
    public static String [] deployMaterials(Object [] typeObjects,String [] nameOfMaterials, int x, int deploy){
        String [] array = new String[x];
        if(deploy == 1){
            for(int i = 0; i<x ;i++){
                if(typeObjects[i]==TypeOfWork.WHITE){
                    array[i] = nameOfMaterials[i];
                }
            }
        }else if(deploy == 2){
            for(int j = 0; j<x ;j++){
                if(typeObjects[j]==TypeOfWork.BLACK){
                    array[j] = nameOfMaterials[j];
                }
            }
        }else{
            for(int k = 0; k<x ;k++){
                if(typeObjects[k]==TypeOfWork.WHITE){
                    array[k] = nameOfMaterials[k];
                }
            }
        }
        return array;
    }
}
