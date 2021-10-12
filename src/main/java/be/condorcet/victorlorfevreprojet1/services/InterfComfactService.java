package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;
import be.condorcet.victorlorfevreprojet1.entities.Comfact;

import java.util.List;

public interface InterfComfactService extends InterfService<Comfact> {
    public List<Comfact> getComfacts(Client cl);
}
