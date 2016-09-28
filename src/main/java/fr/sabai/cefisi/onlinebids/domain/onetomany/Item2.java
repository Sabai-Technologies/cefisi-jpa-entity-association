package fr.sabai.cefisi.onlinebids.domain.onetomany;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEM")
public class Item2 {

    /*
     * Item2 gère l'association avec Bid2.
     *
     * Ecrivez les classiques tests de lecture, sauvegarde
     *      - Ajouter aussi de nouvelles BID à un Item déjà existant sans sauvegarder. Eudier les requêtes SQL générées
     *
     * Peut-on CASCADER l'ajout et la suppression sur la collection de BID2 ?
     *      - Ajouter de nouvelles BID et sauvegarder ITEM dejà existant
     *      - Supprimer des BID d'un ITEM existant en base de données
     *      - Sauvegarder un nouvel ITEM avec de nouvelles BID
     *      - Supprimer un ITEM
     *      - ajouter une BID2 appartenant à une autre instance de ITEM2
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "INITIAL_PRICE")
    private BigDecimal initialPrice;

    @Column(name = "AUCTION_END")
    private Date auctionEnd;

    @ElementCollection
    @CollectionTable(
            name = "IMAGE",
            joinColumns = @JoinColumn(name = "ITEM_ID"))
    private Set<Image2> images = new HashSet<Image2>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Set<Bid2> bids = new HashSet<Bid2>();

    public Item2() {
    }

    public Item2(String name, BigDecimal initialPrice, Date auctionEnd) {
        this.name = name;
        this.initialPrice = initialPrice;
        this.auctionEnd = auctionEnd;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public Set<Image2> getImages() {
        return images;
    }

    public void setImages(Set<Image2> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item2 item = (Item2) o;

        return id != null ? id.equals(item.id) : item.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Collection<Bid2> getBids() {
        return bids;
    }

    public void setBids(Set<Bid2> bids) {
        this.bids = bids;
    }
}
