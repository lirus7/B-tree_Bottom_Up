import java.util.Vector;
import java.util.jar.Pack200;

/**
 * Created by lirus on 7/4/17.
 */
public class Leaf {
    public Vector<Integer>data=new Vector();
    public Leaf next;
    public Leaf prev;
    public int size;
    public Leaf()
    {
        this.size=0;
        this.next=null;
        this.prev=null;
        this.data=new Vector<>();
    }
    public void setnext(Leaf l)
    {
        this.next=l;
    }
    public int checksize(int order)
    {
        if (this.size<order-1)
            return 1;
        else
            return 0;
    }
    public void setprev(Leaf l)
    {
        this.prev=l;
    }
    public void insert(int x)
    {
        this.data.add(x);
    }
    public Leaf getnext()
    {
        return this.next;
    }
    public Leaf getprev()
    {
        return this.prev;
    }
    public Vector getvalues()
    {
        return this.data;
    }
}
