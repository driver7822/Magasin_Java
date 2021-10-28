package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceImplTest {
    /*@Autowired
    private ClientServiceImpl clientServiceImpl;
    @Autowired
    private ComfactServiceImpl comfactServiceImpl;*/

    @Autowired
    private InterfComfactService comfactServiceImpl;
    @Autowired
    private InterfClientService clientServiceImpl;

    Client cl;
    @BeforeEach
    void setUp() {
        try{
            cl = new Client(null,"NomTest","PrenomTest",1000,"LocTest","rue test","1","0001",null);
                    clientServiceImpl.create(cl);
            System.out.println("création du client : "+cl);
        }
        catch (Exception e){
            System.out.println("erreur de création du client : "+cl +" erreur : "+e);
        }
    }
    @AfterEach
    void tearDown() {
        try {
            clientServiceImpl.delete(cl);
            System.out.println("effacement du client : "+cl);
        }
        catch (Exception e){
            System.out.println("erreur d'effacement du client :"+cl+" erreur : "+e);
        }
    }
    @Test
    void create() {
        assertNotEquals(0,cl.getIdclient(),"id client non incrémenté");
    }
    @Test()
    void creationDoublon(){ //ajouté
        Client cl2 = new
                Client(null,"NomTest","PrenomTest",2000,"LocTest2","rue test2","1","0001",null);
                Assertions.assertThrows(Exception.class, () -> {
                    clientServiceImpl.create(cl2);
                },"création d'un doublon");
    }
    @Test
    void read() {
        try{
            int numcli=cl.getIdclient();
            Client cl2=clientServiceImpl.read(numcli);
            assertEquals("NomTest",cl2.getNom(),"noms différents "+"NomTest"+"-"+cl2.getNom());
                    assertEquals("PrenomTest",cl2.getPrenom(),"prénoms différents "+"NomTest"+"-"+cl2.getNom());
                            //etc
        }
        catch (Exception e){
            fail("recherche infructueuse "+e);
        }
    }
    @Test
    void update() {
        try{
            cl.setNom("NomTest2");
            cl.setPrenom("PrenomTest2");
            //etc
            cl = clientServiceImpl.update(cl);
            assertEquals("NomTest2",cl.getNom(),"noms différents "+"NomTest2-"+cl.getNom());
                    assertEquals("PrenomTest2",cl.getPrenom(),"prénoms différents "+"PrenomTest2-"+cl.getPrenom());
                            //etc
        }
        catch(Exception e){
            fail("erreur de mise à jour "+e);
        }
    }
    @Test
    void delete() {
        try{
            clientServiceImpl.delete(cl);
            Assertions.assertThrows(Exception.class, () -> {
                clientServiceImpl.read(cl.getIdclient());
            },"record non effacé");
        }
        catch(Exception e){
            fail("erreur d'effacement "+e);
        }
    }
    @Test
    void delAvecCom(){ //ajouté
        try{
            Comfact cf = new Comfact(null,null, Date.valueOf(LocalDate.now()),"c",new BigDecimal(1000),cl);
            comfactServiceImpl.create(cf);
            Assertions.assertThrows(Exception.class, () -> {
                clientServiceImpl.delete(cl);
            },"effacement réalisé malgré commande liée");
            comfactServiceImpl.delete(cf);
        }catch (Exception e){
            fail("erreur de création de commande"+ e);
        }
    }
    @Test
    void rechNom() {
        List<Client> lc = clientServiceImpl.read("NomTest");
        boolean trouve=false;
        for(Client c : lc){
            if(c.getNom().equals("NomTest")) trouve=true;
            else fail("un record ne correspond pas , nom = "+c.getNom());
        }
        assertTrue(trouve,"record non trouvé dans la liste");
    }
}
