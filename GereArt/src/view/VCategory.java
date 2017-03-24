package view;

import controller.CCategory;
import java.util.Scanner;
import model.MCategory;

public class VCategory {
    
    CCategory category = new CCategory();
    
    public VCategory() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir categoria");
            System.out.println("2 - Procurar categoria");
            System.out.println("3 - Listar categoria");
            System.out.println("4 - Apagar categoria");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertCategoryView();
                    break;
                case 2 :
                    searchCategoryView();
                    break;
                case 3 :
                    listCategoryView();
                    break;
                case 4 :
                    deleteCategoryView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
    }
    
    void insertCategoryView() {
        String name;
        String desc;
        
        System.out.println("Inserir categoria\n");
        System.out.print  ("Nome     : ");
        name    = new Scanner(System.in).nextLine();
        System.out.print  ("Descricao: ");
        desc = new Scanner(System.in).nextLine();

        
        category.insertCategory(name, desc);
    }
    
    void searchCategoryView() {
        String name;
        
        System.out.println("Procurar categoria\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MCategory artist_ = category.searchCategory(name);
        
        if(artist_ != null) {
            System.out.println("Nome     : " + artist_.getName());
            System.out.println("Descricao: " + artist_.getDesc());
        } else {
            System.out.println("\ncategoria inexistente\n");
        }
    }
    
    void listCategoryView() {
        System.out.println("Listar categoria\n");
        
        for(MCategory artist_ : category.listCategory()) {
            if(artist_ != null) {
                System.out.println("Nome     : " + artist_.getName());
                System.out.println("Descricao: " + artist_.getDesc());
            } else {
                System.out.println("\nNão inexistente categoria\n");
            }
        }
    }
    
    void deleteCategoryView() {
        String name;
        
        System.out.println("Apagar categoria\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        category.deleteCategory(category.searchCategory(name));
    }
    
}
