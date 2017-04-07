import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
/**
 * Created by lirus on 7/4/17.
 */
public class BottomUp {
    public static int counter;
    public static int qwer=0;
    public static Vector<Node>ans=new Vector<>();
    public static void createabove(Node fx,int order)
    {
        Node fn=new Node();
        Node first=fn;
        Vector<Integer>temp;
        Vector<Node>t=new Vector<>();
        while(fx!=null)
        {
            temp=fx.getlmnt();
            int x=temp.get(0);
            if(fn.checksize(order)==1)
            {
                fn.insert(x);
                fn.insertchild(fx);
                fn.size++;
            }
            else
            {
                ans.add(fn);
                t.add(fn);
                Node w=new Node();
                fn.setnext(w);
                w.insert(x);
                w.insertchild(fx);
                w.size++;
                w.setprev(fn);
                fn=w;
            }
            fx=fx.getnext();
        }
        ans.add(fn);
        t.add(fn);
        qwer++;
        if(qwer<counter) {
            String finalans=" ";
            for(int q=0;q<t.size();q++)
                finalans+=t.get(q).getlmnt().toString();
            System.out.println(finalans);
            createabove(first, order);
        }
    }
    public static void printleaves(Leaf f)
    {
        String s=" ";
        while(f!=null)
        {
            s+=f.getvalues().toString();
            f=f.getnext();
        }
        System.out.println("The leaves are  --"+s);
    }
    public static void main(String args[])
    {
        System.out.println("This is the Bottom Up B+ approach ");
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the order of the tree");
        int order=input.nextInt();
        System.out.println("The total number of elements \n");
        int n=input.nextInt();
        counter=(int)(Math.log(n)/Math.log(order-1));
        //System.out.println(counter);
        Vector<Integer> v = new Vector<>();
        int x,i=0;
        while(i++<n)
        {
            x=input.nextInt();
            v.add(x);
        }
        Collections.sort(v);
        int j=0;
        Leaf f=new Leaf();
        for(j=0;j<order-1;j++)
            f.insert(v.get(j));
        Leaf first=f;
        Leaf final1=f;
        j=0;
        for(i=order-1;i<v.size();)
        {
            Leaf q=new Leaf();
            q.setprev(f);
            f.setnext(q);
            f=q;
            while(j++<order-1 && i<v.size())
                q.insert(v.get(i++));
            j=0;
        }
        //System.out.println("im done wiht leaves");
        Vector <Integer> val=new Vector<>();
        Vector <Integer> temp;
        Node fx;
        Node fn=new Node();
        fx=fn;
        while(first!=null)
        {
            temp=first.getvalues();
            x=temp.get(0);
            if(fn.checksize(order)==1)
            {
                fn.insert(x);
                fn.insertchild(first);
                fn.size++;
            }
            else
            {
                ans.add(fn);
                Node w=new Node();
                fn.setnext(w);
                w.insert(x);
                w.insertchild(first);
                w.size++;
                w.setprev(fn);
                fn=w;
            }
            first=first.getnext();
        }
        ans.add(fn);
        String finalans=" ";
        for(int z=0;z<ans.size();z++)
            finalans+=ans.get(z).getlmnt().toString();
        System.out.println(finalans);
        createabove(fx,order);
        printleaves(final1);
        System.out.println("The height of the tree is -- " + counter);
        System.out.println("The total number of nodes are without the leaf nodes -- "+ ans.size());
    }
}
