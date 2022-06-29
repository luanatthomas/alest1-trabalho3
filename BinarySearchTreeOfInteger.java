
public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; // contagem do número de nodos
    private Node root; // referência para o nodo raiz

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        root = add(root, element, null);
        count++;
    }

    private Node add(Node n, Integer e, Node father) {
        if (n == null) {
            Node aux = new Node(e);
            aux.father = father;
            return aux;
        }
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        } else {
            n.left = add(n.left, e, n);
        }
        return n;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); // Visita o nodo
            positionsPreAux(n.left, res); // Visita a subárvore da esquerda
            positionsPreAux(n.right, res); // Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); // Visita a subárvore da esquerda
            positionsPosAux(n.right, res); // Visita a subárvore da direita
            res.add(n.element); // Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); // Visita a subárvore da esquerda
            res.add(n.element); // Visita o nodo
            positionsCentralAux(n.right, res); // Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public boolean contains(Integer element) {
        Node aux = searchNodeRef(element, root);
        return (aux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (element == null || target == null) {
            return null;
        }
        int r = target.element.compareTo(element);
        if (r == 0) {
            return target;
        } else if (r > 0) {
            return searchNodeRef(element, target.left);
        } else {
            return searchNodeRef(element, target.right);
        }
    }

    public int height() {
        if (root == null) {
            return 0;
        }
        return height(root);
    }

    private int height(Node n) {
        if (n == null) {
            return 0;
        }

        int lH = height(n.left);
        int rH = height(n.right);

        if (lH > rH) {
            if (n.father == null) {
                return lH;
            }
            return lH + 1;
        } else {
            if (n.father == null) {
                return rH;
            }
            return rH + 1;
        }
    }

    private int balanceFactor(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    public void applyBalancing() {
        if (root != null) {
            while (!isBalanced()) {
                applyBalancingAux(root);
            }
        }
    }

    private void applyBalancingAux(Node n) {
        if (n == null) {
            return;
        }
        boolean balanceado = false;

        while (!balanceado) {
            balanceado = true;
            // EE e ED
            if (balanceFactor(n) > 1) {
                balanceado = false;
                if (height(n.left.left) < height(n.left.right)) {
                    //ED
                    rotacaoED(n);
                }else{
                    //EE
                    rotacaoEE(n);
                }
            }

            // DD e DE
            if (balanceFactor(n) < -1) {
                balanceado = false;
                if (height(n.right.left) > height(n.right.right)) {
                    //DE
                    rotacaoDE(n);
                }else{
                    //DD
                    rotacaoDD(n);
                }               
            }
        }
        applyBalancingAux(n.left);
        applyBalancingAux(n.right);
    }

    public boolean isBalanced() {
        return isBalancedAux(root);
    }

    private boolean isBalancedAux(Node n) {
        if (n == null) {
            return true;
        }

        boolean nBalanced = true;
        boolean leftBalenced;
        boolean rightBalanced;

        if (Math.abs(balanceFactor(n)) > 1) {
            nBalanced = false;
        }

        leftBalenced = isBalancedAux(n.left);
        rightBalanced = isBalancedAux(n.right);

        return leftBalenced && rightBalanced && nBalanced;
    }

    private void rotacaoEE(Node n) {
        boolean ehRoot = false;
        if (getRoot() == n.element) {
            ehRoot = true;
        }

        Node esquerda = n.left;
        esquerda.father = n.father;
        n.left = esquerda.right;

        if (n.left != null) {
            n.left.father = n;
        }

        if (ehRoot) {
            root = esquerda;
        }

        esquerda.right = n;
        n.father = esquerda;
        if (esquerda.father != null) {
            if (esquerda.father.right == n) {
                esquerda.father.right = esquerda;

            } else if (esquerda.father.left == n) {
                esquerda.father.left = esquerda;
            }
        } else {

        }
    }

    private void rotacaoDD(Node n) {
        boolean ehRoot = false;
        if (getRoot() == n.element) {
            ehRoot = true;
        }

        Node direita = n.right;
        direita.father = n.father;
        n.right = direita.left;

        if (n.right != null) {
            n.right.father = n;
        }

        if (ehRoot) {
            root = direita;
        }

        direita.left = n;
        n.father = direita;
        if (direita.father != null) {

            if (direita.father.right == n) {
                direita.father.right = direita;

            } else if (direita.father.left == n) {
                direita.father.left = n;
            }
        }
    }

    private void rotacaoDE(Node n) {
        rotacaoDD(n.left);
        rotacaoEE(n);
    }

    private void rotacaoED(Node n) {
        rotacaoEE(n.right);
        rotacaoDD(n);
    }

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        // "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        // "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        // "[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        // node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
}
