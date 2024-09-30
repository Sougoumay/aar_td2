package racine.controllers;

import racine.dtos.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import racine.services.Facade;
import racine.services.FacadeImpl;

@Controller
@SessionAttributes({"courant","counter"})
@RequestMapping("/")
public class Exercice5Controller {

    private final Facade facade;

    public Exercice5Controller(FacadeImpl facade) {
        this.facade = facade;
    }


    @RequestMapping("/")
    public String toLogin(Model model) {
        facade.incrementCounter();
        model.addAttribute("counter", facade.getCounter());
        model.addAttribute("user", new User());
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on joue aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(User user, Model model){

        facade.incrementCounter();
        model.addAttribute("counter", facade.getCounter());
        if (facade.checkLP(user.getLogin(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getLogin());
            model.addAttribute("username",user.getLogin());
            return "welcome";
        } else {
            // on ajoute un simple message d'erreur au modèle...
            model.addAttribute("error","Les informations saisies ne correspondent pas à un utilisateur connu.");
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute("courant") String courant,Model model){
        facade.incrementCounter();
        model.addAttribute("counter", facade.getCounter());

        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status, Model model) {

        model.addAttribute("user",new User());
        status.setComplete();
        return "login";
    }
}
