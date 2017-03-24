package view;

import model.MExhibition;
import model.MWork;
import model.MPerson;
import controller.CExhibition;
import controller.CWork;
import controller.CClient;
import java.util.Scanner;

public class VExhibition {

    CExhibition exhibition = new CExhibition();
    CClient client = new CClient();
    CWork work = new CWork();
    
    public VExhibition() {
    
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir exposicao");
            System.out.println("2 - Procurar exposicao");
            System.out.println("3 - Listar exposicao");
            System.out.println("4 - Apagar exposicao");
            System.out.println("5 - Inserir visitante");
            System.out.println("6 - Inserir quadro");
            System.out.println("7 - Procurar exposição que lucrou mais");
            System.out.println("8 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertExhibitionView();
                    break;
                case 2 :
                    searchExhibitionView();
                    break;
                case 3 :
                    listExhibitionView();
                    break;
                case 4 :
                    deleteExhibitionView();
                    break;
                case 5 :
                    insertVisitorView();
                    break;
                case 6 :
                    insertWorkView();
                    break;
                case 7 :
                    searchHigesht();
                    break;
                case 8 :
                    break;
                default:
                    break;
            }
        } while(opc != 8);
    
    }
    
    void insertExhibitionView() {
        String name;
        String dateStart;
        String dateEnd;
        Float price;
        
        System.out.println("\nInserir exposição\n");
        System.out.print  ("Nome       : ");
        name = new Scanner(System.in).nextLine();
        System.out.print  ("Hora começo: ");
        dateStart = new Scanner(System.in).nextLine();
        System.out.print  ("Hora fim   : ");
        dateEnd = new Scanner(System.in).nextLine();
        System.out.print  ("Preço      : ");
        price = new Scanner(System.in).nextFloat();
        
        exhibition.insertExhibition(name, dateStart, dateEnd, price);
    }
    
    void searchExhibitionView() {
        String name;
        
        System.out.println("\nProcurar exposição\n");
        System.out.print  ("Nome       : ");
        name = new Scanner(System.in).nextLine();
        
        MExhibition exhibition_ = exhibition.searchExhibition(name);
        
        if(exhibition_ != null) {
            System.out.println("Nome  : " + exhibition_.getName());
            System.out.println("Começo: " + exhibition_.getDateStart());
            System.out.println("Fim   : " + exhibition_.getDateEnd());
            System.out.println("Preço : " + exhibition_.getPrice());
            System.out.println("Ganho : " + exhibition.totalMoney(exhibition_));
            System.out.println("\tVisitantes(" + exhibition_.getVisitor().size() +"):");
            for(MPerson visitor_ : exhibition_.getVisitor()) {
                System.out.println("\t- " + visitor_.getName());
            }
            System.out.println("\tObras:");
            for(MWork work_ : exhibition_.getWork()) {
                System.out.println("\t- " + work_.getName());
            }
        } else {
            System.out.println("\nExposição inexistente\n");
        }
        
    }
    
    void listExhibitionView() {
        System.out.println("Listar exposição\n");
        for(MExhibition exhibition_ : exhibition.listExhibition()) {
            System.out.println("Nome  : " + exhibition_.getName());
            System.out.println("Começo: " + exhibition_.getDateStart());
            System.out.println("Fim   : " + exhibition_.getDateEnd());
            System.out.println("Preço : " + exhibition_.getPrice());
            System.out.println("Ganho : " + exhibition.totalMoney(exhibition_));
            System.out.println("\tVisitantes(" + exhibition_.getVisitor().size() +"):");
            for(MPerson visitor_ : exhibition_.getVisitor()) {
                System.out.println("\t- " + visitor_.getName());
            }
            System.out.println("\tObras:");
            for(MWork work_ : exhibition_.getWork()) {
                System.out.println("\t- " + work_.getName());
            }
        }
    }
    
    void deleteExhibitionView() {
        String name;
        
        System.out.println("Apagar Cliente\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        exhibition.deleteExhibition(exhibition.searchExhibition(name));
    }
    
    void insertVisitorView() {
        String name;
        String name_;
        
        System.out.println("Inserir visitante na exposição\n");
        System.out.print("Nome da exposição: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Nome do visitante: ");
        name_ = new Scanner(System.in).nextLine();
        
        exhibition.inserClient(exhibition.searchExhibition(name), client.searchClient(name_));
    }
    
    void insertWorkView() {
        String name;
        String name_;
        
        System.out.println("Inserir obra na exposição\n");
        System.out.print("Nome da exposição: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Nome da obra: ");
        name_ = new Scanner(System.in).nextLine();
        
        exhibition.insertWork(exhibition.searchExhibition(name), work.searchWork(name_));
    }
    
    void searchHigesht() {
        MExhibition exhibition_ = exhibition.earnMore();
        
        if(exhibition_ != null) {
            System.out.println("Nome  : " + exhibition_.getName());
            System.out.println("Começo: " + exhibition_.getDateStart());
            System.out.println("Fim   : " + exhibition_.getDateEnd());
            System.out.println("Preço : " + exhibition_.getPrice());
            System.out.println("Ganho : " + exhibition.totalMoney(exhibition_));
            System.out.println("\tVisitantes(" + exhibition_.getVisitor().size() +"):");
            for(MPerson visitor_ : exhibition_.getVisitor()) {
                System.out.println("\t- " + visitor_.getName());
            }
            System.out.println("\tObras:");
            for(MWork work_ : exhibition_.getWork()) {
                System.out.println("\t- " + work_.getName());
            }
        } else {
            System.out.println("\nExposição inexistente\n");
        }
    }
    
}
