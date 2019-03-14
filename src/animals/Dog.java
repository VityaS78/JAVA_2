package animals;

import behavers.Swim;
import service.CharacterService;
import service.impl.DogCharacterService;
import valuetype.Gender;

public class Dog extends Animal {
    private CharacterService characterService = new DogCharacterService();

    public Dog(Gender gender)
    {
        super(gender);
    }

    public Dog(int age, Gender gender)
    {
        super(age, gender);
    }

    public Dog(int age, String name, Gender gender)
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
    public int swim()
    {
        CharacterValue characterValue = characterService.getCharacterValue(ActlType.SWIM, getGender());
        return characterValue.getValue();

    }

//    @Override
//    public boolean onDistance() {
//        return false;
//    }
//
//    @Override
//    public void info() {
//
//    }
}
