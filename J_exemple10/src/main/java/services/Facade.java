package services;

import java.util.HashMap;
import java.util.Map;

public class Facade {
    private Map<String,String> users;

    // On évite de toucher au constructeur... du coup on fait l'initialisation de la map dans une méthode appelée depuis applicationContext.xml
    public void fillMap(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

}
