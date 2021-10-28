package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.repositories.ClientRepository;
import be.condorcet.victorlorfevreprojet1.repositories.ComfactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
@Transactional(rollbackOn = Exception.class)
public class ClientServiceImpl implements InterfClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ComfactRepository comfactRepository;

    @Override
    public Client create(Client client) throws Exception {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client read(Integer id) throws Exception {
        Optional<Client> ocl = clientRepository.findById(id);
        return ocl.get();
    }

    @Override
    public Client update(Client client) throws Exception {
        Integer id = client.getIdclient();
        Client oldCl = read(id);
        oldCl.setNom(client.getNom());
        oldCl.setPrenom(client.getPrenom());
        oldCl.setCp(client.getCp());
        oldCl.setLocalite(client.getLocalite());
        oldCl.setRue(client.getRue());
        oldCl.setNum(client.getNum());
        oldCl.setTel(client.getTel());
        clientRepository.save(oldCl);
        return read(oldCl.getIdclient());
    }

    @Override
    public void delete(Client client) throws Exception {
        clientRepository.deleteById(client.getIdclient());
    }

    @Override
    public List<Client> read(String nom) {
        return clientRepository.findByNomLike(nom);
    }

    @Override
    public Client read(String nom, String prenom, String tel) {
        return clientRepository.findByNomLikeAndPrenomLikeAndTelLike(nom,prenom,tel).stream().findFirst().get();
    }
}

