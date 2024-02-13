package calendar;
import java.util.ArrayList;
import java.util.Scanner;

public class dateArray {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> dateArray = new ArrayList<>();

    public static String mainDeadline(){
        System.out.print("Due date: ");
        String deadline = readDeadline();
        if(isDeadline(deadline) == true){
            addDeadline(deadline);
        }else{
            deadline = "null";
            addDeadline(deadline);
        }
        return deadline;
    }

    public static ArrayList<String> calldateArray(int listSize){
        return dateArray;
    }    

    public static String readDeadline() {
        return sc.nextLine();
    }
    

    public static boolean isDeadline(String deadline) {
        String format = "([1-9]|1[0-2])/([1-9]|[12][0-9]|3[01])";
        if(deadline.matches(format)){
            return true;
        }else{
            return false;
        }
    }

    private static void addDeadline(String item){
        dateArray.add(item);
        if(dateArray == null){
            dateArray.add("null");
        }
    }
}