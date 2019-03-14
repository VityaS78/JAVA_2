package service.impl;

import animals.ActlType;
import animals.CharacterValue;
import constants.Constants;
import service.CharacterService;
import valuetype.Gender;

public class CatCharacterService implements CharacterService
{
    @Override
    public CharacterValue getCharacterValue(ActlType actType)
    {
        CharacterValue characterValue = new CharacterValue();

        if (actType == ActlType.JUMP)
        {
            int value = (Constants.Cat.Female.POWER + Constants.Cat.Male.POWER) / 2;
            characterValue.setValue(value);
            characterValue.setName(ActlType.JUMP.toString());
        }
        else if (actType == ActlType.RUN)
        {
            int value = (Constants.Cat.Female.SPEED + Constants.Cat.Male.SPEED) / 3;
            characterValue.setValue(value);
            characterValue.setName(ActlType.RUN.toString());
        }
        else if (actType == ActlType.SWIM)
        {
            characterValue = null;
        }

        return characterValue;
    }

    @Override
    public CharacterValue getCharacterValue(ActlType actType, Gender gender)
    {
        CharacterValue characterValue = new CharacterValue();

        if (actType == ActlType.JUMP)
        {
            if (gender == Gender.MALE)
            {
                int value = (Constants.Cat.Male.POWER) / 2;
                characterValue.setValue(value);
                characterValue.setName(ActlType.JUMP.toString());
            }
            else
            {
                int value = (Constants.Cat.Female.POWER) / 5;
                characterValue.setValue(value);
                characterValue.setName(ActlType.JUMP.toString());
            }
        }
        else if (actType == ActlType.RUN)
        {
            if (gender == Gender.MALE)
            {
                int value = (Constants.Cat.Male.SPEED) / 3;
                characterValue.setValue(value);
                characterValue.setName(ActlType.RUN.toString());
            }
            else
            {
                int value = (Constants.Cat.Female.SPEED) / 3;
                characterValue.setValue(value);
                characterValue.setName(ActlType.RUN.toString());
            }
        }
        else if (actType == ActlType.SWIM)
        {
            return null;
        }

        return characterValue;
    }
}
