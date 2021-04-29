package HomeWork_1;

public class Human implements RunableAndJumpable {

    private String name;
    private int runLimit;
    private int jumpLimit;


    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

//    public void overcome(Barrier [] barriers){
//
//        for (Barrier barrier : barriers) {
//            if (barrier.getClass()==wall)

//        }
//            if(canPass(wall)&& wall.getDistance()<= this.jumpLimit){
//        }
//        if(canPass(wall)&& wall.getDistance()<= this.jumpLimit){
//
//
//        }
//    }

    @Override
    public void jump(Barrier wall) {
       if(canPassWall(wall)) {
            System.out.println( "Человек " + this.name + " прыгнул на " + wall.getDistance() + " метра");
        }
        else {
            System.out.println( "Человек "+ this.name + " не сможет прыгнуть на " +wall.getDistance() + " метра");

        }
    }

    @Override
    public void run(Barrier treadmill) {
        if(canPassTreadmill(treadmill)) {
            System.out.println( "Человек " + this.name + " пробежал " + treadmill.getDistance() + " метров");
        }
        else {
            System.out.println( "Человек "+ this.name + " не сможет пробежать " +treadmill.getDistance() + " метров");
        }
    }

    @Override
    public boolean canPassTreadmill(Barrier treadmill) {
        if(treadmill.getDistance()<= this.runLimit){
            return true;

        }
        return false;
    }


    @Override
    public boolean canPassWall(Barrier wall) {
        if(wall.getDistance()<= this.jumpLimit){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }
}
