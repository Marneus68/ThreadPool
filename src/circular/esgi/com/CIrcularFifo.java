package circular.esgi.com;

/**
 * Created by madalien on 20/05/15.
 */
public class CIrcularFifo {

    public Node begin = null;
    public Node end = null;
    public int counter = 0;

    public void insert(Node nodeIn){

        if(begin == null){
            begin = nodeIn;
            end = begin;
            counter++;
            //end = new Node();
            //begin.next = end;
        }
        else {
            Node tmp2 = end;
            nodeIn.next = begin;
            tmp2.next = nodeIn;
            end = nodeIn;
            counter++;
        }
    }

    public Node get(){
        Node tmpBegin = new Node(begin);
        end.next = begin.next;
        begin = begin.next;
        counter--;
        return tmpBegin;
    }

    public int getSize(){
        return counter;
    }


}



