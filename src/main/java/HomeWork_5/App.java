package HomeWork_5;

import java.util.Arrays;

public class App {


    /**
     * 1. Необходимо написать два метода, которые делают следующее:
     * 1) Создают одномерный длинный массив, например:
     * <p>
     * static final int size = 10000000;
     * static final int h = size / 2;
     * float[] arr = new float[size];
     * <p>
     * 2) Заполняют этот массив единицами;
     * 3) Засекают время выполнения: long a = System.currentTimeMillis();
     * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
     * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     * 5) Проверяется время окончания метода System.currentTimeMillis();
     * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
     * <p>
     * Отличие первого метода от второго:
     * Первый просто бежит по массиву и вычисляет значения.
     * Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.
     * <p>
     * Пример деления одного массива на два:
     * <p>
     * System.arraycopy(arr, 0, a1, 0, h);
     * System.arraycopy(arr, h, a2, 0, h);
     * <p>
     * Пример обратной склейки:
     * <p>
     * System.arraycopy(a1, 0, arr, 0, h);
     * System.arraycopy(a2, 0, arr, h, h);
     * <p>
     * Примечание:
     * System.arraycopy() – копирует данные из одного массива в другой:
     * System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение,
     * откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
     * По замерам времени:
     * Для первого метода надо считать время только на цикл расчета:
     * <p>
     * for (int i = 0; i < size; i++) {
     * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
     * }
     * <p>
     * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
     */

    public static void main(String[] args) throws InterruptedException {

        createsArray();
        try{
            parallel();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }



    public static void createsArray(){

        final int size = 10000000;

        final int h = size / 2;

        float[] arr = new float[size];

        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println( System.currentTimeMillis() - a);



    }


    public static void parallel() throws InterruptedException {

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];


        Arrays.fill(arr, 1);


        long start = System.currentTimeMillis();


        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(a2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Склеиваем массивы:
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        // Подсчет времени:
        long finish = System.currentTimeMillis();
        long result = finish - start;
        System.out.println("Время параллельного выполнения: " + result);
    }

}

