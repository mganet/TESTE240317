package model;

import java.util.Date;

public class MWork {
    
    private String    name;
    private MPerson   artist;
    private String    date;
    private MCategory category;
    private MType     type;

    public MWork(String name, MPerson artist, String date, MCategory category, MType type) {
        this.name = name;
        this.artist = artist;
        this.date = date;
        this.category = category;
        this.type = type;
    }

    public MType getType() {
        return type;
    }

    public void setType(MType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MPerson getArtist() {
        return artist;
    }

    public void setArtist(MPerson artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MCategory getCategory() {
        return category;
    }

    public void setCategory(MCategory category) {
        this.category = category;
    }
  
}
