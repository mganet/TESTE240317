package view;

import controller.CArtist;
import java.util.Scanner;
import model.MPerson;

public class VArtist {
    
    CArtist artist = new CArtist();
    
    public VArtist() {
        int opc = 0;
        
        do {
            System.out.println("1 - Inserir Artista");
            System.out.println("2 - Procurar Artista");
            System.out.println("3 - Listar Artista");
            System.out.println("4 - Apagar Artista");
            System.out.println("5 - Sair");
            System.out.print  ("\nEscolha: ");
            
            switch(opc = new Scanner(System.in).nextInt()) {
                case 1 :
                    insertArtistView();
                    break;
                case 2 :
                    searchArtistView();
                    break;
                case 3 :
                    listArtistView();
                    break;
                case 4 :
                    deleteArtistView();
                    break;
                case 5 :
                    break;
                default:
                    break;
            }
        } while(opc != 5);
    }
    
    void insertArtistView() {
        String name;
        String address;
        String phone;
        
        System.out.println("Inserir artista\n");
        System.out.print  ("Nome     : ");
        name    = new Scanner(System.in).nextLine();
        System.out.print  ("Morada   : ");
        address = new Scanner(System.in).nextLine();
        System.out.print  ("Telemovel: ");
        phone   = new Scanner(System.in).nextLine();
        
        artist.insertArtist(name, address, phone);
    }
    
    void searchArtistView() {
        String name;
        
        System.out.println("Procurar Artista\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        MPerson artist_ = artist.searchArtist(name);
        
        if(artist_ != null) {
            System.out.println("Nome     : " + artist_.getName());
            System.out.println("Morada   : " + artist_.getAddress());
            System.out.println("Telemovel: " + artist_.getPhone());
        } else {
            System.out.println("\nArtista inexistente\n");
        }
    }
    
    void listArtistView() {
        System.out.println("Listar Artistas\n");
        
        for(MPerson artist_ : artist.listArtist()) {
            if(artist_ != null) {
                System.out.println("Nome     : " + artist_.getName());
                System.out.println("Morada   : " + artist_.getAddress());
                System.out.println("Telemovel: " + artist_.getPhone());
            } else {
                System.out.println("\nNão inexistente artistas\n");
            }
        }
    }
    
    void deleteArtistView() {
        String name;
        
        System.out.println("Apagar Artista\n");
        System.out.print("Nome: ");
        name = new Scanner(System.in).nextLine();
        
        artist.deleteArtist(artist.searchArtist(name));
    }
    
}
