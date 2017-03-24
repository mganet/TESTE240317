package controller;

import java.util.ArrayList;
import model.MPerson;

public class CClient {
    
    ArrayList<MPerson> client = new ArrayList<MPerson>();
    
    public void insertClient(String name, String address, String phone) {
        MPerson client_ = new MPerson(name, address, phone);
        client.add(client_);
    }
    
    public MPerson searchClient(String name) {
        for(MPerson client_ : client) {
            if(client_.getName().equals(name)) return client_;
        }
        return null;
    }
    
    public ArrayList<MPerson> listClient() {
        return client;
    }
    
    public void deleteClient(MPerson client_) {
        client.remove(client_);
    }
    
}
