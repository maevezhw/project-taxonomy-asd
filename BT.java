import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BT{
  private static Node root = null;
  Scanner sc = new Scanner(System.in);
  
  static void baca (String nama, BT a) {
      String data = "";
      try {
             File file = new File(nama);
             Scanner read = new Scanner(file);
             while(read.hasNextLine()){
                 data += read.nextLine();
             }
             read.close();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
          System.out.println(ConsoleColors.RED
 + "an error occured" + ConsoleColors.RESET);
          e.printStackTrace();
      }
         String[] parts = data.split(",");
         String val,sign;
         for(int i=0;i<parts.length;i+=2){
             val = parts[i];
             sign = parts[i+1];
             a.insert(val,sign);
         }
    }
    
    private class Node {
        String value;
        Node leftChild;
        Node rightChild;
            
        public Node(String w) {
            value = w;
            leftChild = rightChild = null;    
        }
        
        public String getValue() {
        return value;
        }
    }
    
    private void insert(String val, String sign) {
        root = insert(root, val, sign);
    }
    
    Node insert(Node r, String value, String passSign) {
        // Check whether there is a sign
        if (passSign.length() == 0) {
            return new Node(value);
        }
        // If needed, create a placeholder node so to be able to descend further
        if (r == null) {
            r = new Node("ada di bumi");
        }
        
        if (passSign.charAt(0) == '+') {
            r.rightChild = insert(r.rightChild, value, passSign.substring(1, passSign.length()));
        } 
        else {
            r.leftChild = insert(r.leftChild, value, passSign.substring(1, passSign.length()));
        }
        return r;
    }

    public String traversePreOrder(Node root) {
      if (root == null) return "";
  
      StringBuilder sb = new StringBuilder();
      sb.append(root.getValue());
  
      String pointerRight = "└──";
      String pointerLeft = (root.rightChild != null) ? "├──" : "└──";
  
      traverseNodes(sb, "", pointerLeft, root.leftChild, root.rightChild!= null);
      traverseNodes(sb, "", pointerRight, root.rightChild, false);
  
      return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
    if (node != null) {
        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.getValue());

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (hasRightSibling) paddingBuilder.append("│  ");
        else paddingBuilder.append("   ");

        String paddingForBoth = paddingBuilder.toString();
        String pointerRight = "└──";
        String pointerLeft = (node.rightChild != null) ? "├──" : "└──";

        traverseNodes(sb, paddingForBoth, pointerLeft, node.leftChild, node.rightChild != null);
        traverseNodes(sb, paddingForBoth, pointerRight, node.rightChild, false);
        }
      }
  
    public void printTree() {
      System.out.println(traversePreOrder(root));    
    }
    public static void printP (Node node) {
        System.out.print(ConsoleColors.WHITE + "\t\t\tApakah organisme tersebut " + node.getValue() + "? " + ConsoleColors.RESET);
    }

    public boolean print (int choice, Node parent) {
        if (parent == null) {return true;}
        if(parent != null){
          if (parent.leftChild != null && parent.rightChild != null){ 
            printP(parent);
            } else if (choice == 1) { System.out.println(ConsoleColors.GREEN + "\t\t\tOrganisme tersebut berasal dari kingdom " + parent.getValue() + ConsoleColors.RESET);return true;}
            else if (choice == 2){System.out.println(ConsoleColors.GREEN + "\t\t\tOrganisme tersebut berasal dari kingdom Animalia kelas " + parent.getValue() + ConsoleColors.RESET);return true;}
            else if (choice == 3) {System.out.println(ConsoleColors.GREEN + "\t\t\tOrganisme tersebut berasal dari kingdom Plantae kelas " + parent.getValue() + ConsoleColors.RESET);return true;
            }
        }
      return true;
    }
  
    public void pilih(int choice, BT pb){
      boolean jawab=true;
      boolean lanjut = true; // alternatif goto
      Node parent = root;
      
      while (parent != null) {
        pb.print(choice, parent);
        if (parent.leftChild == null && parent.rightChild == null) break;
        else if (parent.leftChild != null || parent.rightChild != null) {
          System.out.print(ConsoleColors.RED + "");
          String s = sc.nextLine();
          if (s.equalsIgnoreCase("ya") || s.equalsIgnoreCase("Yes")) jawab = true;
          else if (s.equalsIgnoreCase("no") || s.equalsIgnoreCase("Tidak")) jawab = false;
          else {
            lanjut = false;
            System.out.println(ConsoleColors.CYAN+"\t\t\tjawab dengan [ya/yes/no/tidak]");
          }
          if(lanjut){
            if(jawab) parent = parent.leftChild;
            else parent = parent.rightChild;
          } lanjut = true;
        }
      }
      root = null;
    }
}