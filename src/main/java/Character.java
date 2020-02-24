

import java.util.List;

public class Character
{
    public String firstName;
    public String lastName;
    public int hp;
    public int maxHp;

    @Deprecated
    /**
     @deprecated - nie używać, zostanie usunięte w wersji 2.15
     **/
    private FacebookProvider facebookProvider;

    public Character(String firstName, String lastName, int maxHp, FacebookProvider facebookProvider){

        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.facebookProvider = facebookProvider;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void attack(Character other) throws Exception {
        if(!other.isAlive()){
            throw new Exception("postac nieżywa!");
        }

        other.hp--;
    }


    @Deprecated
    /**
     @deprecated - nie używać, zostanie usunięte w wersji 2.15
     **/
    public void attackFriends() throws Exception {
        List<Character> friends = facebookProvider.GetFriends(getFullName());
        for (Character friend:friends){
            attack(friend);
            System.out.println("I attacked " + friend.getFullName());
        }
    }

    public boolean isAlive(){
        return hp > 0;
    }


}
