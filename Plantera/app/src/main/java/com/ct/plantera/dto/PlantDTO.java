package com.ct.plantera.dto;

/**
 * Created by charlest on 11/27/17.
 */

public class PlantDTO {

    private int guid;

    private String genus;

    private String species;

    private String cultivar;
    
    private String common;

    private String type;

    public PlantDTO() {
    }

    public PlantDTO(int guid, String genus, String species, String cultivar, String common) {
        this.guid = guid;
        this.genus = genus;
        this.species = species;
        this.cultivar = cultivar;
        this.common = common;
    }

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCultivar() {
        return cultivar;
    }

    public void setCultivar(String cultivar) {
        this.cultivar = cultivar;
    }

    public String getCommon() {
        return common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    @Override
    public String toString() {

        return genus + " " + species + " " + cultivar + " " + common;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
