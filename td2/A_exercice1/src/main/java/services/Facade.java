package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;
    private Set<String> humors;

    private Facade(){
        users=new HashMap<>();
        humors=new HashSet<>();
        users.put("alice","alice");
        users.put("bob","bob");
        humors.add("triste");
        humors.add("joyeux");
        humors.add("malheureux");
        humors.add("content");
        humors.add("souriant");
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

    public Set<String> getHumors() {
        return humors;
    }
}
