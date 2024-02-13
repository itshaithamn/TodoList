package tasklist;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Todolist {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> userList = new ArrayList<>();
    static ArrayList<String> dateArray = new ArrayList<>();

    public static void start() throws IOException {
        printInstructions();
        mainLoop(); 
    }

    private static void printInstructions() {
        System.out.println("ToDoList Creator - Create to do lists using Java.");
        System.out.println("Type '!view' to exit and view your list when prompted \"task\"");
        System.out.println("Enter your tasks in the line below.");
        System.out.println("For deadlines, enter your date in the line under your task (i.e. <taskname> M-dd)");
    }

    private static void mainLoop() throws IOException {
        while (true) {
            printLineStart();
            String command = readCommand();
            
            if (isViewListCommand(command)) {
                printList();
                break;
            } else {
                addToTodoList(command);
                calendar.dateArray.mainDeadline();
            }
        }
    }


    private static void printLineStart() {
        System.out.print("Task: ");
    }

    private static String readCommand() {
        return sc.nextLine();
    }

    private static boolean isViewListCommand(String command) {
        return command.equals("!view");
    }

    private static void printList() throws IOException {
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
        Calendar currentDate = Calendar.getInstance();
        System.out.println("List's Date: " + simpleDate.format(currentDate.getTime()));

        BufferedWriter bw = new BufferedWriter(new FileWriter("TodoList.txt"));
        
        for (int listSize = 0; listSize != userList.size(); listSize++) {
            int falseSpaces = createTable(listSize);
            String trueSpaces = generateSpaces(falseSpaces);
            dateArray = calendar.dateArray.calldateArray(listSize);
            System.out.println(listSize + 1 + ". " + userList.get(listSize) + trueSpaces + "\t|||\tDue: " + dateArray.get(listSize));

            String fileWrite = userList.get(listSize) + trueSpaces + "\t|||\tDue: " + dateArray.get(listSize);
            bw.write(fileWrite);
            
            if(listSize != userList.size() - 1){
                bw.newLine();
            }
        }
        bw.close();
    }
    
    private static int createTable(int listSize){

        int maxLength = getMaxStringLength(userList);
        String genSpaces = generateSpaces(maxLength);
        int sizestringVal = 0;
        String stringVal = userList.get(listSize);  // Retrieve the String element at listSize index
        sizestringVal = stringVal.length();  // Get the length of the String element
        int falseSpaces = genSpaces.length() - sizestringVal;

        return falseSpaces;
    }

    private static int getMaxStringLength(ArrayList<String> list) {
        int maxLength = 0;
        for (String s : list) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
    }

    private static String generateSpaces(int maxLength){
        StringBuilder spaces = new StringBuilder();
        for(int i = 0; i < maxLength; i++){
            spaces.append(" ");
        }
        return spaces.toString();
    }


    private static void addToTodoList(String item) {
        userList.add(item);
    }
}