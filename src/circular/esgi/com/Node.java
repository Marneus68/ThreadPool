package circular.esgi.com;

/**
 * Created by madalien on 20/05/15.
 */
public class Node {
    public Runnable job;
    public Node next;

    public Node(){
        job = null;
        next = null;
    }

    public Node(Runnable jobIn){
        job = jobIn;
    }
    public Node(Runnable jobIn, Node nodeIn){
        job = jobIn;
        next = nodeIn;
    }

    public Node(Node nodeIn){
        job = nodeIn.job;
        next = nodeIn.next;
    }
}
