package controller;

import java.util.ArrayList;
import model.MCategory;

public class CCategory {
    
    ArrayList<MCategory> category = new ArrayList<MCategory>();
    
    public void insertCategory(String name, String desc) {
        MCategory category_ = new MCategory(name, desc);
        category.add(category_);
    }
    
    public MCategory searchCategory(String name) {
        for(MCategory category_ : category) {
            if(category_.getName().equals(name)) return category_;
        }
        return null;
    }
    
    public ArrayList<MCategory> listCategory() {
        return category;
    }
    
    public void deleteCategory(MCategory category_) {
        category.remove(category_);
    }
    
}
