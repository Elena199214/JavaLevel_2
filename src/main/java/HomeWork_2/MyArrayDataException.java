package HomeWork_2;

public class MyArrayDataException extends Exception {
    public int i;
    public int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String getMessage() {
        System.out.println("\n В ячейке: " + i + "/" + j + " лежит символ или текст вместо числа");
        return null;
    }
}
