package be.condorcet.victorlorfevreprojet1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "comfact", schema = "public", catalog = "d1qp571aglql87")
public class Comfact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numcommande;
    private Integer numfact;
    private Date datecom;
    private String etat;
    private BigDecimal montant;
    @ManyToOne @JoinColumn(name = "fkclient")
    private Client client;
}

