package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;

import java.util.*;

public class ClientServiceStub implements InterfClientService{


    @Override
    public Client create(Client client) throws Exception{
        client.setIdclient(1);
        return client;
    }

    @Override
    public Client read(Integer id) throws Exception {
        return new Client(1,"NomTest","PrenomTest",1000,"LocTest","Rue Test","1","0001",null);
    }

    @Override
    public Client update(Client client) throws Exception{
        return client;
    }

    @Override
    public void delete(Client client) throws Exception {
    }

    @Override
    public List<Client> read(String nom) {
        List<Client>lc = new ArrayList<>();
        lc.add(new Client(1,nom,"PrenomTest",1000,"LocTest","Rue Test","1","0001",null));
        lc.add(new Client(2,nom,"PrenomTest2",2000,"LocTest2","Rue Test2","2","0002",null));
        return lc;
    }

    @Override
    public Client read(String nom, String prenom, String tel) {

        return new Client(1,nom,prenom,1000,"LocTest","Rue Test","1",tel,null);
    }
}
