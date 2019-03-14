package service.impl;

import animals.ActlType;
import animals.CharacterValue;
import constants.Constants;
import service.CharacterService;
import valuetype.Gender;

public class HumanCharacterService implements CharacterService
{
    @Override
    public CharacterValue getCharacterValue(ActlType actType)
    {
        CharacterValue characterValue = new CharacterValue();

        if (actType == ActlType.JUMP)
        {
            int value = (Constants.Human.Female.POWER + Constants.Human.Male.POWER) / 2;
            characterValue.setValue(value);
            characterValue.setName(ActlType.JUMP.toString());
        }
        else if (actType == ActlType.RUN)
        {
            int value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 3;
            characterValue.setValue(value);
            characterValue.setName(ActlType.RUN.toString());
        }
        else if (actType == ActlType.SWIM)
        {
            int value = (Constants.Human.Female.SPEED + Constants.Human.Male.SPEED) / 5;
            characterValue.setValue(value);
            characterValue.setName(ActlType.SWIM.toString());
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
                int value = (Constants.Human.Male.POWER) / 2;
                characterValue.setValue(value);
                characterValue.setName(ActlType.JUMP.toString());
            }
            else
            {
                int value = (Constants.Human.Female.POWER) / 5;
                characterValue.setValue(value);
                characterValue.setName(ActlType.JUMP.toString());
            }
        }
        else if (actType == ActlType.RUN)
        {
            if (gender == Gender.MALE)
            {
                int value = (Constants.Human.Male.SPEED) / 3;
                characterValue.setValue(value);
                characterValue.setName(ActlType.RUN.toString());
            }
            else
            {
                int value = (Constants.Human.Female.SPEED) / 3;
                characterValue.setValue(value);
                characterValue.setName(ActlType.RUN.toString());
            }
        }
        else if (actType == ActlType.SWIM)
        {
            if (gender == Gender.MALE)
            {
                int value = (Constants.Human.Male.SPEED) / 4;
                characterValue.setValue(value);
                characterValue.setName(ActlType.SWIM.toString());
            }
            else
            {
                int value = (Constants.Human.Female.SPEED) / 5;
                characterValue.setValue(value);
                characterValue.setName(ActlType.SWIM.toString());
            }
        }

        return characterValue;
    }
//    @Override
//    public CharacterValue getCharacterValue(ActlType actlType, Gender gender) {
//        return null;
//    }
//
//    @Override
//    public CharacterValue getCharacterValue(ActlType actlType) {
//        CharacterValue characterValue = new CharacterValue();
//
//        if (actlType == ActlType.JUMP) {
//
//            characterValue.setName("");
//            characterValue.setValue(1);
//
//        } else if (actlType == ActlType.RUN) {
//
//            characterValue.setName("");
//            characterValue.setValue(1);
//
//        } else if (actlType == ActlType.SWIM) {
//
//            characterValue.setName("");
//            characterValue.setValue(1);
//
//        }
//        return characterValue;
//    }
}