package lw02.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> borrowing = new LinkedList<>();
        LinkedList<String[]> book = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while(sc.hasNext()){
            String [] req = new String[2];
            req[0] = sc.next();
            req[1] = sc.next();
            borrowing.add(req);
        }
        queue.addAll(borrowing);

        //Kalkulus: 2, Fisika: 1, Statistika: 2

        String[] bookList = new String[2];
        // bookList.add(new String[]('Kalkulus', '2'));
        book.add(bookList);

        while(!queue.isEmpty()){
            String[] request = queue.poll();
            String name = request[0];
            String books = request[1];
            int status = 0;


            String[] members = null;

            for(String [] c : member){
                if (c[0].equals(name)) {
                    members = c;
                    break;
                }
            }

            if(members == null){
                members = new String[]{name, books};
                member.add(members);
            }


            if(status < 2){
            } else {
                failed.push(request);

            }
        }

        System.out.println("=== Successfully Processed Requests ===");
            for(String[] m : member){
                System.out.println(m[0] + " " + m[1]);
            }

        System.out.println("");

        System.out.println("=== Remaining Book Stock ===");
            for(String[] b : book){
                System.out.println(b[0] + " : " + b[1]);
            }

        System.out.println("");

        System.out.println("=== Failed Requests ===");
        while(!failed.isEmpty()){
            String[] f = failed.pop();
            System.out.println(f[0] + " " + f[1]);
        }
    }
}
