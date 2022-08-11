package TaskManager;

import Enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskFunctions implements TaskInterface {
    private Scanner input = new Scanner(System.in);
    private List<Task> taskList = new ArrayList<>();

    @Override
    public void createTask() {
        Task task = new Task();
        System.out.println("Please enter the task name");
        task.setTaskTitle(input.nextLine());
        System.out.println("Please enter the task content");
        task.setTaskContent(input.next());
        task.setCreationTime(LocalTime.now());
        task.setCreationDate(LocalDate.now());
        task.setStatus(Status.INCOMPLETE);
        taskList.add(task);
        displayTasks(taskList);

    }

    private void displayTasks(List<Task> taskList) {
        taskList.forEach(task -> System.out.println(task));
    }

    @Override
    public void searchTaskByDate() {
        System.out.println("Please enter the Search-date in format yyyy-mm-dd");
        LocalDate searchDate = LocalDate.parse(input.next());
        List<Task> searchList = taskList.stream().filter(task -> task.getCreationDate().equals(searchDate)).toList();
        if (searchList.isEmpty())
            throw new NullPointerException();
        else
            displayTasks(searchList);
    }

    @Override
    public void updateTask() {
        int choice = 10;
        while (choice != 0) {
            displayTasks(taskList);
            System.out.println("please enter the task name that you wish to update!");
            String taskName = input.next();
            int index = -1;
            for (int i = 0; i < taskList.size(); i++) {
                if(taskList.get(i).getTaskTitle().equals(taskName)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.err.println("Task not found! please try again!");
                return;
            }
            choiceMenu();
            choice = input.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("Please enter the new title");
                    String taskTitle = input.next();
                    taskList.get(index).setTaskTitle(taskTitle);
                    break;
                case 2:
                    System.out.println("Please enter the new content");
                    String taskContent = input.next();
                    taskList.get(index).setTaskContent(taskContent);
                    break;

                case 3:
                    System.out.println("Please enter new Date in yyyy-mm-dd format");
                    LocalDate taskDate = LocalDate.parse(input.next());
                    taskList.get(index).setCreationDate(taskDate);
                    break;

                case 4:
                    System.out.println("Please enter new time");
                    LocalTime time = LocalTime.parse(input.next());
                    taskList.get(index).setCreationTime(time);
                    break;

                case 5:
                    System.out.println("Please enter new status (COMPLETED, INCOMPLETE, INPROGRESS");
                    Status status = Status.valueOf(input.next());
                    taskList.get(index).setStatus(status);
                    break;

                default:
                    System.out.println("Please enter the right selection from 1-5");
                    break;
            }
        }

    }

    private void choiceMenu() {
        System.out.println("***********************************************");
        System.out.println("Please select the item that you want to update and enter 0 to exit!");
        System.out.println("1.Task Title");
        System.out.println("2.Task Content");
        System.out.println("3.Creation Date");
        System.out.println("4.Creation Time");
        System.out.println("5.Status");
        System.out.println("***************************************************");
    }

    @Override
    public void deleteTask() {
        displayTasks(taskList);
        System.out.println("Please enter the task name that you wish to remove!");
        input.nextLine();
        String taskName = input.next();
        if (!taskList.isEmpty()) {
            for (Task task : taskList) {
                if (task.getTaskTitle().equals(taskName)) {
                    taskList.remove(task);
                    System.out.println(taskName + " Successfully removed!");
                    break;
                }
            }
        }
    }
}
