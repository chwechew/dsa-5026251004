package lw03.unguided;
import java.util.*;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
       Map<String, Integer> enroll = new LinkedHashMap<>();
       List<String> not = new ArrayList<>(); 
       int reject = 0;

       while(sc.hasNextLine()){
        String list = sc.nextLine();
        String p [] = list.split(" ");
        String type = p[0];
        String course = p[1];

        if(type.equals("REGISTER")){
            int num = Integer.parseInt(p[2]);
            if(enroll.containsKey(course)){
                enroll.put(course, enroll.get(course)+num);
            } else if(enroll.containsKey(course) && num <= 0){
                reject++;
            } else {
                enroll.put(course, num);
            }
        } else if (type.equals("WITHDRAW")){
            int num = Integer.parseInt(p[2]);
            if(enroll.containsKey(course) && enroll.get(course) >= num){
                enroll.put(course, enroll.get(course)-num);
            } else {
                reject++;
            }
        } else {
            if(!enroll.containsKey(course)){
                not.add(course);
                reject++;
            }
        }
       }
       sc.close();

       System.out.println("===== Enrollment Checks =====");
        for(String c : enroll.keySet()){
            if(enroll.containsKey(c)){
            System.out.println(c + ": " + enroll.get(c) + " students");
            }
        }
        for(String n : not){
            System.out.println(n + ": Not Found");
        }
       System.out.println();

        System.out.println("===== Final Enrollment =====");
            for(String course : enroll.keySet()){
                System.out.println(course + ": " + enroll.get(course) + " students");
            }
       System.out.println("Rejected operations: " + reject);
   } 
}

