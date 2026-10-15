import java.util.ArrayList;  //arraylist is a collection framework used to store all tasks
import java.util.Scanner;

public class Todolist{
    private static ArrayList<String> tasks = new ArrayList<>(); //initialize new variable for storing task that r entered
    private static Scanner sc = new Scanner(System.in);
     
    //main method
    public static void main(String[] args){
         while(true){
            displayMenu();

            //user choice is entered
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    MarkTaskComplete();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.err.println("Exiting");
                    return;
                default:
                    System.out.println("Enter a valid number");
            }
         }
    }
    public static void displayMenu(){
        System.out.println("\n---ToDo List Menu---");
        System.out.println("1. Add a Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Mark a task as complete");
        System.out.println("4.Delete a Task");
        System.out.println("5. Exit");
        System.out.println("Enetr your choice: ");

    }
    public static void addTask(){
        System.err.println("Enter the task: ");
        String task = sc.nextLine();
        tasks.add(task);
        System.err.println("Task added successfully");
    }
    public static void viewTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available");
            return;
        }
        System.err.println("\n---Your tasks---");
        for(int i=0;i<tasks.size();i++){
            System.err.println((i+1)+"."+tasks.get(i));
        }

    }
    public static void MarkTaskComplete(){
       if(tasks.isEmpty()){
            System.out.println("No tasks available");
            return;
        }
        viewTasks();
        System.err.println("Enter the task number to mark as complete:");
        //user input
        int taskNumber = sc.nextInt();
        sc.nextLine(); //doubt
        
        if(taskNumber<=0 || taskNumber>tasks.size()){
            System.err.println("Invalid task number");
        }
        else{
            String completedTask = tasks.get(taskNumber-1)+"[Completed]";
            tasks.set(taskNumber-1,completedTask);
            System.err.println("task marked as completed");
        }
        
    }
    public static void deleteTask(){
        if(tasks.isEmpty()){
            System.out.println("No tasks available");
            return;
        }
        viewTasks();
        System.err.println("Enter the task number to mark as complete:");
        //user input
        int taskNumber = sc.nextInt();
        sc.nextLine(); //doubt
        
        if(taskNumber<=0 || taskNumber>tasks.size()){
            System.err.println("Invalid task number");
        }
        else{
            tasks.remove(taskNumber-1);
            System.err.println("Task removed successfully");
        }

    }
}