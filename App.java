import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu(sc);
    }

    public static void menu(Scanner sc){
        
        BinarySearchTreeOfInteger bst = new BinarySearchTreeOfInteger();
        System.out.println("\fVamos construir uma árvore binária! \nDigite números entre '0 - 999' \nSe você deseja parar, digite '-1'");
        int input = 0;
        
        while(input != -1){
            input = sc.nextInt();
            if(input > -1){
                bst.add(input);
            }
        }

        int op = 0;
        while(op != 5){
            System.out.println("\n[1] - Imprimir o GeraDOT \n[2] - Verificar o balanceamento \n[3] - Balancear \n[4] - Caminhamento central \n[5] - Sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    bst.GeraDOT();
                    break;
                case 2:
                    if(bst.isBalanced()){
                        System.out.println("A árvore está balanceada :)");
                    }else{
                        System.out.println("A árvore não está balanceada :(");

                    }
                    break;
                case 3:
                    bst.applyBalancing();
                    System.out.println("A árvore foi balanceada!");
                    break;
                case 4:
                    LinkedListOfInteger central = bst.positionsCentral();
                    System.out.println("Caminhamento: " + central.toString());
                    break;
                case 5:
                    System.out.println("Valeu sora!");
                    break;
                default:
                    System.out.println("Entrada inválida!");
                    break;
            }
        }
    }   
}
