public class Main {

    public static void main(String[] args) {

        int[] array = {61, 23, 79, 15, 8, 32, 94, 1};

        System.out.println("<<<<<<<<<<<< MyArrayList TEST>>>>>>>>>>>>>");
        MyArrayList arrayList = new MyArrayList(array.length);

        for (int i = 0; i < array.length; i++) {
            arrayList.add(array[i]);
        }

        arrayList.add(10);
        System.out.println("add last index '10'");

        for (int i = 0; i < arrayList.length; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }

        System.out.println("");
        System.out.println("MyArrayList의 사이즈:" + arrayList.length);
        System.out.println("");

        arrayList.add(3, 20);
        System.out.println("3번째 인덱스에 '20'추가");
        for (int i = 0; i < arrayList.length; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }

        System.out.println("");
        System.out.println("MyArrayList의 사이즈:" + arrayList.length);
        System.out.println("");

        arrayList.remove();

        System.out.println("마지막 인덱스 삭제");
        for (int i = 0; i < arrayList.length; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }

        System.out.println("");
        System.out.println("MyArrayList의 사이즈:" + arrayList.length);
        System.out.println("");

        arrayList.remove(3);
        System.out.println("3번째 인덱스 삭제");
        for (int i = 0; i < arrayList.length; i++) {
            System.out.print(arrayList.get(i) + ", ");
        }

        System.out.println("");
        System.out.println("MyArrayList의 사이즈:" + arrayList.length);
        System.out.println("");

        System.out.println("<<<<<<<<<<<< MyLinkedList TEST >>>>>>>>>>>>>");

        MyLinkedList myLinkedList = new MyLinkedList();
        Node node = null;

        printData(array);
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            node = new Node();
            node.setData(array[i]);
            myLinkedList.add(node);
        }

        System.out.println("LinkedList size : " + myLinkedList.getSize());
        System.out.println("");

        Node lastNode = myLinkedList.get();

        System.out.println("Last Node data : " + lastNode.getData());
        System.out.println("");

        Node addNode = new Node();
        addNode.setData(100);

        myLinkedList.add(3, addNode);
        System.out.println("3번째 인덱스에 새로운 노드를 추가한다.");
        myLinkedList.printList();
        System.out.println("");
        System.out.println("");

        System.out.println("3번째 인덱스의 노드를 삭제한다.");
        myLinkedList.remove(3);
        myLinkedList.printList();

    }

    public static void printData(int[] data) {
        System.out.println("<<원 데이터 출력>>");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("");
    }

}
