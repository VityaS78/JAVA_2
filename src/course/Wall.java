package course;

import animals.Animal;
import valuetype.Gender;

public class Wall implements Course{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Animal animal) {
        int value = animal.jump();
        if (value >= height) {
            System.out.println(animal.getName() + " перепрыгнул" + (animal.getGender() == Gender.MALE ? " " : "а " ) + height + " м");
            return true;
        } else {
            System.out.println(animal.getName() + " пе перепрыгнул" + (animal.getGender() == Gender.MALE ? " " : "а " ) + height + " м");
            return false;
        }

    }
}
