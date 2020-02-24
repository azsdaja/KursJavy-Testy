import org.assertj.core.api.AbstractAssert;

public class CharacterAssert extends AbstractAssert<CharacterAssert, Character> {
    public CharacterAssert(Character character, Class<?> selfType) {
        super(character, selfType);
    }

    public static CharacterAssert assertThat(Character character){
        return new CharacterAssert(character, CharacterAssert.class);
    }

    public CharacterAssert isAlive(){
        isNotNull();
        if(!actual.isAlive()){
            failWithMessage("Postać " + actual.getFullName() +
                    " jest martwa, a powinna być żywa!");
        }
        return this;
    }

    public CharacterAssert hasHp(int expectedHp){
        isNotNull();
        if(actual.hp != expectedHp){
            failWithMessage("Postać " + actual.getFullName() +
                    " ma " + actual.hp + ", a powinna mieć " + expectedHp);
        }
        return this;
    }
}
