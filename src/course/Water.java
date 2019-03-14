package course;

import animals.Animal;
import valuetype.Gender;

public class Water implements Course{

    private  int dist;

    public Water(int dist) {
        this.dist = dist;
    }

    @Override
    public boolean doIt(Animal animal) {
        int value = animal.swim();
        if (value >= dist) {
            System.out.println(animal.getName() + " проплыл" + (animal.getGender() == Gender.MALE ? " " : "а " ) + dist + " км");
            return true;
        } else {
            System.out.println(animal.getName() + " не проплыл" + (animal.getGender() == Gender.MALE ? " " : "а " ) + dist + " км");
            return false;
        }

    }


}
