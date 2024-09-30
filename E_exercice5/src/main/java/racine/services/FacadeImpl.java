package racine.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacadeImpl implements Facade {
    private static FacadeImpl instance=null;

    private final Compteur compteur;

    private Map<String,String> users;

    private FacadeImpl(CompteurImpl compteur){
        this.compteur = compteur;
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }

    @Override
    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
   }

    @Override
    public int getCounter() {
        return this.compteur.getCounter();
   }

    @Override
    public void incrementCounter() {
        this.compteur.incrementCounter();
   }

}
