package be.condorcet.victorlorfevreprojet1.services;

import be.condorcet.victorlorfevreprojet1.entities.Client;

import java.util.List;

public interface InterfClientService extends InterfService<Client> {
    public List<Client> read(String nom);
}

