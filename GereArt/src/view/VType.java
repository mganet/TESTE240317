package view;

import controller.CType;
import java.util.Scanner;
import model.MType;

public class VType {
    
    CType type = new CType();
    
    public VType() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir tipo");
            System.out.println("2 - Procurar tipo");
            System.out.println("3 - Listar tipo");
            System.out.println("4 - Apagar tipo");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertTypeView();
                    break;
                case 2 :
                    searchTypeView();
                    break;
                case 3 :
                    listTypeView();
                    break;
                case 4 :
                    deleteTypeView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
    }
    
    void insertTypeView() {
        String name;
        String desc;
        
        System.out.println("Inserir tipo\n");
        System.out.print  ("Nome     : ");
        name    = new Scanner(System.in).nextLine();
        System.out.print  ("Descrição: ");
        desc = new Scanner(System.in).nextLine();

        
        type.insertType(name, desc);
    }
    
    void searchTypeView() {
        String name;
        
        System.out.println("Procurar tipo\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MType artist_ = type.searchType(name);
        
        if(artist_ != null) {
            System.out.println("Nome    : " + artist_.getName());
            System.out.println("Descrica: " + artist_.getDesc());
        } else {
            System.out.println("\ntipo inexistente\n");
        }
    }
    
    void listTypeView() {
        System.out.println("Listar tipo\n");
        
        for(MType artist_ : type.listType()) {
            if(artist_ != null) {
                System.out.println("Nome     : " + artist_.getName());
                System.out.println("Descricao: " + artist_.getDesc());
            } else {
                System.out.println("\nNão inexistente tipo\n");
            }
        }
    }
    
    void deleteTypeView() {
        String name;
        
        System.out.println("Apagar tipo\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        type.deleteType(type.searchType(name));
    }
    
}
