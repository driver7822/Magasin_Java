package be.condorcet.victorlorfevreprojet1;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;
import be.condorcet.victorlorfevreprojet1.repositories.ClientRepository;
import be.condorcet.victorlorfevreprojet1.services.ClientServiceImpl;
import be.condorcet.victorlorfevreprojet1.services.ComfactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
public class Victorlorfevreprojet1Application implements CommandLineRunner {

    /*@Autowired
    private ClientRepository clientRepository;*/

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @Autowired
    private ComfactServiceImpl comfactServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(Victorlorfevreprojet1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Hello World");
        Client cl = new Client(null,"Dupuis","Robert",7800,"Ath","de la station","25","0479459874",null);
        clientRepository.save(cl);

        System.out.println("Création de "+cl);
        System.out.println("Liste de tous les clients");

        Collection<Client> lcl = clientRepository.findAll();
        lcl.stream().forEach(System.out::println);

        int n = cl.getIdclient();
        String nom = cl.getNom();
        String prenom = cl.getPrenom();
        String loc = cl.getLocalite();
        String tel = cl.getTel();

        System.out.println("Recherche du client n° : "+n);

        Optional<Client> ocl = clientRepository.findById(n);
        ocl.ifPresent(System.out::println);

        System.out.println("Recherche des clients de nom : "+nom);
        lcl = clientRepository.findByNomLike(nom);
        lcl.stream().forEach(System.out::println);

        System.out.println("Recherche des clients par localité : "+loc);
        lcl = clientRepository.findByLocaliteLike(loc);
        lcl.stream().forEach(System.out::println);

        System.out.println("Recherche du client de nom : "+nom+" prenom : "+prenom+" tel: "+tel);
        lcl = clientRepository.findByNomLikeAndPrenomLikeAndTelLike(nom,prenom,tel);
        lcl.stream().findFirst().ifPresent(System.out::println);

        System.out.println("Effacemment du client n° "+n);
        clientRepository.deleteById(n);
        ocl = clientRepository.findById(n);
        if (ocl.isPresent()) System.out.println("Record pas effacé");
        else System.out.println("record effacé");*/

        Client cl = new Client(null,"Lebrun","Marie",1000,"BXL","de la pierre bleue","15","0458/888555",null);
        Comfact cf = new Comfact(null,null, Date.valueOf(LocalDate.now()),"c",new BigDecimal(1000),null);
        try{
            clientServiceImpl.create(cl);
        }
        catch (Exception e){
            System.out.println("erreur de création "+e);
        }
        try {
            cf.setClient(cl);
            System.out.println("commande à créer : "+cf);
            comfactServiceImpl.create(cf);
            System.out.println("commande créée :" +cf);
        }
        catch (Exception e){
            System.out.println("erreur de création de commande"+e);
        }
        try {
            System.out.println("commandes du client");
            System.out.println("lecture");
            cl=clientServiceImpl.read(cl.getIdclient());
            System.out.println("affichage");
            System.out.println(cl);
            // cl.getComfacts().stream().forEach(System.out::println);

            comfactServiceImpl.getComfacts(cl).stream().forEach(System.out::println);
        }
        catch (Exception e){
            System.out.println("erreur de recherche de commande"+e);
        }
        try{
            comfactServiceImpl.delete(cf);
        }
        catch (Exception e){
            System.out.println("erreur d'effacement de commande "+e);
        }
        try{
            clientServiceImpl.delete(cl);
        }
        catch (Exception e){
            System.out.println("erreur d'effacement de client "+e);
        }
    }
}
