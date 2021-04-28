package HomeWork_1;

public class App {
    /*
    1.Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
     Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
 соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
  не смог пробежать и т.д.).
3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
     */
    public static void main(String[] args) {
        Human human = new Human("Vasy",500,2);
       Barrier wall = new Wall(3);
       Barrier tread = new Treadmill(1000);

     if (human.canPassWall((Wall) wall)){
         human.jump((Wall) wall);
     }
//          System.out.println("gjkexbkjcm");
//        }


       Barrier [] barriers = new Barrier[4];
       barriers[0] = new Wall(1);
       barriers[1] = new Treadmill(500);
       barriers[2] = new Wall(3);
       barriers[3] = new Treadmill(1000);



       RunableAndJumpable[] runableAndJumpables = new RunableAndJumpable[6];
       runableAndJumpables[0] = new Human("Vasy",800, 2);
       runableAndJumpables[1] = new Human("Katy",1500, 1);
       runableAndJumpables[2] = new Robot("Rob",3000, 5);
       runableAndJumpables[3] = new Robot("Rob2",5000, 2);
       runableAndJumpables[4] = new Cat("Murzik",1200, 3);
       runableAndJumpables[5] = new Cat("Sharik",500, 4);

            for (int j = 0; j < runableAndJumpables.length; j++) {
                for (int i = 0; i < barriers.length; i++) {
                if (barriers[i]instanceof Wall) {
                    runableAndJumpables[j].jump(barriers[i]);


                } else{
                    runableAndJumpables[j].run(barriers[i]);


            }

        }



        }


        }

    }



