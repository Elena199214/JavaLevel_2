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
            System.out.println("");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "1";
                System.out.print(array[i][j] + " ");
            }

        }


        App app = new App();
        try {

            app.IntSummArray(array);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public static int IntSummArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sumInt = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array.length != 4 && array[i].length != 4) {

                    System.out.println("В массиве некорректно указан размер!!!");
                    throw new MyArraySizeException("Размер массива не 4 на 4");
                }
                try {
                    sumInt += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Передали строку");
                }
            }
        }

        System.out.println("\n" + "Сумма элементов массива = " + sumInt);
                return sumInt;

//            if (size != 4){
//                System.out.println("В массиве некорректно указан размер!!!");
//                throw new MyArraySizeException();
//            }
//
//    throw new Exception("MyArraySizeException");

    }
}

//    public int MetodArray (String[][] array) {
//    int arrayInt = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                arrayInt+= Integer.parseInt(array[i][j]);
//            }
//        }
//        System.out.println("\n"+ "Сумма элементов массива = " + arrayInt);
//        return arrayInt;
//        }
//
//    }

//        try {
//            // блок кода, в котором отслеживаются исключения
//
//            int size = 4;
//            array = new String [size][size];
//            if (size != 4);
//
//            //IllegalArgumentException
//        } catch (MyArraySizeException) {
//            M
//            // обработчик исключения тип_исключения_1
//        } catch (IllegalArgumentException) {
//            // обработчик исключения тип_исключения_2
//        } finally {
//            // блок кода, который обязательно выполнится по завершении блока try
//        }


