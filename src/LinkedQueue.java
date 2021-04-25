class LinkedQueue{
    public int size;
    private Node head=new Node(null);

    private class Node{
        Object obj1;
        Object obj2;
        Object obj3;
        Node next=this;
        Node prev=this;

        Node(Object obj1){
            this.obj1=obj1;
        }

        Node(Object obj1 , Object obj2 , Object obj3, Node prev , Node next){
            this.obj1=obj1;
            this.obj2=obj2;
            this.obj3=obj3;
            this.prev=prev;
            this.next=next;
        }
    }

    public void add(Object obj1,Object obj2, Object obj3) {
        ++size;
        head.prev=head.prev.next=new Node(obj1,obj2,obj3,head.prev,head);
    }

    public int size(){return size;}

    public Object remove() {
        if(size==0) {
            throw new IllegalStateException("No Record Found ");
        }
        Object temp1=head.next.obj1;
        Object temp2=head.next.obj2;
        Object temp3=head.next.obj3;
        String temp=(temp1+"\t\t"+temp2+"\t\t"+temp3);
        head.next=head.next.next;
        head.next.prev=head;
        --size;
        return temp;
    }

    public void viewList(){
        Node p=head.next; int i=0;
        for(;p!=null&&i<size;p=p.next,i++)
        {System.out.println(p.obj1+"\t\t"+p.obj2+"\t\t"+p.obj3);}
    }
}

