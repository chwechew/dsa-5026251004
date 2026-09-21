package lw01.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("rentals.txt"));
        int r = sc.nextInt();

        Rental[] list = new Rental[r];
        for(int i = 0; i < r; i++){
            String type = sc.next();
            String id = sc.next();
            int days = sc.nextInt();
            int units = sc.nextInt();

              if(type.equals("LAPTOP")){
                list[i] = new LaptopRental(id, days);
              } else if(type.equals("PROJECTOR")){
                list[i] = new ProjectorRental(id, days);
              }
        }
        sc.close();

        for (Rental lists : list) {
            System.out.println(lists.summary());
        }
    }
}
