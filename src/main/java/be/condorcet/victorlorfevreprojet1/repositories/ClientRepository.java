package be.condorcet.victorlorfevreprojet1.repositories;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    public List<Client> findByNomLike(String nom);
    public List<Client> findByLocaliteLike (String loc);
    public List<Client> findByNomLikeAndPrenomLikeAndTelLike(String nom, String prenom, String tel);
}
