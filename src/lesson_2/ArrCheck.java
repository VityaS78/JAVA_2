package lesson_2;

public class ArrCheck {

    private String[][] arr;
    private final int ARR_SIZE = 4;

    public ArrCheck(String[][] arr) {
        this.arr = arr;
    }

    public void goTo() {
        if (checkArr()) {
            System.out.println("It's all riht");
            SumOfArr sumOfArr = new SumOfArr(arr);
            sumOfArr.sumArr();
        }
    }

    private boolean checkArr() {
        try {
            if (arr.length != ARR_SIZE) {
                throw new MyArrSizeException();
            }
            for (int i = 0; i < ARR_SIZE; i++) {
                if (arr[i].length != ARR_SIZE) {
                    throw new MyArrSizeException();
                }
            }
        } catch (MyArrSizeException e) {
            System.out.println(e);
            System.out.println("Неверный размер массива.");
            return false;
        }
        return true;
    }
}
