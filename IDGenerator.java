//Jeffrey Edwards
//driver class
//the purpose of this class is to generate an employees ID badge
import java.util.*;


public class IDGenerator {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // will create ID card number
        String YesorNo;
        Random gen = new Random();
        boolean RemoteEmp = false;
        final String CompName = "Jeff Co.";
        final String ITPhoneNum = "501.222.2222";
        final String HRPhoneNum = "501.333.3333";
        int IDCardNum;

        //generation of physical card number to track cards
        IDCardNum = gen.nextInt(9000) + 1000;

        //short welcome message to employee entering info
        System.out.println("""
                Hello, before we can make an official employee \
                
                ID badge for our new hire we will need to answer a few questions.\
                
                Please answer to the best of your ability""");

        //allows user to decide when program moves on
        scan.nextLine();

        //asks for employee name and job position. this will also create emp ID number, Access Level, and Username
        Employee Emp = new Employee();

        //adds gender information to employee object
        Emp.setGender();

        //adds employee age and sets birthday
        Emp.setAge();

        //asks if employee will be on premise or not
        System.out.println("Will this employee be working on premise?" + "\n      Y/N ");

        //loop for yes or no
        do {
            YesorNo = scan.nextLine().toUpperCase();
            switch (YesorNo) {
                case "YES":
                    Emp.activateAccount();
                case "Y":
                    Emp.activateAccount();
                    break;
                case "NO":
                    Emp.deactivateAccount();
                case "N":
                    Emp.deactivateAccount();
                    RemoteEmp = true;
                    break;
                default:
                    System.out.println("Please type Y (Yes) or N (No).");
                    YesorNo = "";

            }
        }while (YesorNo.isEmpty());

        //if statement for printing card
        if(RemoteEmp)
        {
            System.out.println("Due to the employee being off premise there will be no need for a ID card, thank you.");
        } else {
            //print preview of information on front side of card
            System.out.println("Front of ID Card");
            System.out.println(CompName);
            System.out.println("Position: " + Emp.getJobTitle());
            System.out.println("Name: " + Emp.getName());
            System.out.println("Class Access: " +Emp.getAccessLevel());
            System.out.println("""
                    ID must be presented upon request.
                    
                    """);

            //Back of card
            System.out.println("Back of ID Card");
            System.out.println("Employee ID: " + Emp.getID());
            System.out.println("Username: " + Emp.getUsername());
            System.out.println("IT: " + ITPhoneNum + " | HR: " + HRPhoneNum);
            System.out.println("Card Number: " + IDCardNum);

        }
    }
}
