package TaskManager;

import java.util.Scanner;

public class Main {
    /*
    create a cmd app "Task mamager"
it should have 4 functions:
-Create a task
-update
-delete a task
-search a task(search by date).else display all

How to create a task:
-title
-content
-date
-time
-reminder
-status(Completed,not-completed)


     */

    private static TaskFunctions functions = new TaskFunctions();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {

            System.out.println("*******************Welcome to TaskFunctions-Manager**********************");
            System.out.println("Please choose the desired task from the menu below:");
            System.out.println("1.Create a new task");
            System.out.println("2.Update your task");
            System.out.println("3.Delete a task");
            System.out.println("4.Search a task my the Date created");
            System.out.println("Please enter 0 to exit the menu!!");
            System.out.println("**************************************************************************");


            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1:
                    functions.createTask();
                    break;
                case 2:
                    functions.updateTask();
                    break;
                case 3:
                    functions.deleteTask();
                    break;
                case 4:
                    functions.searchTaskByDate();
                    break;
                default:
                    System.out.println("Wrong choice! please try again!");
            }

        }
        System.out.println("Thank you for using our service! GoodBye :)");
    }

}
