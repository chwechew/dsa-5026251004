package lw04.unguided;
import java.util.*;

public class Main {
    public static void sortCards(int[] values, int passes) {
        for (int i = 0; i < passes; i++){
            int min = i;
            for (int j = i+1; j < values.length; j++){
                if(values[j] < values[min]){
                    min = j;
                }
            }
            int temp = values[i];
            values[i] = values[min];
            values[min] = temp;
        }
    }

    public static int findCard(int[] values, int target) {
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int size = sc.nextInt();
        int values[] = new int[size];
        for(int i = 0; i < size; i++){
            values[i] = sc.nextInt();
        }

        int targetSize = sc.nextInt();
        int target[] = new int[targetSize];

        for(int i = 0; i < targetSize; i++){
            target[i] = sc.nextInt();
        }

        sortCards(values, 2);
        
        for (int i = 0; i < size; i++) {
            System.out.print(values[i]);
            if (i < size - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for(int t : target){
            int idx = findCard(values, t);
            if(idx != -1){
                System.out.println(t + ": FOUND at index " + idx);
            } else {
            System.out.println(t + ": NOT FOUND");
            }
        }
        
    }
}

