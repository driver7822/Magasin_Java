package be.condorcet.victorlorfevreprojet1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="client", schema = "public", catalog = "d1qp571aglql87")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclient;
    private String nom;
    private String prenom;
    private Integer cp;
    private String localite;
    private String rue;
    private String num;
    private String tel;

    @OneToMany(mappedBy = "client" , fetch = FetchType.LAZY) //LAZY est la
    @ToString.Exclude
    private Collection<Comfact> comfacts;
}
