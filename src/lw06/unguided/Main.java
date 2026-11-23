package lw06.unguided;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        String num = read.nextLine();
        Scanner sc = new Scanner(num);

        BinarySearchTree b = new BinarySearchTree();

        while (sc.hasNextInt()) {
            int data = sc.nextInt();
            b.insert(data);
        }
        sc.close();

        int target = read.nextInt();
        read.close();

        System.out.print("Preorder   : ");
        b.preOrder();
        System.out.print("Inorder    : ");
        b.inOrder();
        System.out.print("Postorder  : ");
        b.postOrder();


        System.out.println("Search " + target + "  : " + b.search(target));

        System.out.println("Minimum : " + b.findMin());
        System.out.println("Maximum : " + b.findMax());
    }

}
