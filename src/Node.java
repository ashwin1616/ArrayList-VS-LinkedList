/**
 * Created by elicekim on 2017. 6. 30..
 */
public class Node {

    private Node next;
    private int data;

    //return the next
    public Node getNextNode() {
        return next;
    }

    //@param next the next to set
    public void setNextNode(Node next) {
        this.next = next;
    }

    //@return the data
    public int getData() {
        return data;
    }

    //@param data the data to set
    public void setData(int data) {
        this.data = data;
    }
}
