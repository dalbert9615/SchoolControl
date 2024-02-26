import java.util.*;

import dao.CareerDAO;
import dao.CareerDAOImplement;
import model.Career;

public class Main {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(showHomeMenu());

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    CareerMenu();
                    break;
                case 2:
                case 3:
                case 4:
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No valid option, try again.");
            }
        }
    }

    private static String showHomeMenu() {
        String output = String.format("\n School Control \n") +
                String.format("1. About Careers \n") +
                String.format("2. About Subjects \n") +
                String.format("3. About Estudiants \n") +
                String.format("4. About Professors \n") +
                String.format("0. Exit \n") +
                String.format("Select one option \n");
        return output;
    }

    private static void CareerMenu() {
        Scanner sc = new Scanner(System.in);
        CareerDAO careerDAO = new CareerDAOImplement();

        while (true) {
            System.out.println(showCareerMenu());
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Write name of Career");
                    String name = sc.nextLine();
                    Career newCareer = new Career(name);
                    System.out.println(careerDAO.createCareer(newCareer)); 
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("No valid option, try again.");
            }
        }

    }

    private static String showCareerMenu() {
        String output = String.format("\n Menu Career \n") +
                String.format("1. Create Career \n") +
                String.format("2. Show Careers \n") +
                String.format("3. Search Career by ID \n") +
                String.format("4. Update Career \n") +
                String.format("5. Delete Career \n") +
                String.format("6. Back Home \n") +
                String.format("Select one option \n");
        return output;
    }
}
