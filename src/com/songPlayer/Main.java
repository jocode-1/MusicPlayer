package com.songPlayer;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main (String[] args) {

        Album album =new Album("Album1","AC/DC");

        album.addSong("God is power", 3.5);
        album.addSong("Halleuya", 6.2);
        album.addSong("power", 2.0);
        albums.add(album);

        album =new Album("Album2","AD");

        album.addSong("Rap God", 3.2);
        album.addSong("Not afraid", 4.2);
        album.addSong("loose yourself", 8.0);
        albums.add(album);

        LinkedList<Song> playlist_1 = new LinkedList<>();
        albums.get(0).addToPlayList("God is power",playlist_1);
        albums.get(0).addToPlayList("Halleuya",playlist_1);
        albums.get(1).addToPlayList("Rap God",playlist_1);
        albums.get(1).addToPlayList("loose yourself",playlist_1);

        play(playlist_1);

    }

    private  static void play (LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing" + listIterator.next().toString());
        }
        printMenu();

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case  1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now Playing "+ listIterator.next().toString());
                    } else {
                        System.out.println("No song available reached the end of the list");
                        forward =false;
                    }
                    break;
                case  2:
                    if (forward) {
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward =false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing "+ listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    }
                        else {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing "+ listIterator.next().toString());
                                forward = false;
                            } else {
                                System.out.println("We are at the start of the list");
                        }
                            break;

                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case  6:
                    if (playlist.size() >0) {
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " +listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " +listIterator.previous().toString());
                            }
                        }
                    }
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available Option \n press");
        System.out.println("0 - to quit\n"+
                "1 - to play song\n"+
                "2 - to play previous song\n"+
                "3 - to play current song\n"+
                "4 - list of all song\n"+
                "5 - print all available option\n"+
                "6 - delete current song\n");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println(".......................");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(".......................");
    }

}
