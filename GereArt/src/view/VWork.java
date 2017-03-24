package view;

import controller.CType;
import controller.CCategory;
import controller.CArtist;
import controller.CWork;
import java.util.Date;
import model.MWork;
import model.MType;
import model.MCategory;
import model.MPerson;
import java.util.Scanner;

public class VWork {
    
    CWork work          = new CWork();
    CArtist artist      = new CArtist();
    CCategory category  = new CCategory();
    CType type          = new CType();
    
    public VWork() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir obra");
            System.out.println("2 - Procurar obra");
            System.out.println("3 - Listar obra");
            System.out.println("4 - Apagar obra");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertWorkView();
                    break;
                case 2 :
                    searchWorkView();
                    break;
                case 3 :
                    listWorkView();
                    break;
                case 4 :
                    deleteWorkView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
    }
    
    void insertWorkView() {
        String name;
        String date;
        
        System.out.println("Inserir obra\n");
        System.out.print("Nome obra: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("Nome artista: ");
        MPerson artist_ = artist.searchArtist(new Scanner(System.in).nextLine());
        System.out.print("Nome categoria: ");
        MCategory category_ = category.searchCategory(new Scanner(System.in).nextLine());
        System.out.print("Nome tipo: ");
        MType type_ = type.searchType(new Scanner(System.in).nextLine());
        System.out.print("Data: ");
        date = new Scanner(System.in).nextLine();
        
        work.insertWork(name, artist_, date, category_, type_);
        
    }
    
    void searchWorkView() {
        String name;
        
        System.out.println("Procurar obra\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MWork work_ = work.searchWork(name);
        
        if(work_ != null) {
            System.out.println("Nome     : " + work_.getName());
            System.out.println("Artista  : " + work_.getArtist());
            System.out.println("Data     : " + work_.getDate());
            System.out.println("Categoria: " + work_.getCategory());
            System.out.println("Tipo     : " + work_.getType());
        } else {
            System.out.println("\nObra inexistente\n");
        }
    }
    
    void listWorkView() {
        System.out.println("Listar obra\n");
        
        for(MWork work_ : work.listWork()) {
            if(work_ != null) {
                System.out.println("Nome     : " + work_.getName());
                System.out.println("Artista  : " + work_.getArtist());
                System.out.println("Data     : " + work_.getDate());
                System.out.println("Categoria: " + work_.getCategory());
                System.out.println("Tipo     : " + work_.getType());
            } else {
                System.out.println("\nNão inexistente obra\n");
            }
        }
    }
    
    void deleteWorkView() {
        String name;
        
        System.out.println("Apagar Cliente\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        work.deleteWork(work.searchWork(name));
    }
    
}
