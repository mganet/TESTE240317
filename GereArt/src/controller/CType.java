package controller;

import java.util.ArrayList;
import model.MType;

public class CType {
    
    ArrayList<MType> type = new ArrayList<MType>();
    
    public void insertType(String name, String desc) {
        MType type_ = new MType(name, desc);
        type.add(type_);
    }
    
    public MType searchType(String name) {
        for(MType type_ : type) {
            if(type_.getName().equals(name)) return type_;
        }
        return null;
    }
    
    public ArrayList<MType> listType() {
        return type;
    }
    
    public void deleteType(MType type_) {
        type.remove(type_);
    }
    
}
