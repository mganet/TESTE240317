package view;

import controller.CClient;
import java.util.Scanner;
import model.MPerson;

public class VClient {
     CClient artist = new CClient();
    
    public VClient() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir Cliente");
            System.out.println("2 - Procurar Cliente");
            System.out.println("3 - Listar Cliente");
            System.out.println("4 - Apagar Cliente");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertClientView();
                    break;
                case 2 :
                    searchClienttView();
                    break;
                case 3 :
                    listClientView();
                    break;
                case 4 :
                    deleteClientView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
    }
    
    void insertClientView() {
        String name;
        String address;
        String phone;
        
        System.out.println("Inserir Cliente\n");
        System.out.print  ("Nome     : ");
        name    = new Scanner(System.in).nextLine();
        System.out.print  ("Morada   : ");
        address = new Scanner(System.in).nextLine();
        System.out.print  ("Telemovel: ");
        phone   = new Scanner(System.in).nextLine();
        
        artist.insertClient(name, address, phone);
    }
    
    void searchClienttView() {
        String name;
        
        System.out.println("Procurar Cliente\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MPerson artist_ = artist.searchClient(name);
        
        if(artist_ != null) {
            System.out.println("Nome     : " + artist_.getName());
            System.out.println("Morada   : " + artist_.getAddress());
            System.out.println("Telemovel: " + artist_.getPhone());
        } else {
            System.out.println("\nCliente inexistente\n");
        }
    }
    
    void listClientView() {
        System.out.println("Listar Cliente\n");
        
        for(MPerson artist_ : artist.listClient()) {
            if(artist_ != null) {
                System.out.println("Nome     : " + artist_.getName());
                System.out.println("Morada   : " + artist_.getAddress());
                System.out.println("Telemovel: " + artist_.getPhone());
            } else {
                System.out.println("\nNão inexistente Cliente\n");
            }
        }
    }
    
    void deleteClientView() {
        String name;
        
        System.out.println("Apagar Cliente\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        artist.deleteClient(artist.searchClient(name));
    }
}
