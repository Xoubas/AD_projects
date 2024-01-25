package org.example;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BookDAO bookDAO= new BookDAO();

        Book b1= new Book("1234567890123","El Quijote","Cervantes",1605,true,null);
        Book b2= new Book("9780141439839","Pride and Prejudice","Jane Austen",1813,true,null);
        Book b3= new Book("9780061120084","To Kill a Mockingbird","Harper Lee",1960,true,null);
        Book b4= new Book("9780743273565","The Great Gatsby","F. Scott Fitzgerald",1925,true,null);
        Book b5= new Book("9780060935467","The Catcher in the Rye","J.D. Salinger",1951,true,null);
        Book b6= new Book("9780544003415","The Hobbit","J.R.R. Tolkien",1937,true,null);
        Book b7= new Book("9780141182605","1984","George Orwell",1949,true,null);
        Book b8= new Book("9780060256654","Where the Wild Things Are","Maurice Sendak",1963,true,null);
        Book b9= new Book("9780142000670","The Little Prince","Antoine de Saint-Exupéry",1943,true,null);
        Book b10= new Book("9780064404990","Charlotte's Web","E.B. White",1952,true,null);


                bookDAO.insertBook(b1);
                bookDAO.insertBook(b2);
                bookDAO.insertBook(b3);
                bookDAO.insertBook(b4);
                bookDAO.insertBook(b5);
                bookDAO.insertBook(b6);
                bookDAO.insertBook(b7);
                bookDAO.insertBook(b8);
                bookDAO.insertBook(b9);
                bookDAO.insertBook(b10);

    }
}