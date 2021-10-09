package be.condorcet.victorlorfevreprojet1;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Optional;

@SpringBootApplication
public class Victorlorfevreprojet1Application implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Victorlorfevreprojet1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        Client cl = new Client(null,"Dupuis","Robert",7800,"Ath","de la station","25","0479459874");
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
        else System.out.println("record effacé");
    }
}
