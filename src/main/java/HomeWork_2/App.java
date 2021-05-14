package HomeWork_2;

/**
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
 * и вывести результат расчета.
 */



public class App {


    public static void main(String[] args) {

        String array[][] = new String[4][4];
        for (int i = 0; i < array.length; i++) {
          //  System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
               // System.out.print(array[i][j] + " ");
            }

        }

        String[][] array2;
        array2 = new String[][]{{"1","2", "a"}, {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};

        App app = new App();

//            try {
//                app.intSummArray(array);
//                app.intSummArray(array2);
//            } catch (MyArraySizeException | MyArrayDataException e) {
//
//                e.printStackTrace(System.out);
//            }

        try {
           // app.intSummArray(array);
            app.intSummArray(array2);
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace(System.out);
        }
    }


    public static int intSummArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sumInt = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 || array[i].length != 4) {
                    throw new MyArraySizeException("Размер массива не 4 на 4");
                }
                try {
                    sumInt += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);

                }

            }
        }


        System.out.println("\n" + "Сумма элементов массива = " + sumInt);
        return sumInt;
    }
}
