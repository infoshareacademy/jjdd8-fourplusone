package com.infoshareacademy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class NewMenu {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    UserInput getNumber = new UserInput();
    BookPrinter bookPrinter = new BookPrinter();


    public void newMenu(int position) {


        List<MenuOptions> newMenuList = new ArrayList<>();
        newMenuList.add(new MenuOptions("glowne menu", 1, 0));
        newMenuList.add(new MenuOptions("Przeglądaj zbiór książek", 2, 1));
        newMenuList.add(new MenuOptions("zwróć książke", 2, 1));
        newMenuList.add(new MenuOptions("dostępne książki", 4, 1));
        newMenuList.add(new MenuOptions("Ulubione", 5, 1));
        newMenuList.add(new MenuOptions("Pokaż Wszystkie pozycje", 41, 4));
        newMenuList.add(new MenuOptions("wyświetl jedną pozycje", 42, 4));
        newMenuList.add(new MenuOptions("sortuj po tytule", 43, 4));
        newMenuList.add(new MenuOptions("", 45, 3));
        newMenuList.add(new MenuOptions("", 46, 44));


        while (position != 0) {
            stdout.info("\033[H\033[2J");
            stdout.info("\n");
            Header.headerPrinter();
            // adding functionality on positions here
            if (position == 1) {

                stdout.info("Witamy na Glownej stronie biblioteki For Plus One");


            } else if (position == 41) {
                new BookPrinter().printBooks(BookRepository.getBooks());
            } else if (position == 42) {
                int n = new BookPrinter().chooseBookToPrint();
                stdout.info(n + 1 + ". " + BookRepository.getBooks().get(n));
                stdout.info("\n Nacisnij dowolny klawisz aby kontynuawać\n");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if (choice != null)
                    continue;
            } else if (position == 43) {
                bookPrinter.chooseBookToPrint();
                new SearchBook().searchFromAuthor();
            }

            int parent = 0;
            for (MenuOptions menuOptions : newMenuList) {
                if (menuOptions.getPosition() == position) {
                    parent = menuOptions.getParent();
                }

            }
            stdout.info("wybie");
            int[] choicesNumber = new int[10];
            int pressNumber = 1;
            for (MenuOptions menuOptions : newMenuList) {

                if (menuOptions.getParent() == position) {

                    stdout.info("\n" + pressNumber + "<-  " + menuOptions.getDisplayedText());

                    choicesNumber[pressNumber] = menuOptions.getPosition();
                    pressNumber++;
                }

            }
            stdout.info("\n0<-  wróć do poprzedniego menu  ");
            stdout.info("\n wybież numer opcji którą chcesz wybrać: ");
            int userChoice = getNumber.getChoice(pressNumber - 1);
            stdout.info("\nwybrales " + userChoice);
            if (userChoice != 0) {
                position = choicesNumber[userChoice];

            } else {
                position = parent;

            }


        }

    }

}
