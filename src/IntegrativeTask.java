import java.util.Scanner;
public class IntegrativeTask {

    
    /** 
     * @author CAMILO CAMPAZ JIMÉNEZ
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int x = askCountArticles();
        
        String [] nameOfMaterials = new String[x]; //Here we will save the name of the materials that we are goint to use
        double [] amountOfMaterials = new double[x]; //Here we will save the amount of each materials that we are going to buy
        double [] priceOfMaterialsHomecenter = new double[x]; //Here we will save the prices of the materials in Homecenter
        double [] priceOfMaterialsDownTownGrocery = new double[x]; //Here we will save the prices of the materials in down town grocery
        double [] priceOfMaterialsNeihborhood = new double[x]; //Here we will save the prices of the materials in the neihborhood store
        int sumHomecenter = 0; //Here we will save the value of the sum for all the materials in Homecenter
        int sumDownTown = 0; //Here we will save the value of the sum for all the materials in down town store
        int sumNeighboor = 0; //Here we will save the value of the sum for all the materials in neihborhood store

        //Calls
        TypeOfWork [] array = new TypeOfWork[x]; //We use this array to say the type of work
        BuildingZone BuildingPlace = null; //here we going to save the building zone for the work
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
        
        //Calling methods
        nameOfMaterials = nameOfObjets(nameOfMaterials, x);
        amountOfMaterials = assignAmount(amountOfMaterials, nameOfMaterials, x);
        array = typeOfWorks(array,nameOfMaterials,x);
        //Setting prices
        priceOfMaterialsHomecenter = assignPricesHomecenter(priceOfMaterialsHomecenter, nameOfMaterials, x);
        priceOfMaterialsDownTownGrocery = assignPricesDownTownGrocery(priceOfMaterialsDownTownGrocery, nameOfMaterials, x);
        priceOfMaterialsNeihborhood = assignPricesNehiboorhoodStore(priceOfMaterialsNeihborhood, nameOfMaterials, x);
        //Setting the sum for the materials
        sumHomecenter = sumPerStore(nameOfMaterials, priceOfMaterialsHomecenter, amountOfMaterials, array, x);
        sumDownTown = sumPerStore(nameOfMaterials, priceOfMaterialsDownTownGrocery, amountOfMaterials, array, x);
        sumNeighboor = sumPerStore(nameOfMaterials, priceOfMaterialsNeihborhood, amountOfMaterials, array, x);
        System.out.println("The sum of materials in Homecenter with workforce is: "+sumHomecenter+"\n"+"The sum of materials in DownTown Grocery with workforce is: "+sumDownTown+"\n"+"The sum of materials in Neihgborhood store with workforce is: "+sumNeighboor);

        whereIsBetterToBuy(array,BuildingPlace,amountOfMaterials,priceOfMaterialsHomecenter, priceOfMaterialsDownTownGrocery, priceOfMaterialsNeihborhood, x, nameOfMaterials);
        
        
        int deploy ; //We use it to know the materials per type of work
        do{
            System.out.println("the materials of which work you want to know, push 0 to exit");
            deploy = sc.nextInt();
            String [] namesPerType = deployMaterials(array, nameOfMaterials, x, deploy);
            for(int i = 0; i<x;i++){
                if(namesPerType[i]!=null){
                System.out.println(namesPerType[i]);
                }
            }
        }while(deploy!=0);
    }

    
    /** 
     * askCountArticles 
     * We determine the amount of items without repeating that are going to be purchased
     * <b> Pre: </b>There must be an initialized variable to later save the return value <br>
     * <b> Post: </b> <br>
     * @return x int
     */
    public static int askCountArticles() {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much materials do you want to buy?");
        x = sc.nextInt();
        return x;
    }
    
    /** 
     * nameOfObjects
     * We assign the name of each of the materials
     * <b> Pre: </b>There must be an array declared to be able to save the values ​​to enter <br>
     * <b> Post: </b> <br>
     * @param nameOfMaterials
     * @param x
     * @return nameOfMaterials String[]
     */
    public static String [] nameOfObjets(String [] nameOfMaterials,int x) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x;i++){
            System.out.println("Imput the name of the material "+(i+1));
            nameOfMaterials[i] = sc.nextLine();
        }
        return nameOfMaterials;
    }
    
    /** 
     * assignAmount
     * We assign the quantity of how many materials we are going to order for each material
     * <b> Pre: </b>There must be an array declared to store the amount of materials associated with each material<br>
     * <b> Post: </b> <br>
     * @param amountOfMaterials
     * @param nameOfMaterials
     * @param x
     * @return amountOfMaterials double[]
     */
    public static double [] assignAmount(double [] amountOfMaterials,String [] nameOfMaterials,int x){
        Scanner sc  = new Scanner(System.in);
        for(int i = 0; i<x ;i++){
            System.out.println("How much "+nameOfMaterials[i]+" do you want?");
            amountOfMaterials[i] = sc.nextDouble();
        }
        return amountOfMaterials;
    }
    
    /** 
     * assignPricesHomecenter
     * We assign the price of each material in Homecenter
     * <b> Pre: </b>There must be an array declared to store the value of each material in homecenter<br>
     * <b> Post: </b> <br>
     * @param pricesOfMaterialsInHomecenter
     * @param nameOfMaterials
     * @param x
     * @return priceOfMaterialsInHomecenter double[]
     */
    public static double [] assignPricesHomecenter(double [] pricesOfMaterialsInHomecenter,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Homecenter?");
            pricesOfMaterialsInHomecenter[i] = sc.nextDouble();
        }
        return pricesOfMaterialsInHomecenter;
    }
    
    /** 
     * assignPricesDownTownGrocery
     * We assign the price of each material in DownTown Grocery
     * <b> Pre: </b>There must be an array declared to store the value of each material in DownTown Grocery <br>
     * <b> Post: </b> <br>
     * @param pricesOfMaterialsInDownTownGrocery
     * @param nameOfMaterials
     * @param x
     * @return pricesOfMaterialsInDownTownGrocery double[]
     */
    public static double [] assignPricesDownTownGrocery(double [] pricesOfMaterialsInDownTownGrocery,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x ; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in DownTown Grocery?");
            pricesOfMaterialsInDownTownGrocery[i] = sc.nextDouble();
        }
    return pricesOfMaterialsInDownTownGrocery;
    }
    
    /** 
     * assignPricesNeighborhood
     * We assign the price of each material in neighborhood store
     * <b> Pre: </b>There must be an array declared to store the value of each material in neighborhood store <br>
     * <b> Post: </b> <br>
     * @param priceOfMaterialsNeihborhood
     * @param nameOfMaterials
     * @param x
     * @return priceOfMaterialsNeihborhood double[]
     */
    public static double [] assignPricesNehiboorhoodStore(double [] priceOfMaterialsNeihborhood,String [] nameOfMaterials, int x){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<x; i++){
            System.out.println("How much "+nameOfMaterials[i]+" cost in Neihborhood store?");
            priceOfMaterialsNeihborhood[i] = sc.nextDouble();
        }
        return priceOfMaterialsNeihborhood;
    }
    
    /** 
     * typeOfWorks
     * We store in an array the type of work for which each material is
     * <b> Pre: </b> <br>
     * <b> Post: </b> <br>
     * @param theTypeOfWork
     * @param nameOfMaterials
     * @param x
     * @return theTypeOfWork TypeOfWork[]
     */
    public static TypeOfWork [] typeOfWorks(TypeOfWork [] theTypeOfWork,String [] nameOfMaterials, int x){
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
     * sumPerStore
     * We carry out the respective operations to return the total value including labor
     * <b> Pre: </b>All arrays must have values ​​assigned in each position <br>
     * <b> Post: </b> <br>
     * @param nameOfMaterials
     * @param imputMaterial
     * @param amountOfMaterials
     * @param typeObject
     * @param x
     * @return valueFromStore int
     */
    
    public static int sumPerStore(String [] nameOfMaterials,double [] imputMaterial,double [] amountOfMaterials,TypeOfWork [] typeObject, int x){
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
        //double ValuesWithOutWorkForce = valueFromStore;
        //System.out.println("The value of the materials without delivery is: "+ValuesWithOutWorkForce);
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
     * whereIsBetterToBuy
     * We calculate the best quote and add the address depending on the value
     * <b> Pre: </b>All arrays must have values ​​assigned in each position <br>
     * <b> Post: </b> <br>
     * @param typeObject 
     * @param buildingPlace
     * @param amountOfMaterials
     * @param PricesHomencenter
     * @param PricesDownTown
     * @param PricesNeihborghood
     * @param x
     * @param NameOfMaterial
     */
    public static void whereIsBetterToBuy(TypeOfWork [] typeObject,BuildingZone buildingPlace,double [] amountOfMaterials,double [] PricesHomencenter, double [] PricesDownTown, double [] PricesNeihborghood, int x,String [] NameOfMaterial){
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
     * DeployMaterials
     * We keep the list of materials for their type of work
     * <b> Pre: </b>All arrays must have values ​​assigned in each position <br>
     * <b> Post: </b> <br>
     * @param typeObjects
     * @param nameOfMaterials
     * @param x
     * @param deploy
     * @return array String[]
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
                if(typeObjects[k]==TypeOfWork.PAINT){
                    array[k] = nameOfMaterials[k];
                }
            }
        }
        return array;
    }
}
