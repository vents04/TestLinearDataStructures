public class Test {
    public static void main(String[] args) {
        CycleLinkedList<String> list = new CycleLinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.get(1));
        System.out.println(list.get(12));
        System.out.println(list.get(-1));
        System.out.println(list.get(-12));
    }
}
