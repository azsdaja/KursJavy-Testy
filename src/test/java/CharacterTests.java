import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

public class CharacterTests {
    @Test
    public void newCharacterWithMaxHp10_hpIs10AndMaxHpIs10(){
        Character character = new Character("Czesiek", "Kowalski", 10, null);

        assertThat(character.hp).isEqualTo(10);
        assertThat(character.maxHp).isEqualTo(10);
        assertThat(character.getFullName()).isEqualTo("Czesiek Kowalski");
    }

    @Test
    public void attack_oneCharacterAttacksOther_hpIsDecreasedBy1() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null);
        Character second = new Character("Franek", "Kimono", 10, null);

        first.attack(second);

        assertThat(second.hp).isEqualTo(9);
        assertThat(second.maxHp).isEqualTo(10);
    }

    @Test
    public void attack_characterWithHp10IsHit9Times_itIsAlive() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null);
        Character second = new Character("Franek", "Kimono", 10, null);

        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);

        assertThat(second.isAlive()).isTrue();
    }

    @Test
    public void attack_characterWithHp10IsHit10Times_itIsNotAlive() throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null);
        Character second = new Character("Franek", "Kimono", 10, null);

        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);

        assertThat(second.isAlive()).isFalse();
    }

    @Test
    public void deadCharacterIsAttacked_ExceptionIsThrown() {
        Character attacker = new Character("attacker", "attacker", 10, null);
        final Character dead = new Character("asd", "asd", 1, null);
        dead.hp = 0;

        assertThatThrownBy(() -> {
            attacker.attack(dead);
        }).hasMessageContaining("nieżywa");
    }

    static Stream<Arguments> attackParameters() {
        return Stream.of(
                arguments(1, true),
                arguments(2, true),
                arguments(9, true),
                arguments(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("attackParameters")
    public void attack_performedNTimes_targetIsKilledIfAttackedMoreTimesThanHisHp
            (int hits, boolean expectedIsAlive) throws Exception {
        Character first = new Character("Czesiek", "Kowalski", 10, null);
        Character second = new Character("Franek", "Kimono", 10, null);

        for (int i = 0; i < hits; ++i){
            first.attack(second);
        }

        assertThat(second.isAlive()).isEqualTo(expectedIsAlive);
    }

    @Test
    public void attackFriends() throws Exception {
        Character attacker = new Character("Czesiek", "Kowalski", 10,
                new FakeFacebookProvider());

        attacker.attackFriends();
    }

    @Test
    public void attackFriendsWithMock() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);
        when(providerMock.GetFriends("asdasd")).thenReturn(
                Arrays.asList(
                        new Character("sztuczny znajomy 1", "sztuczny znajomy 1", 10, null),
                        new Character("sztuczny znajomy 2", "sztuczny znajomy 2", 3, null)
                )
        );

        Character attacker = new Character("Czesiek", "Kowalski", 10,
                providerMock);

        attacker.attackFriends();
    }

    @Test
    public void attackFriends_facebookProviderIsCalledForCharactersFullName() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);

        Character attacker = new Character("Czesiek", "Kowalski", 10,
                providerMock);

        attacker.attackFriends();

        verify(providerMock, times(1)).GetFriends("Czesiek Kowalski");
        verifyNoMoreInteractions(providerMock);
    }
}
