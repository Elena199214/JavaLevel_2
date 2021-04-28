package HomeWork_1;

public interface RunableAndJumpable {

    default void run(Barrier treadmill){
        if (canPassTreadmill(treadmill)){
            System.out.println("может пробежать");
        }else{
            System.out.println("не может пробежать");
        }

    }
    boolean canPassTreadmill(Barrier treadmill);
    default void jump(Barrier wall){
        if (canPassWall(wall)){
            System.out.println("прыгнул");
        }else{
            System.out.println("Не прыгнул");
        }

    }

    boolean canPassWall(Barrier wall);


}

