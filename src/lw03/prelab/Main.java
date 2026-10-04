package lw03.prelab;
import java.util.*;

public class Main {
    public static void problem1() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>(); 

            while(sc.hasNext()){
                String list = sc.nextLine();
                String p [] = list.split(" ");

                if(p[0].equals("ADD")){
                    String song = "";
                    for(int i = 1; i < p.length; i++){
                        song = song + p[i];
                        if(i < p.length -1){
                            song = song + " ";
                        }
                    }
                    playlist.add(song);
                } else if(p[0].equals("INSERT")){
                    int num = Integer.parseInt(p[1]);
                    String song = "";
                    for(int i = 2; i < p.length; i++){
                        song = song + p[i];
                        if(i < p.length -1){
                            song = song + " ";
                        }
                    }
                    playlist.add(num, song);
                } else if(p[0].equals("REMOVE")){
                    String song = "";
                    for(int i = 1; i < p.length; i++){
                        song = song + p[i];
                        if(i < p.length -1){
                            song = song + " ";
                        }
                    }
                    playlist.remove(song);
                }
            }
           sc.close(); 

           System.out.println("===== Problem 1 =====");
           System.out.println("Total songs: " + playlist.size());
           for(int i = 0; i < playlist.size(); i++){
            System.out.println((i+1) + ": " + playlist.get(i));
           } 
           System.out.println();
    }

    public static void problem2() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        while(sc.hasNext()){
            String name = sc.nextLine();
            if(participants.contains(name)){
                duplicate++;
            } else {
                participants.add(name);
            }
        }
        sc.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int i = 1;
        for(String name : participants){
            System.out.println(i + ". " + name);
            i++;
        }
        System.out.println("Duplicate registrations: " + duplicate);
        System.out.println();
    }

    public static void problem3() {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;

         while(sc.hasNext()){
            String type = sc.next();
            String product = sc.next();
            int quantity = sc.nextInt();

            if(type.equals("ADD")){
                if(inventory.containsKey(product)){
                    inventory.put(product, inventory.get(product)+quantity);
                }else{
                    inventory.put(product,quantity);
                }
            } else if(type.equals("SELL")){
                if(inventory.containsKey(product) && inventory.get(product) >= quantity){
                    inventory.put(product, inventory.get(product)-quantity);
                }else{
                    failed++;
                }
            }
        }
        sc.close();

            System.out.println("===== Problem 3 =====");
            for (String product : inventory.keySet()) {
                System.out.println(product + ": " + inventory.get(product));
            }
            System.out.println("Failed sales: " + failed);
    }

    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }
}
