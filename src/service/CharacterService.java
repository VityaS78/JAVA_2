package service;

import animals.ActlType;
import animals.CharacterValue;
import valuetype.Gender;

public interface CharacterService {

    CharacterValue getCharacterValue(ActlType actlType);

    CharacterValue getCharacterValue(ActlType actlType, Gender gender);
}
