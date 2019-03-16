package lesson_2;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {
                {"2", "7", "abc", "lol", "2"},
                {"21"},
                {"2", "7", "abc", "lol", "2"},
                {"2", "7", "abc", "lol"}
        };
        String[][] arr1 = {
                {"2", "7", "abc", "lol"},
                {"12", "5", "Hi", "7"},
                {"Arr", "5", "3", "25",},
                {"White", "7", "Zzzz", "8"}
        };

        ArrCheck arrCheck = new ArrCheck(arr);
        arrCheck.goTo();

        ArrCheck arrCheck1 = new ArrCheck(arr1);
        arrCheck1.goTo();
    }
}
