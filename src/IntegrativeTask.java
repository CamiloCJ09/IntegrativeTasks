import java.util.Scanner;
public class IntegrativeTask {

    
    /** 
     * @author CAMILO CAMPAZ JIMÉNEZ
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = AskCountArticles();
        
        String [] nameOfMaterials = new String[x];
        double [] amountOfMaterials = new double[x];
        double [] priceOfMaterialsHomecenter = new double[x];
        double [] priceOfMaterialsDownTownGrocery = new double[x];
        double [] priceOfMaterialsNeihborhood = new double[x];
        int sumHomecenter = 0;
        int sumDownTown = 0;
        int sumNeighboor = 0;

        //Calls
        TypeOfWork [] array = new TypeOfWork[x]; //We use this array to say the type of work
        BuildingZone BuildingPlace = null;
        System.out.println("Where is the building zone?\n 1: North \n 2: DownTown \n 3: South ");
        int var = sc.nextInt();
        switch (var) {
            case 1:
                BuildingPlace = BuildingZone.NORTH;
                break;
            case 2:
                BuildingPlace = BuildingZone.DOWNTOWN;
                break;
            case 3:
                BuildingPlace = BuildingZone.SOUTH;
                break;
            
        }
        
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
        System.out.println(sumHomecenter);
        sumDownTown = SumPerStore(nameOfMaterials, priceOfMaterialsDownTownGrocery, amountOfMaterials, array, x);
        sumNeighboor = SumPerStore(nameOfMaterials, priceOfMaterialsNeihborhood, amountOfMaterials, array, x);
        System.out.println("The sum of materials in Homecenter with workforce is: "+sumHomecenter+"\n"+"The sum of materials in DownTown Grocery with workforce is: "+sumDownTown+"\n"+"The sum of materials in Neihgborhood store with workforce is: "+sumNeighboor);

        WhereisBetterToBuy(array,BuildingPlace,amountOfMaterials,priceOfMaterialsHomecenter, priceOfMaterialsDownTownGrocery, priceOfMaterialsNeihborhood, x, nameOfMaterials);
        
        System.out.println("the materials of which work you want to know");
        int deploy = sc.nextInt();
        String [] namesPerType = deployMaterials(array, nameOfMaterials, x, deploy);
        for(int i = 0; i<x;i++){
            if(namesPerType[i]!=null){
                System.out.println(namesPerType[i]);
            }
        }
        
    }

    
    /** 
     * @return int
     */
    public static int AskCountArticles() {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much materials do you want to buy?");
        x = sc.nextInt();
        return x;
    }
    
    /** 
     * @param nameOfMaterials
     * @param x
     * @return String[]
     */
    public static String [] NameOfObjets(String [] nameOfMaterials,int x) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x;i++){
            System.out.println("Imput the name of the material "+(i+1));
            nameOfMaterials[i] = sc.nextLine();
        }
        return nameOfMaterials;
    }
    
    /** 
     * @param amountOfMaterials
     * @param nameOfMaterials
     * @param x
     * @return double[]
     */
    public static double [] AssingAmount(double [] amountOfMaterials,String [] nameOfMaterials,int x){
        Scanner sc  = new Scanner(System.in);
        for(int i = 0; i<x ;i++){
            System.out.println("How much "+nameOfMaterials[i]+" do you want?");
            amountOfMaterials[i] = sc.nextDouble();
        }
        return amountOfMaterials;
    }
    
    /** 
     * @param pricesOfMaterialsInHomecenter
     * @param nameOfMaterials
     * @param x
     * @return double[]
     */
    public static double [] AssingPricesHomecenter(double [] pricesOfMaterialsInHomecenter,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Homecenter?");
            pricesOfMaterialsInHomecenter[i] = sc.nextDouble();
        }
        return pricesOfMaterialsInHomecenter;
    }
    
    /** 
     * @param pricesOfMaterialsInDownTownGrocery
     * @param nameOfMaterials
     * @param x
     * @return double[]
     */
    public static double [] AssingPricesDownTownGrocery(double [] pricesOfMaterialsInDownTownGrocery,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x ; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in DownTown Grocery?");
            pricesOfMaterialsInDownTownGrocery[i] = sc.nextDouble();
        }
    return pricesOfMaterialsInDownTownGrocery;
    }
    
    /** 
     * @param priceOfMaterialsNeihborhood
     * @param nameOfMaterials
     * @param x
     * @return double[]
     */
    public static double [] AssingPricesNehiborhoodStore(double [] priceOfMaterialsNeihborhood,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Neihborhood store?");
            priceOfMaterialsNeihborhood[i] = sc.nextDouble();
        }
        return priceOfMaterialsNeihborhood;
    }
    
    /** 
     * @param theTypeOfWork
     * @param nameOfMaterials
     * @param x
     * @return TypeOfWork[]
     */
    public static TypeOfWork [] TypeOfWorks(TypeOfWork [] theTypeOfWork,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(i<x){
            System.out.println("Para que tipo de obra es el material? "+nameOfMaterials[i]+" Push 1 for White Work, 2 Black Work, 3 Paint");
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
    /*
    here is where we are going to solve the most part of the problem
    *We are going to do the sum from every store, with delivery, without delivery,
    *with workforce and without it.
    */

    /** 
     * @param nameOfMaterials
     * @param imputMaterial
     * @param amountOfMaterials
     * @param typeObject
     * @param x
     * @return int
     */
    
    public static int SumPerStore(String [] nameOfMaterials,double [] imputMaterial,double [] amountOfMaterials,TypeOfWork [] typeObject, int x){
        int valueFromStore = 0;
        int white = 0;
        int black = 0;
        int paint = 0;
        double imptmaterial = 0;
        double amntMaterial = 0;
        double [] array = new double[x];
        for(int i = 0; i<x; i++){
            //System.out.println(nameOfMaterials[i]);
            imptmaterial = imputMaterial[i];
            amntMaterial = amountOfMaterials[i];
            
            array[i] = imptmaterial*amntMaterial; //Comprobación de funcionamiento
            //System.out.println("A: "+amountOfMaterials[i]);
            //System.out.println("B: "+imputMaterial[i]);
            //System.out.println("T: "+array[i]);
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
        double ValuesWithOutWorkForce = valueFromStore;
        System.out.println("The value of the materias without delivery is: "+ValuesWithOutWorkForce);
        //System.out.println(valueFromStore);
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
    
    /** 
     * @param typeObject
     * @param buildingPlace
     * @param amountOfMaterials
     * @param PricesHomencenter
     * @param PricesDownTown
     * @param PricesNeihborghood
     * @param x
     * @param NameOfMaterial
     */
    public static void WhereisBetterToBuy(TypeOfWork [] typeObject,BuildingZone buildingPlace,double [] amountOfMaterials,double [] PricesHomencenter, double [] PricesDownTown, double [] PricesNeihborghood, int x,String [] NameOfMaterial){
        int totalWhereIsBetterToBuy = 0;
        int white = 0;
        int black = 0;
        int paint = 0;
        for(int i = 0; i<x; i++){
            if((PricesHomencenter[i]<PricesDownTown[i])&&(PricesHomencenter[i]<PricesNeihborghood[i])){
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in Homecenter");
                totalWhereIsBetterToBuy += PricesHomencenter[i]*amountOfMaterials[i];
            }else if((PricesDownTown[i]<PricesHomencenter[i])&&(PricesDownTown[i]<PricesNeihborghood[i])){
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in DownTown");
                totalWhereIsBetterToBuy += PricesDownTown[i]*amountOfMaterials[i];
            }else{
                System.out.println("The best place to buy "+NameOfMaterial[i]+" is in Neihgborhood Store");
                totalWhereIsBetterToBuy += PricesNeihborghood[i]*amountOfMaterials[i];
            }
        }
        System.out.println("The best qotation without delivery is: "+totalWhereIsBetterToBuy);
        if(buildingPlace==BuildingZone.NORTH){
            if(totalWhereIsBetterToBuy<80000){
                System.out.println("You have to pay 120.000 from delivery");
                totalWhereIsBetterToBuy += 120000;
            }else if(totalWhereIsBetterToBuy<300000){
                System.out.println("You have to pay 28.000 from delivery");
                totalWhereIsBetterToBuy += 28000;
            }else{
                System.out.println("You have to pay 0 from delivery");
            }
        }else if(buildingPlace==BuildingZone.DOWNTOWN){
            if(totalWhereIsBetterToBuy<80000){
                System.out.println("You have to pay 50.000 from delivery");
                totalWhereIsBetterToBuy += 50000;
            }else if(totalWhereIsBetterToBuy<300000){
                System.out.println("You have to pay 0 from delivery");
            }else{
                System.out.println("You have to pay 0 from delivery");
            }
        } else if(buildingPlace==BuildingZone.SOUTH){
            if(totalWhereIsBetterToBuy<80000){
                System.out.println("You have to pay 120.000 from delivery");
                totalWhereIsBetterToBuy += 120000;
            }else if(totalWhereIsBetterToBuy<300000){
                System.out.println("You have to pay 55.000 from delivery");
                totalWhereIsBetterToBuy += 55000;
            }else{
                System.out.println("You have to pay 0 from delivery");
            }
        }
        System.out.println("The best qotation with delivery is: "+totalWhereIsBetterToBuy);
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
        if(black>0){
            totalWhereIsBetterToBuy += 1300000;
        }
        if(white>0){
            totalWhereIsBetterToBuy += 2600000;
        }
        if(paint>0){
            totalWhereIsBetterToBuy += 980000;
        }
        System.out.println("The best qotation with delivery and workforce is: "+totalWhereIsBetterToBuy);
        
    }
    
    /** 
     * @param typeObjects
     * @param nameOfMaterials
     * @param x
     * @param deploy
     * @return String[]
     */
    public static String [] deployMaterials(TypeOfWork [] typeObjects,String [] nameOfMaterials, int x, int deploy){
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
