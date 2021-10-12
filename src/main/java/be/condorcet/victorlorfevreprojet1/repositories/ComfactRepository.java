package be.condorcet.victorlorfevreprojet1.repositories;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ComfactRepository extends JpaRepository<Comfact,Integer>
{
    public List<Comfact> findComfactByClient(Client cl);
}

