import animals.*;
import course.Course;
import course.Road;
import course.Wall;
import course.Water;
import valuetype.Gender;

public class ProgramLauncher {
    public static void main(String[] args) {

        Course[] courses = {
                new Road(2),
                new Water(1),
                new Wall(1)
        };

        Animal[] teammates = {
                new Cat(2, "Vasya", Gender.MALE),
                new Dog(3, "Жучка", Gender.FEMALE),
                new Human(25, "Коля", Gender.MALE),
                new Human(22, "Маша ", Gender.FEMALE)
        };


        for (Animal teammate : teammates) {

            for (Course cours : courses) {
                teammate.setOnDistance(cours.doIt(teammate));


                if (!teammate.isOnDistance()){
                    System.out.println(teammate.getName() + " выбывает из соревнования");
                    break;}



            }
        }

        for (Animal temeamate:teammates) {
            if (temeamate.isOnDistance()) System.out.println(temeamate.getName() + " достигл"  + (temeamate.getGender() == Gender.MALE ? " " : "а " )+ "финиша");
        }


    }
}
