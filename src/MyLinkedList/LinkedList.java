package MyLinkedList;

public class LinkedList implements MyList{
    private Nodo first;
    @Override
    public void add(Object value) {
        if (this.first == null){
            this.first = new Nodo(value);
        }else{
            Nodo temp = this.first;
            while(temp.getNext()!= null){

                temp = temp.getNext();

            }
            Nodo newNode = new Nodo(value);
            temp.setNext(newNode);

        }
    }

    @Override
    public Object get(int position) {
        int i = 0;
        Nodo temp = this.first;
        while(i < position){
            temp = temp.getNext();
            if (temp == null){
                return null;
            }
            i++;
        }
        return temp.getValue();
    }

    @Override
    public boolean contains(Object nodo) {
        Nodo temp = this.first;
        int i = 0;
        while(temp.getNext() != null){
            if(nodo != get(i)){
                temp = temp.getNext();
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    @Override
    public void addFirst(Object value) {
        Nodo temp = this.first;
        this.first = new Nodo(value);
        this.first.setNext(temp);
    }


    @Override
    public void addLast(Object value) {
        add(value);
    }

    @Override
    public int size() {
        Nodo temp = this.first;
        int tamaño = 1;
        if (temp == null){
            return 0;
        }
        while(temp.getNext()!= null){
            tamaño++;
            temp = temp.getNext();

        }
        return tamaño;
    }

    @Override
    public void remove(int position) {
        int i = 0;
        Nodo temp = this.first;
        if (get(position) != null) {
            if (position != 0) {
                while (i < position - 1) {
                    temp = temp.getNext();
                    i++;
                }
                if (temp.getNext().getNext() != null) {
                    temp.setNext(temp.getNext().getNext());
                } else {
                    temp.setNext(null);
                }
            } else {

                this.first = temp.getNext();
                temp.setValue(null);
            }
        }


    }

    public LinkedList(){
        this.first = null;
    }

    public static void main(String[] args) {
        LinkedList miLista = new LinkedList();
        miLista.add(1);
        miLista.add(2);
        miLista.add(3);
        miLista.add(4);
        miLista.add(5);
        miLista.add(6);
        miLista.add(7);
        miLista.add(8);
        miLista.add(10);
        miLista.add(11);
        miLista.add(12);
        miLista.add(13);
        miLista.add(14);
        miLista.add(15);
        miLista.add(16);
        System.out.println(miLista.get(13));
        miLista.remove(13);
        int i= 0;
        while(i < miLista.size()){
            System.out.println(miLista.get(i));
            i++;
        }
        miLista.add(22);
        System.out.println(miLista.get(14));
        miLista.contains(7);
        miLista.addFirst(32);
        System.out.println(miLista.get(0));
        System.out.println(miLista.get(1));
        miLista.remove(16);
        System.out.println(miLista.get(15));

    }
}
