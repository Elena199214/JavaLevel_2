package HomeWork_1;

public class Cat implements RunableAndJumpable {
    private String name;
    private int runLimit;
    private int jumpLimit;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean canPassTreadmill(Barrier treadmill) {
        if(treadmill.getDistance()<= this.runLimit){
            return true;}
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
            System.out.println( "Кот " + this.name + " прыгнул на " + wall.getDistance() + " метра");
        }
        else {
            System.out.println( "Кот "+ this.name + " не сможет прыгнуть на " +wall.getDistance() + " метра");
        }
    }

    @Override
    public void run(Barrier treadmill) {
        if(canPassTreadmill(treadmill)) {
            System.out.println( "Кот " + this.name + " пробежал " + treadmill.getDistance() + " метров");
        }
        else {
            System.out.println( "Кот "+ this.name + " не сможет пробежать " +treadmill.getDistance() + " метров");
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }
}
