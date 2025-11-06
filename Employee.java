//Jeffrey Edwards
//constructor class
//the purpose of this object is to create employee profiles using given information

import java.time.LocalDate;
import java.util.*;

public class Employee {
    //constructor variables
    Scanner scan = new Scanner(System.in);
    private char ClassAccess;
    private final Random gen = new Random();
    private int Age = 0;
    private String Fname;
    private String Lname;
    private String Gender;
    private final String Username;
    private String JobTitle;
    private String BloodType;
    private boolean Active_Employee = true;
    private LocalDate Birthday;

    //generation of employee ID
    private final int ID = gen.nextInt(899999) + 100000;

    //constructor class to take employee first, last name and gender
    public Employee()
    {
        String jobposition;

        //asks employees name
        System.out.println("Please enter employee first name: ");
        Fname = scan.nextLine();
        System.out.println("Please enter employee last name: ");
        Lname = scan.nextLine();

        //capitalizes the first name character of what the user types in
        this.Fname = Fname.substring(0,1).toUpperCase() + Fname.substring(1).toLowerCase();
        this.Lname = Lname.substring(0,1).toUpperCase() + Lname.substring(1).toLowerCase();

        //career arraylist
        ArrayList<String> career = new ArrayList<>();
        career.add("ceo");
        career.add("technician");
        career.add("operator");
        career.add("intern");
        career.add("software developer");
        career.add("custodial");
        Iterator<String> iterator = career.iterator();

        //employee career choice
        System.out.println("Choose employees position: ");
        while (iterator.hasNext()) {
            String job = iterator.next();
            System.out.println(job + " ");
        }
        do {
            jobposition = scan.nextLine();
            JobTitle = jobposition.toLowerCase();

            if (career.contains(JobTitle)) {
                System.out.println("Thank you!");
            } else {
                System.out.println("invalid response, please enter valid position:");
                JobTitle = " ";
            }
        }while(JobTitle.equals(" "));

        //switch statement to assign classified access based on job
        switch (JobTitle)
        {
            case "ceo":
                ClassAccess = 'A';
                this.JobTitle = JobTitle.toUpperCase();
                break;
            case "software developer":
                ClassAccess = 'B';
                this.JobTitle = JobTitle.replaceFirst("s","S");
                this.JobTitle = JobTitle.replaceFirst("d","D");
                break;
            case "operator":
                ClassAccess = 'B';
                this.JobTitle = JobTitle.replaceFirst("o","O");
                break;
            case "technician":
                ClassAccess = 'B';
                this.JobTitle = JobTitle.replace("t","T");
                break;
            case "custodial":
                ClassAccess = 'C';
                this.JobTitle = JobTitle.replace("c","C");
                break;
            case "intern":
                ClassAccess = 'C';
                this.JobTitle = JobTitle.replace("i","I");
                break;
        }


        //turn the ID integer into a string
        String UID = String.valueOf(ID);

        Username = (Fname.charAt(0) + Lname + UID.substring(0,2) + ClassAccess);
    }

    //returns users name
    public String getName()
    {
        String name;
        name = Fname + " " + Lname;
        return name;
    }

    //returns username
    public String getUsername() {return Username;}

    //returns job position
    public String getJobTitle() {return JobTitle;}

    //returns classified access level
    public char getAccessLevel() {return ClassAccess;}

    //sets user gender
    public void setGender()
    {
        System.out.println("Please enter employee gender: ");
        Gender = scan.nextLine();
    }

    //returns employee gender
    public String getGender()
    {
        return Gender;
    }

    //returns employee ID
    public Integer getID()
    {
        return ID;
    }

    //allows user to set employee blood-type
    public void setBloodType()
    {
        //create scanner for do loop
        Scanner Blood = new Scanner(System.in);
        //create an array of blood-types to give employee options available
        ArrayList<String> BloodGroup = new ArrayList<>();
        BloodGroup.add("A+");
        BloodGroup.add("A-");
        BloodGroup.add("B+");
        BloodGroup.add("B-");
        BloodGroup.add("AB+");
        BloodGroup.add("AB-");
        BloodGroup.add("O+");
        BloodGroup.add("O-");
        Iterator<String> iterator = BloodGroup.iterator();

        System.out.println("Please enter employee blood type: ");
        while(iterator.hasNext()){
            String BloodT = iterator.next();
            System.out.println(BloodT + " ");
        }

        //do-while loop that asks user for blood type and does not take invalid responses
        do{
            this.BloodType = Blood.nextLine().toUpperCase();
        if (BloodGroup.contains(BloodType))
        {
            System.out.println("Thank you!");
        } else{
            System.out.println("This is an invalid response.");
            BloodType = "";
        }
        } while(BloodType.isEmpty());
    }

    //prints employee blood-type
    public String getBloodType()
    {
        return BloodType;
    }

    //method to activate employee account
    public void activateAccount()
    {
        Active_Employee = true;
    }

    //method to deactivate employee account
    public void deactivateAccount()
    {
        Active_Employee = false;
    }

    //method to retrieve account status
    public boolean getAccountStatus(){return Active_Employee;}


    //method to retrieve employee age
    public void setAge()
    {
        Scanner bmonth = new Scanner(System.in);
        int bmonth2 = 0;
        int bday;
        int byear;

      //while statement to enter age above 18
      do {
          System.out.println("Please enter employee age: ");

          Age = scan.nextInt();
          if (Age < 18){
              System.out.println("Invalid age.");
              Age = 0;
          }
      }while (Age == 0);

      //while loop to get birthday month
        while (bmonth2 == 0){
          System.out.println("Please enter employee month of birth.");
          // switch statement will change the month to an integer
            bmonth2 = switch (bmonth.nextLine().toUpperCase()) {
                case "JANUARY" -> 1;
                case "FEBRUARY" -> 2;
                case "MARCH" -> 3;
                case "APRIL" -> 4;
                case "MAY" -> 5;
                case "JUNE" -> 6;
                case "JULY" -> 7;
                case "AUGUST" -> 8;
                case "SEPTEMBER" -> 9;
                case "OCTOBER" -> 10;
                case "NOVEMBER" -> 11;
                case "DECEMBER" -> 12;
                default -> {
                    System.out.println("This is an invalid answer.");
                    yield 0;
                }
            };
      }

      System.out.println("Please enter employee day of birth: ");
      bday = scan.nextInt();

      do {
          System.out.println("Please enter employee birth year: ");
          byear = scan.nextInt();
          if(byear >= 2007){
              System.out.println("This is an invalid answer.");
              byear = 0;
          } else if (byear <= 1900) {
              System.out.println("This is an invalid answer.");
              byear = 0;
          }
      }while (byear == 0);
        Birthday = LocalDate.of(byear, bmonth2, bday);
    }

    //method for returning birthday value
    public LocalDate getBirthday()
    {
        return Birthday;
    }

    //method to show employee age
    public Integer getAge()
    {
        return Age;
    }

    //toString method
    public String toString()
    {
        String result;

        result = "Employee name: " + Fname + " " + Lname;
        result += "\nEmployee Username: " + Username;

        return result;
    }

}


