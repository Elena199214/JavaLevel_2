package HomeWork_1;

public class Robot implements  RunableAndJumpable {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Robot(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
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

    public void jump(Barrier wall) {
        if(canPassWall(wall)) {
            System.out.println( "Робот " + this.name + " прыгнул на " + wall.getDistance() + " метра");
        }
        else {
            System.out.println( "Робот "+ this.name + " не сможет прыгнуть на " +wall.getDistance() + " метра");
        }
    }

    @Override
    public void run(Barrier treadmill) {
        if(canPassTreadmill(treadmill)) {
            System.out.println( "Робот " + this.name + " пробежал " + treadmill.getDistance() + " метров");
        }
        else {
            System.out.println( "Робот "+ this.name + " не сможет пробежать " +treadmill.getDistance() + " метров");
        }
    }

}
