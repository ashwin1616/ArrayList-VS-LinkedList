/**
 * Created by elicekim on 2017. 6. 30..
 */
public class MyLinkedList {

    private Node head;
    private int size;

    public MyLinkedList(){
        head = null;
        size = 0;
    }

    /**
     * add node in particular index
     * @param index
     * @param newNode
     */
    public void add(int index, Node newNode){
        //in case, first node
        Node nextNode = null;
        if(index == 0 ){
            if(this.head == null){
                this.head = new Node();
                this.head.setNext(newNode);
            } else{
                nextNode = this.head.getNext();
                newNode.setNext(nextNode);
                this.head.setNext(newNode);
            }

        } else {
            //not first node
            if( index < 0 || index > this.size-1 ) {throw new IndexOutOfBoundsException();}

            Node p = this.head;

            for(int i = 0; i < index-1; i++){

                p = p.getNext();

                if(index < this.size) nextNode = p.getNext();

            }
            if(nextNode != null) newNode.setNext(nextNode);

            p.setNext(newNode);
        }

        this.size++;
    }

    /**
     * add node in last index
     * @param index
     * @param newNode
     */
    public void add(Node newNode){
        //in case, first node
        if(this.head == null){
            this.head = new Node();
            this.head.setNext(newNode);

        } else {
            Node p = this.head;
            for(int i = 0; i < this.size; i++){
                p = p.getNext();
            }
            p.setNext(newNode);
        }

        this.size++;
    }

    /**
     * remove particular node
     * @param index
     * @param node
     */
    public void remove(int index){
        //
        Node headNode = this.head;
        if(headNode == null){System.out.println("not exist removing data");}
        Node p = headNode;

        for(int i = 0; i < index-1; i++){
            p = p.getNext();
        }
        p.setNext(p.getNext().getNext());
        this.size--;
        //
    }

    /**
     * return last node
     * @return
     */
    public Node get(){

        if(this.head == null) throw new IndexOutOfBoundsException();
        Node p = head;

        for(int i = 0; i < this.size; i++){
            p = p.getNext();
        }

        return p;
    }

    public void printList(){
        System.out.println("<<Print LinkedList Data>>");
        if(this.head != null){
            Node p = this.head;
            for(int i = 0; i < size; i++){
                p = p.getNext();
                if(p != null) System.out.print(p.getData()+", ");
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
