package course;

import animals.Animal;
import animals.Cat;
import team.Teammate;
import valuetype.Gender;

public class Road implements Course {

    private int dist;

    public Road(int dist) {
        this.dist = dist;
    }

    @Override
    public boolean doIt(Animal animal) {
        int value = animal.run();
        if (value >= dist) {
            System.out.println(animal.getName() + " пробежал" + (animal.getGender() == Gender.MALE ? " " : "а " ) + dist + " км");
            return true;
        } else {
            System.out.println(animal.getName() + " не пробежал" + (animal.getGender() == Gender.MALE ? " " : "а " ) + dist + " км");
            return false;
        }
    }

//    @Override
//    public boolean doIt(int value) {
//        if (value >= dist) {
//            System.out.println("Прошел");
//            return true;
//        } else {
//            System.out.println("Не прошел");
//            return false;
//        }
//
//    }
}
