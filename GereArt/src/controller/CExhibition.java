package controller;

import java.util.ArrayList;
import model.MExhibition;
import model.MWork;
import model.MPerson;

public class CExhibition {
    
    ArrayList<MExhibition> exhibition = new ArrayList<MExhibition>();
    
    public void insertExhibition(String name, String dateStart, String dateEnd, Float price) {
        MExhibition exhibition_ = new MExhibition(name, dateStart, dateEnd, price);
        exhibition.add(exhibition_);
    }
    
    public MExhibition searchExhibition(String name) {
        for(MExhibition exhibition_ : exhibition) {
            if(exhibition_.getName().equals(name)) return exhibition_;
        }
        return null;
    }
    
    public ArrayList<MExhibition> listExhibition() {
        return exhibition;
    }
    
    public void deleteExhibition(MExhibition exhibition_) {
        exhibition.remove(exhibition_);
    }
    
    public void insertWork(MExhibition exhibition_,MWork work) {
        exhibition.get(exhibition.indexOf(exhibition_)).setWork(work);
    }
    
    public void inserClient(MExhibition exhibition_,MPerson person) {
        exhibition.get(exhibition.indexOf(exhibition_)).setVisitor(person);
    }
    
    public int totalMoney(MExhibition exhibition_) {
        int total;
        
        total = (int) ((float)(exhibition_.getVisitor().size()) * exhibition_.getPrice());
        
        return total;
    }
    
    public MExhibition earnMore() {
        int highestMoney = 0;
        MExhibition ex = null;
        for(MExhibition exhibition_ : exhibition) {
            if(totalMoney(exhibition_) > highestMoney) {
                highestMoney = totalMoney(exhibition_);
                ex = exhibition_;
            }
        }
        return ex;
    }
    
}