package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ClientServiceMock implements InterfClientService {
    private List<Client> lc= new ArrayList<>() ;
    private int numact=0;

    @Override
    public Client create(Client cl) throws Exception {
        for(Client cl2 : lc){
            if(cl2.getNom().equals(cl.getNom())&& (cl2.getPrenom().equals(cl.getPrenom()) && cl2.getTel().equals(cl.getTel()))) throw new Exception("doublon"); }
        numact++;
        cl.setIdclient(numact);
        lc.add(cl);
        return cl;
    }

    @Override
    public Client read(Integer id) throws Exception {
        for(Client cl : lc){
            if(cl.getIdclient().equals(id)) return cl;
        }
        throw new Exception("code inconnu");
    }

    @Override
    public Client update(Client client) throws Exception {
        Integer id = client.getIdclient();
        Client oldCl= read(id);
        oldCl.setNom(client.getNom());
        oldCl.setPrenom(client.getPrenom());
        oldCl.setCp(client.getCp());
        oldCl.setLocalite(client.getLocalite());
        oldCl.setRue(client.getRue());
        oldCl.setNum(client.getNum());
        oldCl.setTel(client.getTel());
        return read(oldCl.getIdclient());
    }

    @Override
    public Client read(String nom,String prenom, String tel)  {
        for(Client cl : lc){
            if(cl.getNom().equals(nom) && cl.getPrenom().equals(prenom) && cl.getTel().equals(tel)) return cl;
        }
        return null;
    }

    @Override
    public List<Client> read(String nom)  {
        List<Client> lcnom = new ArrayList<>();
        lc.stream().filter(cl->cl.getNom().equals(nom)).forEach(cl->lcnom.add(cl));
        return lcnom;
    }

    @Override
    public void delete(Client cldel) throws Exception {
        Iterator<Client> itc= lc.iterator();
        while(itc.hasNext()) {
            Client cl = itc.next();
            if(cl.getIdclient().equals(cldel.getIdclient())) {
                if(cl.getComfacts() ==null || cl.getComfacts().isEmpty()) itc.remove();
                else   throw new Exception("liste de commandes non vide");

            }
        }
    }
}
