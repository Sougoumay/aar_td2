package controllers;

import dtos.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

@Controller
@SessionAttributes("courant")
@RequestMapping("/")
public class Exercice3Controller {
    private Facade facade=Facade.getInstance();
    @RequestMapping("")
    public String toLogin(Model model) {

        model.addAttribute("user", new User());
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on joue aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(@Valid User user, BindingResult result,Model model){

        if (result.hasErrors()) {
            return "login";
        }

        String login = user.getLogin();
        String password = user.getPassword();
        if (facade.checkLP(user.getLogin(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getLogin());
            model.addAttribute("username",user.getLogin());
            return "welcome";
        } else {
            // on ajoute un simple message d'erreur au modèle...
            result.addError(new ObjectError("user", "Les informations saisies ne correspondent pas à un utilisateur connu."));
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute("courant") String courant,Model model){
        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status, User user, Model model) {
        model.addAttribute("user",user);
        status.setComplete();
        return "login";
    }
}
