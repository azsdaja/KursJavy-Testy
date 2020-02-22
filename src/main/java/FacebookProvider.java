import java.util.Arrays;
import java.util.List;

public class FacebookProvider {
    public List<Character> GetFriends(String fullName) throws InterruptedException {
        Thread.sleep(5000);
        return Arrays.asList(new Character("znajomy", "znajomy", 10, null));
    }
}
