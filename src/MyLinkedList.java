/**
 * Created by elicekim on 2017. 6. 30..
 */
public class MyLinkedList {

    private Node headNode;
    private int size;

    public MyLinkedList() {
        headNode = null;
        size = 0;
    }

    /**
     * add node in particular index
     *
     * @param index
     * @param newNode
     */
    public void add(int index, Node newNode) {
        //in case, first node
        Node nextNode = null;
        if (index == 0) {
            if (this.headNode == null) {
                this.headNode = new Node();
                this.headNode.setNextNode(newNode);
            } else {
                nextNode = this.headNode.getNextNode();
                newNode.setNextNode(nextNode);
                this.headNode.setNextNode(newNode);
            }

        } else {
            //not first node
            if (index < 0 || index > this.size - 1) {
                throw new IndexOutOfBoundsException();
            }

            Node p = this.headNode;

            for (int i = 0; i < index - 1; i++) {

                p = p.getNextNode();

                if (index < this.size) nextNode = p.getNextNode();

            }
            if (nextNode != null) newNode.setNextNode(nextNode);

            p.setNextNode(newNode);
        }

        this.size++;
    }

    /**
     * add node in last index
     *
     * @param index
     * @param newNode
     */
    public void add(Node newNode) {
        //in case, first node
        if (this.headNode == null) {
            this.headNode = new Node();
            this.headNode.setNextNode(newNode);
            System.out.println("newNode "+newNode);
        } else {
            Node p = this.headNode;
            for (int i = 0; i < this.size; i++) {
                p = p.getNextNode();
                System.out.println("Node "+p);
            }
            p.setNextNode(newNode);
        }

        this.size++;
    }

    /**
     * remove particular node
     *
     * @param index
     * @param node
     */
    public void remove(int index) {
        //
        Node headNode = this.headNode;
        if (headNode == null) {
            System.out.println("not exist removing data");
        }
        Node p = headNode;

        for (int i = 0; i < index - 1; i++) {
            p = p.getNextNode();
        }
        p.setNextNode(p.getNextNode().getNextNode());
        this.size--;
        //
    }

    /**
     * return last node
     *
     * @return
     */
    public Node get() {

        if (this.headNode == null) throw new IndexOutOfBoundsException();
        Node p = headNode;

        for (int i = 0; i < this.size; i++) {
            p = p.getNextNode();
        }

        return p;
    }

    public void printList() {
        System.out.println("<<Print LinkedList Data>>");
        if (this.headNode != null) {
            Node p = this.headNode;
            for (int i = 0; i < size; i++) {
                p = p.getNextNode();
                if (p != null) System.out.print(p.getData() + ", ");
            }
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
