package animals;

import behavers.Jump;
import behavers.Run;
import behavers.Swim;
import course.Road;
import team.Teammate;
import valuetype.Gender;

public abstract class Animal implements Jump, Run, Swim, Teammate{

    private int age;
    private String name;
    private Gender gender;
    private boolean onDistance = true;

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Animal(Gender gender)
    {
        this.gender = gender;
    }

    public Animal(int age, Gender gender)
    {
        this.age = age;
        this.gender = gender;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Animal(int age, String name, Gender gender)
    {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    public void setOnDistance(boolean onDistance) {
        this.onDistance = onDistance;
    }

    @Override
    public boolean onDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(name + (onDistance() ? " прошел" : " не прошел" ));
    }

    @Override
    public int jump() {
        return 0;
    }

    @Override
    public int run() {
        return 0;
    }
}
