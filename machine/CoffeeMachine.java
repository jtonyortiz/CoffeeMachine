package machine;
import java.util.Scanner;

public class CoffeeMachine {

     int water;
     int milk;
     int beans;
     int cups;
     int money;

    public CoffeeMachine()
    {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void print(){
        System.out.println("The coffee machine has: ");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " ml of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.money + " of money");
    }

    public void buyDrink(int selection)
    {
            //Expresso:
        if (selection == 1)
        {
            this.water -= 250;
            this.beans -= 16;
            this.money += 4;
            this.cups -= 1;

            //Latte:
        } else if (selection == 2)
        {
             this.water -= 350;
             this.milk -= 75;
             this.beans -= 20;
             this.money += 7;
             this.cups -= 1;

            //Cappucino:
        } else if (selection == 3){
            this.water -= 200;
            this.milk -= 100;
            this.beans -= 12;
            this.money += 6;
            this.cups -= 1;

        }
    }

    public void fillMachine(){
        int water;
        int milk;
        int beans;
        int cups;
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        water = scan.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        beans = scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        cups = scan.nextInt();

        this.water += water;
        this.milk  += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void takeMoney(){
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public void checkResources(String drink){

        if(drink.equalsIgnoreCase("1")){
            //Ingredients to make an espresso:
            int defWater = 250;
            int defBeans = 16;

            int currWater = this.water - defWater;
            int currBeans = this.beans - defBeans;
            int currCups = this.cups - 1;

            if(currWater >= 0 && currBeans >= 0 && currCups > 0){
                this.water = currWater;
                this.beans = currBeans;
                this.cups = currCups;
                this.money += 4;

            }
            else{

                if(currWater < defWater){
                    System.out.println("Sorry, not enough water!");
                }
                else if(currBeans < defBeans){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if (currCups == 0){
                    System.out.println("Sorry, not enough cups!");
                }

            }

        }else if (drink.equalsIgnoreCase("2")) {
            //Ingredients to make a latte:
            int defWater = 350;
            int defMilk = 75;
            int defBeans = 20;

            int currWater = this.water - defWater;
            int currMilk = this.milk - defMilk;
            int currBeans = this.beans - defBeans;
            int currCups = this.cups - 1;

            if(currWater >= 0 && currMilk >= 0 && currBeans >= 0 &&
            currCups > 0){

                this.water = currWater;
                this.milk = currMilk;
                this.beans = currBeans;
                this.cups = currCups;
                this.money += 7;

            } else {
                if(currWater < defWater){
                    System.out.println("Sorry, not enough water!");
                }
                else if(currMilk < defMilk){
                    System.out.println("Sorry, not enough milk!");
                }
                else if(currBeans < defBeans){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if (currCups == 0){
                    System.out.println("Sorry, not enough cups!");
                }

            }

        }else if (drink.equalsIgnoreCase("3")) {
            //Ingredients to make cappuccino:
            int defWater = 200;
            int defMilk = 100;
            int defBeans = 12;

            int currWater = this.water - defWater;
            int currMilk = this.milk - defMilk;
            int currBeans = this.beans - defBeans;
            int currCups = this.cups - 1;

            if(currWater >= 0 && currMilk >= 0 && currBeans >= 0 &&
                    currCups > 0){
                this.water = currWater;
                this.milk = currMilk;
                this.beans = currBeans;
                this.cups = currCups;
                this.money += 6;

                System.out.println("I Have enough resources, making you a cappuccino!");

            } else {

                if(currWater < defWater){
                    System.out.println("Sorry, not enough water!");
                }
                else if(currMilk < defMilk){
                    System.out.println("Sorry, not enough milk!");
                }
                else if(currBeans < defBeans){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if (currCups == 0){
                    System.out.println("Sorry, not enough cups!");
                }

            }
        }

    }

    public static void main(String[] args) {
        //Scanner used for Input:
        Scanner scan = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();
        boolean ifExit = false;

        //Do - While Loop For Menu
        //------ ---- ---- ----- ---

        do {
            //Enter a Selection:
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String selection = scan.nextLine();

            if (selection.equalsIgnoreCase("buy")) {

                String value;

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");

                value = scan.nextLine();


                if(!value.equalsIgnoreCase("back")){
                    //Check if user can buy coffee drink:
                    cm.checkResources(value);
                }

            } else if (selection.equalsIgnoreCase("fill")) {
                //Fill Coffee Machine:
                cm.fillMachine();
            } else if (selection.equalsIgnoreCase("take")) {
                //Take Money From Coffee Machine:
                cm.takeMoney();
            } else if (selection.equalsIgnoreCase("exit")) {
                ifExit = true;
            }
            else if (selection.equalsIgnoreCase("remaining")){
                //Display Remaining Ingredients:
                cm.print();
            }

            //Check if exit option was chosen:
        }while(!ifExit);

        scan.close();

    }

}
