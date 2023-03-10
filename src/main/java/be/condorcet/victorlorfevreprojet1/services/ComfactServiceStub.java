package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ComfactServiceStub implements InterfComfactService{

    @Override
    public Comfact create(Comfact comfact) throws Exception {
        comfact.setNumcommande(1);
        return comfact;
    }

    @Override
    public Comfact read(Integer id) throws Exception {
        return new Comfact(id,null,Date.valueOf(LocalDate.now()),"c",new BigDecimal("1000.00"),new Client(1,"NomTest","PrenomTest",1000,"LocTest","Rue Test","1","0001",null));
    }

    @Override
    public Comfact update(Comfact comfact) throws Exception {
        return comfact;
    }

    @Override
    public void delete(Comfact comfact) throws Exception {
    }

    @Override
    public List<Comfact> getComfacts(Client cl) {
        List<Comfact> lcf = new ArrayList<>();
        lcf.add(new Comfact(1,null,Date.valueOf(LocalDate.now()),"c",new BigDecimal("1000.00"),new Client(1,"NomTest","PrenomTest",1000,"LocTest","Rue Test","1","0001",null)));
        lcf.add(new Comfact(2,null,Date.valueOf(LocalDate.now()),"c",new BigDecimal("2000.00"),new Client(1,"NomTest","PrenomTest",1000,"LocTest","Rue Test","1","0001",null)));
        return lcf;
    }
}
