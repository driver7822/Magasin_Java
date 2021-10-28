package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;
import be.condorcet.victorlorfevreprojet1.repositories.ClientRepository;
import be.condorcet.victorlorfevreprojet1.repositories.ComfactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@Service
@Transactional(rollbackOn = Exception.class)
public class ComfactServiceImpl implements InterfComfactService{
    @Autowired
    private ComfactRepository comfactRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Comfact create(Comfact comfact) throws Exception {
        comfactRepository.save(comfact);
        return comfact;
    }
    @Override
    public Comfact read(Integer id) throws Exception {
        return comfactRepository.findById(id).get();
    }
    @Override
    public Comfact update(Comfact comfact) throws Exception {
        Integer id = comfact.getNumcommande();
        Comfact oldCom= read(id);
        oldCom.setNumfact(comfact.getNumfact());
        oldCom.setDatecom(comfact.getDatecom());
        oldCom.setEtat(comfact.getEtat());
        oldCom.setMontant(comfact.getMontant());
        comfactRepository.save(oldCom);
        return read(oldCom.getNumcommande());
    }
    @Override
    public void delete(Comfact comfact) throws Exception {
        comfactRepository.deleteById(comfact.getNumcommande());
    }
    @Override
    public List<Comfact> getComfacts(Client cl) {
        List<Comfact> lcf = comfactRepository.findComfactByClient(cl);
        return lcf;
    }
}
