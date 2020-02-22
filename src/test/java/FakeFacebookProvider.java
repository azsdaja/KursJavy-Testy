import java.util.Arrays;
import java.util.List;

public class FakeFacebookProvider extends FacebookProvider {
    @Override
    public List<Character> GetFriends(String fullName) throws InterruptedException {
        return Arrays.asList(
                new Character("sztuczny znajomy 1", "sztuczny znajomy 1", 10, null),
                new Character("sztuczny znajomy 2", "sztuczny znajomy 2", 3, null)
                );
    }
}
