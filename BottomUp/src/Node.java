import java.util.Vector;
import java.util.jar.Pack200;

/**
 * Created by lirus on 7/4/17.
 */
public class Node {
    public Node next;
    public Node prev;
    public Vector<Object> Child;
    public Vector<Integer>lmnt;

    public int size;

    public Node()
    {
        this.size=0;
        this.prev=null;
        this.next=null;
        this.lmnt=new Vector<>();
        this.Child=new Vector<>();
    }
    public void setnext(Node q)
    {
        this.next=q;
    }
    public void setprev(Node q)
    {
        this.prev=q;
    }
    public int checksize(int order)
    {
        if (this.size<order-1)
            return 1;
        else
            return 0;
    }
    public void insertchild(Object c)
    {
        this.Child.add(c);
    }
    public void insert(int x)
    {
        this.lmnt.add(x);
    }
    public Node getnext(){
        return this.next;
    }
    public Node getprev(){
        return this.prev;
    }
    public Vector getlmnt()
    {
        return this.lmnt;
    }
    public Vector getchild()
    {
        return this.Child;
    }
}
