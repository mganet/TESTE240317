package controller;

import java.util.ArrayList;
import model.MPerson;

public class CArtist {
    
    ArrayList<MPerson> artist = new ArrayList<MPerson>();
    
    public void insertArtist(String name, String address, String phone) {
        MPerson artist_ = new MPerson(name, address, phone);
        artist.add(artist_);
    }
    
    public MPerson searchArtist(String name) {
        for(MPerson artist_ : artist) {
            if(artist_.getName().equals(name)) return artist_;
        }
        return null;
    }
    
    public ArrayList<MPerson> listArtist() {
        return artist;
    }
    
    public void deleteArtist(MPerson artist_) {
        artist.remove(artist_);
    }
    
}
