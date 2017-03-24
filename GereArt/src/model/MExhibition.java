package model;

import java.util.ArrayList;
import java.util.Date;

public class MExhibition {
    
    private String name;
    private String dateStart;
    private String dateEnd;
    private Float  price;
    private ArrayList<MPerson> visitor = new ArrayList<MPerson>();
    private ArrayList<MWork>   work    = new ArrayList<MWork>();

    public MExhibition(String name, String dateStart, String dateEnd, Float price) {
        this.name = name;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ArrayList<MPerson> getVisitor() {
        return visitor;
    }

    public void setVisitor(MPerson visitor_) {
        visitor.add(visitor_);
    }

    public ArrayList<MWork> getWork() {
        return work;
    }

    public void setWork(MWork work_) {
        work.add(work_);
    }

}
