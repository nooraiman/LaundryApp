import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class LaundryApps
{
    private static int aryS=100;
    private static Scanner in = new Scanner(System.in);
    private static Scanner inS = new Scanner(System.in);
    private static int indexCust=0;

    public static int Menu()
    {
        int opt = 0;
        System.out.print(
            "\n***************************" +
            "\n|         [Menu]          |" +
            "\n***************************" +
            "\n|[1]Add Customer          |" +
            "\n|[2]Search Customer       |" +
            "\n|[3]Print Bill            |" +
            "\n|[4]Print Summary         |" +
            "\n***************************" + 
            "\n|[5]Exit                  |" +
            "\n***************************"
        );
        System.out.println("\n\nEnter Option Code: ");
        opt = in.nextInt();
        return opt;
    }

    public static boolean exit()
    {
        System.out.println("\n[1]Return to Menu | [2]Exit");
        int optExit = in.nextInt();
        boolean go;
        if(optExit==1)
        {
            clrscr();
            go=true;
        }
        else
        {
            clrscr();
            go=false;
        }

        return go;
    }

    public static void main(String[] args)
    {
        Laundry[] L = new Laundry[aryS];
        boolean go=true;
        boolean detergentCharge = false;

        while(go)
        {

            int opt = Menu();
            int optExit=0;

            if(opt==1)  //Add customer
            {
                clrscr();
                addCustomer(L);
                go = exit();
            }
            else if(opt==2) //Search Customer
            {
                clrscr();
                searchCustomer(L);
                go= exit();
            }
            else if(opt==3) ///Show and Print Bill@Receipt
            {
                clrscr();
                printBill(L);
                go = exit();
            }
            else if(opt==4) //Show and Print Summary
            {
                clrscr();
                printSummary(L);
                go = exit();
            }
            else if(opt==5) //Exit
            {
                clrscr();
                go=false;
            }
            else
            {
                System.out.println("\nInvalid Option Code!");
                continue;
            }

        }

        clrscr();
        System.out.println("Thank You");
    }

    public static void addCustomer(Laundry[] L)
    {
        System.out.println("\nCustomer Name: ");
        String cN = inS.next();

        System.out.println(("\nMembership ([1]TRUE | [2]FALSE):  "));
        int mN = in.nextInt();
        boolean member=false;

        if(mN==1)
            member = true;
        else
            member = false;

        System.out.println("\nPhone Number: ");
        String phone = inS.next();

        while(true)
        {
            System.out.print("\nService Used([1]Washer | [2]Dryer): ");
            int services = in.nextInt();

            if(services == 1)
            {
                System.out.println(
                    "\n*********************************" +
                    "\n|         [Washer Menu]         |" +
                    "\n*********************************" +
                    "\n|[Code]Temperature | Price (RM) |" +
                    "\n*********************************" +
                    "\n|[1]Cold           |    RM10    |" +
                    "\n|[2]Moderate       |    RM9     |" +
                    "\n|[3]Warm           |    RM11    |" +
                    "\n*********************************");

                boolean detergent=false;
                String temp="";

                while(true) {
                    System.out.println("\nEnter Temperature Code: ");
                    int tC = in.nextInt();

                    if(tC == 1) {
                        temp = "Cold";

                    }
                    else if(tC == 2) {
                        temp = "Moderate";

                    }
                    else if(tC == 3) {
                        temp = "Warm";

                    }
                    else
                    {
                        System.out.println("\nInvalid Code Temperature Code!");
                        continue;
                    }

                    System.out.println("Buy Detergent: [1]YES | [2]NO");
                    int optD = in.nextInt();

                    if(optD == 1)
                        detergent = true;
                    else
                        detergent = false;

                    break;
                }
                L[indexCust] = new Washer(cN,member,phone,temp,detergent);
                break;
            }
            else if(services == 2)    
            {
                System.out.println(
                    "\n****************************************************" +
                    "\n|                   [Dryer Menu]                   |" +
                    "\n****************************************************" +
                    "\n|[Code]Weight |       Duration     | Price/Minutes |" +
                    "\n****************************************************" +
                    "\n|[1] 7 Kg     | [25/30/35] Minutes |     RM0.10    |" +
                    "\n|[2] 10 Kg    | [25/30/35] Minutes |     RM0.20    |" +
                    "\n****************************************************");

                System.out.println("\nEnter Code of Weight Capacity: ");
                int optW = in.nextInt();

                double tempWeight=0;
                if(optW == 1)
                    tempWeight = 7;
                else
                    tempWeight = 10;

                System.out.println("\nEnter Duration: ");
                int duration = in.nextInt();

                L[indexCust] = new Dryer(cN,member,phone,tempWeight,duration);

                break;
            }
            else
            {
                System.out.println("\nInvalid Service Code!");
                continue;
            }
        }
        indexCust++;
    }

    public static void searchCustomer(Laundry[] L) throws NullPointerException
    {
        System.out.print("\nEnter Customer Name: ");
        String cN = inS.next();
        boolean f = false;
        try{
            for(int i=0;i<L.length;i++)
            {
                if(L[i].getCustomerName() != null)
                {
                    if(L[i].getCustomerName().equals(cN))
                    {
                        f = true;
                        System.out.println("\nCustomer Details: ");
                        System.out.println("****************************");
                        System.out.println(L[i].toString());
                        System.out.println("****************************");
                    }
                    else
                    {
                        
                    }
                }
                else
                {
                    
                }
            }

        }
        catch (NullPointerException NPE)    {}
        finally 
        { 
            if(f==true)
                {}
            else
                System.out.println("\n" + cN + " not found in Customer Record");
        }
    }

    public static void printBill(Laundry[] L) 
    {
        System.out.println("\nEnter Name: ");
        String n = inS.next();
        boolean fW = false;
        boolean fD = false;

        FileWriter fw1 = null;
        BufferedWriter bw1 = null;
        PrintWriter pw1 = null;
        try 
        {
            fw1 = new FileWriter("Receipt_"+n+".txt");
            bw1 = new BufferedWriter(fw1);
            pw1 = new PrintWriter(bw1);
            for(int i=0;i<L.length;i++)
            {
                if(L[i].getCustomerName() != null && L[i].getCustomerName().equals(n))
                {
                    if(L[i] instanceof Washer)
                    {   fW = true;
                        //Write into text file
                        pw1.println("\nReceipt [Washer Service]");
                        pw1.println("****************************");
                        pw1.println(L[i].toString() + L[i].printBill());
                        pw1.println("****************************");

                        //Show in Command Prompt
                        System.out.println("\nReceipt [Washer Service]");
                        System.out.println("****************************");
                        System.out.println(L[i].toString() + L[i].printBill());
                        System.out.println("****************************");
                    }
                    if(L[i] instanceof Dryer)
                    {   fD = true;
                        //Write into text file
                        pw1.println("\nReceipt [Dryer Service]");
                        pw1.println("****************************");
                        pw1.println(L[i].toString() + L[i].printBill());
                        pw1.println("****************************");

                        //Show in Command Prompt
                        System.out.println("\nReceipt [Dryer Service]");
                        System.out.println("****************************");
                        System.out.println(L[i].toString() + L[i].printBill());
                        System.out.println("****************************");
                    }
                }
                else
                {
                    
                }
                //System.out.println("\nPrinted to Receipt_"+n+".txt" );
            }
            System.out.println("\nPrinted to Receipt_"+n+".txt" );
        }
        catch (NullPointerException NPE) { System.out.println("");    }
        catch (IOException IOE) {   System.out.println(IOE.getMessage());   }
        finally 
        {   
            if(fW==true || fD==true)
                System.out.println("\nPrinted to Receipt_"+n+".txt" );
            else
                System.out.println("\n" + n + " not found in Customer Record");
            //try {
            pw1.flush();
            pw1.close();
            //}
            /*
            catch (IOException IOE)
            {
            System.out.println(IOE.getMessage());
            }*/
        }
    }

    public static void printSummary(Laundry[] L) 
    {
        int order[] = new int[2];
        double collection[] = new double[2];
        for(int i=0;i<L.length;i++)
        {
            if(L[i] instanceof Washer)  {
                Washer W = (Washer)L[i];
                order[0]++;  //Number order of Washer
                collection[0] += W.calculateCharge();

            }
            else if(L[i] instanceof Dryer)  {
                Dryer D = (Dryer)L[i];
                order[1]++;   //Number order of Dryer
                collection[1] += D.calculateCharge();
            }
        }

        FileWriter fw1 = null;
        BufferedWriter bw1 = null;
        PrintWriter pw1 = null;
        DecimalFormat df = new DecimalFormat("#0.00");
        try {
            fw1 = new FileWriter("Summary.txt");
            bw1 = new BufferedWriter(fw1);
            pw1 = new PrintWriter(bw1);

            //Print Summary Sales
            pw1.println("Service\t\tNumber of Order\t\tCollection(RM)");
            pw1.println("****************************************************");
            pw1.println("\nWasher\t\t\t"+order[0]+"\t\tRM "+ df.format(collection[0]));
            pw1.println("\nDryer\t\t\t"+order[1]+"\t\tRM "+ df.format(collection[1]));
            pw1.println("\n****************************************************");
            pw1.println("Total\t\t\t"+(order[0]+order[1])+"\t\tRM "+ df.format(collection[0]+collection[1]));

            //Show Summary Sales in Command Prompt
            System.out.println("Service\t\tNumber of Order\t\tCollection(RM)");
            System.out.println("****************************************************");
            System.out.println("\nWasher\t\t\t"+order[0]+"\t\tRM "+ df.format(collection[0]));
            System.out.println("\nDryer\t\t\t"+order[1]+"\t\tRM "+ df.format(collection[1]));
            System.out.println("\n****************************************************");
            System.out.println("Total\t\t\t"+(order[0]+order[1])+"\t\tRM "+ df.format(collection[0]+collection[1]));

            System.out.println("\nPrinted into Summary.txt");

            pw1.flush();
            pw1.close();
        }
        catch (IOException IOE) {   System.out.println(IOE.getMessage());   }
    } 

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}
