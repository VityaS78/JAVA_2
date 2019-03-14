package animals;

import behavers.Swim;
import service.CharacterService;
import service.impl.HumanCharacterService;
import valuetype.Gender;

public class Human extends Animal {
//    @Override
//    public boolean onDistance() {
//        return false;
//    }
//
//    @Override
//    public void info() {
//
//    }

    private CharacterService characterService = new HumanCharacterService();

    public Human(Gender gender)
    {
        super(gender);
    }

    public Human(int age, Gender gender)
    {
        super(age, gender);
    }

    public Human(int age, String name, Gender gender)
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
}

