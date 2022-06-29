
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(16);
        b.add(17);
        b.add(14);
        b.add(15);
        b.add(11);
        b.add(12);
        b.add(10);
        
        b.GeraDOT();
        System.out.println("-------------");        


        
        b.applyBalancing();
        
        b.GeraDOT();
        System.out.println(b.isBalanced());
    }
   
}
