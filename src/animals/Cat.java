package animals;

import behavers.Swim;
import service.CharacterService;
import service.impl.CatCharacterService;
import valuetype.Gender;

public class Cat extends Animal
{
    private CharacterService characterService = new CatCharacterService();
    private boolean onDistance = true;


    public Cat(Gender gender)
    {
        super(gender);
    }

    public Cat(int age, Gender gender)
    {
        super(age, gender);
    }

    public Cat(int age, String name, Gender gender)
    {
        super(age, name, gender);
    }

    @Override
    public int jump()
    {
        CharacterValue characterValue = characterService.getCharacterValue(ActlType.JUMP, getGender());
        return characterValue.getValue();

    }

    @Override
    public int run()
    {

        CharacterValue characterValue = characterService.getCharacterValue(ActlType.RUN, getGender());
        return characterValue.getValue();
    }

    @Override
    public int swim() {
        System.out.println("Кошки не плавают");
        return 0;
    }


//    @Override
//    public boolean onDistance() {
//        return onDistance;
//    }
//
//    public boolean isOnDistance() {
//        return onDistance;
//    }
//
//    public void setOnDistance(boolean onDistance) {
//        this.onDistance = onDistance;
//    }
//
//    @Override
//    public void info() {
//
//    }
}
