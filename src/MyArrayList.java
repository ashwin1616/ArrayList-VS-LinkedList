/**
 * Created by elicekim on 2017. 6. 30..
 */
public class MyArrayList {

    int MAX_SIZE = 10;
    private int[] array;
    public int length;

    public MyArrayList() {
        super();
        this.length = 0;
        array = new int[MAX_SIZE];
    }

    public MyArrayList(int size) {
        this.length = 0;
        array = new int[size];
    }

    public void add(int data) {
        int size = this.array.length;
        if (this.length == size) {
            copyArray(data, size);
        } else {
            this.array[this.length] = data;
        }
        this.length++;
    }

    public void add(int index, int data) {
        int size = this.array.length;
        if (this.length == size) {
            copyArrayWithIndex(index, data, size);
        } else {
            for (int i = this.length - 1; i > index - 1; i--) {
                this.array[i + 1] = this.array[i];
            }

            this.array[index - 1] = data;
        }
        this.length++;
    }

    //remove data of last index
    public void remove() {

        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.array[this.length - 1] = 0;

        this.length--;
    }

    //remove data of particular index
    public void remove(int index) {
        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.array[index - 1] = 0;

        //after removing index, copy other data
        for (int i = index - 1; i < this.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.length--;
    }

    //add ArrayList algorithm
    private void copyArray(int data, int size) {

        int newSize = size + 1;
        int[] newArray = new int[newSize];

        newArray[newSize - 1] = data;

        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }

        this.array = new int[newSize];

        for (int i = 0; i < newArray.length; i++) {
            this.array[i] = newArray[i];
        }
    }

    //add ArrayList algorithm with particular index
    private void copyArrayWithIndex(int index, int data, int size) {
        int newSize = size + 1;
        int[] newArray = new int[newSize];

        newArray[index - 1] = data;

        //front of index, data copy
        for (int i = 0; i < index - 1; i++) {
            newArray[i] = this.array[i];
        }

        //rear of index, data copy
        for (int i = newSize - 1; i > index - 1; i--) {
            newArray[i] = this.array[i - 1];
        }

        this.array = new int[newSize];

        for (int i = 0; i < newArray.length; i++) {
            this.array[i] = newArray[i];
        }
    }

    public int get(int index) {
        return this.array[index];
    }

}
