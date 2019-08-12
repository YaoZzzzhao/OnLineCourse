package com.ascending.training.model;

import javax.persistence.*;

@Entity
@Table(name = "dogs")

public class Dog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "owner_id")
    private long owner_id;

    @Column(name = "dog_name")
    private String dog_name;

    @Column(name = "spay_neuter")
    private String spay_neuter;

    @Column(name = "rabies")
    private String rabies;

    @Column(name = "distemper")
    private String distemper;

    @Column(name = "parvo")
    private String parvo;

    @Column(name= "adenovirus")
    private String adenovirus;

    @Column(name = "bordetella")
    private String bordetella;




    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Pet pet;

    public Pet getPet(){return pet;}
    public void setPet(Pet p){
        this.pet = p;
    }




    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return owner_id;
    }

    public String getName() {
        return dog_name;
    }

    public String getSpayNeuter() {
        return spay_neuter;
    }

    public String getRabies() {
        return rabies;
    }

    public String getDistemper() {
        return distemper;
    }

    public String getParvo() {
        return parvo;
    }

    public String getAdenovirus() {
        return adenovirus;
    }

    public String getBordetella() {
        return bordetella;
    }




    public void setId(long i) {
        this.id = i;
    }

    public void setOwnerId(long i) {
        this.owner_id = i;
    }

    public void setName(String i) {
        this.dog_name = i;
    }

    public void setSpayNeuter(String i) {
        this.spay_neuter = i;
    }

    public void setRabies(String i) {
        this.rabies = i;
    }

    public void setDistemper(String i) {
        this.distemper = i;
    }

    public void setParvo(String i) {
        this.parvo = i;
    }

    public void setAdenovirus(String i) {
        this.adenovirus = i;
    }

    public void setBordetella(String i) {
        this.bordetella = i;
    }

//    public int getDog_id() {
//        return dog_id;
//    }

//    public void setDog_id(int dog_id) {
//        this.dog_id = dog_id;
//    }
}
