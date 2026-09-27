package lw02.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> fails = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while(sc.hasNext()){
            String[] transaction = new String[3];
            transaction[0] = sc.next();
            transaction[1] = sc.next();
            transaction[2] = sc.next();
            transactions.add(transaction);
        }
        queue.addAll(transactions);

        sc.close();

        while(!queue.isEmpty()){
            String[] transaction = queue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            String[] customer = null;

            for(String [] data : customers){
                if (data[0].equals(name)) {
                    customer = data;
                    break;
                }
            }
            if(customer == null){
                customer = new String[]{name, "0"};
                customers.add(customer);
            }

            int balance = Integer.parseInt(customer[1]);

            if(type.equals("DEPOSIT")){
                balance += amount;
                customer[1] = String.valueOf(balance);
            } else {
                if(balance < amount){
                    fails.push(transaction);
                } else {
                    balance -= amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
            for(String [] c : customers){
                System.out.println(c[0] + " : " + c[1]);
            }

        System.out.println("");

        System.out.println("=== Failed Transactions ===");
            while(!fails.isEmpty()){
                String [] fail = fails.pop();
                System.out.println(fail[0] + " " + fail[1] + " " + fail[2]);
            }
        
    }
}
