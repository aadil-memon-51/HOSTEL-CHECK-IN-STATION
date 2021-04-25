import java.text.DateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckIn extends LinkedQueue{
    LinkedQueue lq= new LinkedQueue();



    public void mainmenu() {
        try{
            Scanner input=new Scanner(System.in);
            int i;
            System.out.println("******Welcome to Hostel check-in Station (19SW51) ******\n");
            System.out.println("1. new entry");
            System.out.println("2. delete entry");
            System.out.println("3. view record");
            System.out.println("4. exit");
            System.out.println("\n\nselect any option");
            i=input.nextInt();

            if(i==1){

                System.out.println("enter an entry: \n");
                System.out.println("enter your name: ");
                String s1=input.next();
                System.out.println("\nenter your roll number: ");
                String s2=input.next();
                Date currentDate = new Date();
                String date= DateFormat.getInstance().format(currentDate);
                lq.add(s1,s2,date);
                System.out.println("\n****entry added successfully****\n\npress enter to go back to main menu");
                mainmenu();
            }

            else if(i==2){
                if((lq.size())>0)
                    System.out.println("****first entry deleted successfully****\n\n");

                try{
                    lq.remove();}
                catch(Exception e){
                    System.out.println(e.getMessage());}

                System.out.println("press enter to go back to main menu");

                mainmenu();}

            else if(i==3){
                System.out.println("****ENTRY BOOK****\n");
                if((lq.size())==0)
                    System.out.println("no record found\n");
                lq.viewList();
                System.out.println("\n\npress enter to go back to main menu");
                mainmenu();}

            else if(i==4){

                System.out.println("****good bye****\n");
                System.exit(0);}

            else{

                System.out.println("invalid key pressed do you want to go back? if yes then press 'y'");
                char c=input.next().charAt(0);
                if(c=='y'){
                    mainmenu();}
                else{

                    System.out.println("****good bye****\n");
                    System.exit(0);}}}

        catch(InputMismatchException e){
            Scanner in=new Scanner(System.in);
            System.out.println("\n"+e.getMessage());

            System.out.println("you can only enter numeric input for selection. do you want to go back?press y to go back");
            String s3=in.next();
            if(s3.equals("y")){

                mainmenu();}
            else
            System.exit(0);}
    }

    public static void main (String[] args){
        CheckIn c=new CheckIn();
        c.mainmenu();
    }
}