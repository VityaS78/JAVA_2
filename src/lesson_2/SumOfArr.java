package lesson_2;

public class SumOfArr {

    private int sum = 0;
    private String[][] arr;

    public SumOfArr(String[][] arr) {
        this.arr = arr;
    }

    public void sumArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (Exception es) {
                    System.out.print("Элемент " + i + "-" + j);
                    System.out.println(" Неверные данные");
                }
            }
        }
        System.out.println(sum);
    }
}
