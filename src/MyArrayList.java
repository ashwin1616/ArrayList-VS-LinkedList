import com.oracle.tools.packager.Log;

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
        //Main 클래스에서 for문을 통해서 length 값이 증가되었음
        //main에서의 배열 크기와 해당 클래스의 배열크기가 같으면 해당클래스의 사이즈를 증가하여 새로운 배열에 복사한다
        if (this.length == size) {
            copyArray(data, size);
        } else {
            this.array[this.length] = data;
        }
        //배열의 크기 1 증가
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
        //삭제하지만 삭제된 마지막 배열 공간은 없어지는것이 아님
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

        //추가된 마지막 배열을 새로운 배열에 넣는다
        newArray[newSize - 1] = data;

        //새로운 배열에 기존 배열 값을 넣는다
        for (int i = 0; i < size; i++) {
            newArray[i] = this.array[i];
        }
        //기존 배열을 인스턴스를 새로 생성하여 새로운 배열(newArray)값을 받을 준비를 한다
        this.array = new int[newSize];

        //새로운 배열값에 기존 배열 값 + 마지막 인덱스 데이터를 넣은 값들을
        //새로 인스턴스를 생성한 this.array값에 넣는다
        //이유는 나중에 get() 호출시에, this.array[index]값을 반환하기 위해서다
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
        //3번째 인덱스에 값이 추가되면서 4번째부터 9번째 인덱스의 값을 복사함
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
