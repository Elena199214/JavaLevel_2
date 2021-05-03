package HomeWork_1;

abstract public class Barrier {
    String name;
    int distance;

    public Barrier() {
    }

    public Barrier(String name) {
        this.name = name;
    }

    public Barrier(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    void info(){
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return "Barrier{" +
                "distance=" + distance +
                '}';
    }
//   public void overcome(Barrier){
//
//   }


}

