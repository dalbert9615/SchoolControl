import java.util.*;

import db.DataBase;
import model.Career;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final DataBase db = new DataBase();

    public static void main(String[] args) {
        int option;
        do {
            /*MENU CRUD (about career)
             * 1.Create -> new career 
             * 2.Read -> careers or career
             * 3.Update -> fields of career 
             * 4.Delete -> eliminate career 
             */
            System.out.println(showMenu());
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Write name of career: ");
                    String name = sc.nextLine();
                    System.out.println(addCareer(name));
                    break;
                case 2:
                    System.out.println(showCareers());
                    break;
            }
        } while (option != 0);
        db.closeConnection();
    }

    private static String showMenu(){
        String output=
            String.format("1. Create Career \n")+
            String.format("2. Show Careers \n")+
            String.format("3. Update Career \n")+
            String.format("4. Delete Career \n")+
            String.format("0. Exit \n")+
            String.format("Select one option \n");
        return output;
    }

    private static String addCareer(String name) {
        Career career = new Career(name);
        boolean inserted = db.insertCareer(career);
        String output = "";
        if (inserted) {
            output = "Career was successfully added.";
        } else {
            output = "Error adding career.";
        }
        return output;
    }

    private static String showCareers() {
        List<Career> careers = db.getAllCareers();
        String output = "";
        if (careers.isEmpty()) {
            output = String.format("Careers is empty \n");
        } else {
            output = String.format("Careers: \n");
            for (Career career : careers) {

                /* Se puede cambiar por un toString del objeto... */
                output += String.format("%d : %s \n", career.getId(), career.getName());
            }
        }
        return output;
    }

}
