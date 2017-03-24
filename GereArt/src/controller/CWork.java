package controller;

import java.util.ArrayList;
import model.MWork;
import model.MPerson;
import model.MCategory;
import model.MType;

public class CWork {
    
    ArrayList<MWork> work = new ArrayList<MWork>();
    
    public void insertWork(String name, MPerson artist, String date, MCategory category, MType type) {
        MWork work_ = new MWork(name, artist, date, category, type);
        work.add(work_);
    }
    
    public MWork searchWork(String name) {
        for(MWork work_ : work) {
            if(work_.getName().equals(name)) return work_;
        }
        return null;
    }
    
    public ArrayList<MWork> listWork() {
        return work;
    }
    
    public void deleteWork(MWork work_) {
        work.remove(work_);
    }
    
}
