package lesson_5;

import java.util.HashSet;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        method1(arr);
        method2(arr);

    }

    private static void method1(float[] arr) {
        fillArr(arr);
        long a = System.currentTimeMillis();
        recountArr(arr);
        System.out.println("Time for method1 = " + (System.currentTimeMillis() - a));
    }

    private static void method2(float[] arr) {
        fillArr(arr);
        long a = System.currentTimeMillis();
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        Thread thread1 = new Thread(() -> recountArr(a1));
        Thread thread2 = new Thread(() -> recountArr(a2));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println("Time for method2 = " + (System.currentTimeMillis() - a));
    }

    private static float[] fillArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    private static float[] recountArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;
    }
}
