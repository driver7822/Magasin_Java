package be.condorcet.victorlorfevreprojet1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Racine {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
