

public class HelloWorld {
    public static void main(String[] args) {
        IndexedList<Integer> list = new ArrayIndexedList<Integer>(10);
        list.add(10);
        list.add(12);
        list.add(3, 1);
        list.add(11);
        list.remove(2);
        list.set(20, 1);

        // 10, 20, 11,
        
        System.out.println(list);

    }
    
}
