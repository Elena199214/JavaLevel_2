package Lesson_1;

public interface Workable {
    void work();

    default void rest(){
        System.out.println("default impl");
    }
}
