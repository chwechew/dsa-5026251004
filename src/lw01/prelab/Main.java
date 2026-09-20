package lw01.prelab;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        ArrayList<PrintJob> job = new ArrayList<>();

        while (sc.hasNext()){
            String type = sc.next();
            String id = sc.next();
            int pages = sc.nextInt();

            if(type.equals("MONO")){
                job.add(new MonoPrint(id, pages));
            } else if(type.equals("COLOUR")){
                job.add(new ColourPrint(id, pages));
            }
        }
        sc.close();

        for (PrintJob jobs : job) {
            System.out.println(jobs.summary());
        }

    }
    
}
