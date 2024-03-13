import java.io.*;
import java.util.*;

import javax.management.RuntimeErrorException;
public class Library {
    Scanner input = new Scanner(System.in);

    public void addBook(int bookID, String title, String aurther, String genre, boolean availablity){
        
        System.out.println("Enter the Book ID: ");
        while(true){
        try{
               bookID=input.nextInt();
               input.nextLine();
           }catch(InputMismatchException e){
               System.out.println("Please Enter The vald input");
               input.next();
               continue;
           }break;
       }
        System.out.println("Enter the Book Title: ");
        title = input.nextLine();
        System.out.println("Enter the Aurther Name: ");
        aurther = input.nextLine();
        System.out.println("Enter The Genere: ");
        genre = input.nextLine();
       availablity= true;
       try { FileWriter filestore = new FileWriter("BookBank.txt",true);
       filestore.write("BookID: "+ bookID + " Book Title: "+ title + " Auther Name: " + aurther + " Genere: " + genre + " Status: " + availablity +"\n");
       filestore.close();
     } catch (IOException e)
     {e.printStackTrace();}
    }



    public void addUser(int userID, String userName, String contact, String borrowedbooks){
        System.out.println("Enter User ID: ");
        while(true){
            try{
                userID = input.nextInt();
                input.nextLine();
            }catch(InputMismatchException e){
            System.out.println("Please Enter The vald input");
            input.next();
            continue;
        }break;
        }
        System.out.println("Enter User Name: ");
        userName= input.nextLine();
        System.out.println("Enter User Contact: ");
        contact = input.nextLine();
        System.out.println("Enter Borrwoed Books: ");
        borrowedbooks = input.nextLine();
        
            try{
                FileWriter userDetails= new FileWriter("UserBank.txt",true);
                userDetails.write("User ID: "+userID+" User Name: "+ userName +" Contact: " + contact+"Borowed Books: "+borrowedbooks+ "\n");
                userDetails.flush();
                userDetails.close();
            }catch(IOException e)
            {e.printStackTrace();}
        
    }

    void checkingOutBooks(String name) {
        try{
            FileReader myFileReader = new FileReader("BookBank.txt");
            FileWriter fj = new FileWriter("BorrowedBooks.txt", true);
            FileReader fk = new FileReader("BorrowedBooks.txt");
            Scanner sc = new Scanner(myFileReader);
            Scanner scanner = new Scanner(fk);

            ArrayList<String> Books = new ArrayList<>();
           ArrayList<String> bb = new ArrayList<>();

           if (!sc.hasNextLine()) {
               System.out.println("There are no books available in the library");
               return;
           }


           while (sc.hasNextLine()) {
               Books.add(sc.nextLine());
           }


           while (scanner.hasNextLine()) {
               bb.add(scanner.nextLine());
           }


           boolean alreadyBorrowed = false;
           for (String borrowedBook : bb) {
               if (borrowedBook.contains(name)) {
                   alreadyBorrowed = true;
                   break;
               }
           }

           for (String book : Books) {
               
               if (book.contains(name) && !alreadyBorrowed) {
                   System.out.println("The Book is Available");
                   fj.write(book + "\n");
                   System.out.println("You have successfully Borrowed this Book");
                   try { FileWriter filestore = new FileWriter("BorrowedBooks.txt",true);
       filestore.write(" Book Title: "+ name +"\n");
       filestore.close();
     } catch (IOException e)
     {e.printStackTrace();}
                   return;
               } else if (alreadyBorrowed) {
                   System.out.println("Book is Not Available");
                   return;
               }
           }


           System.out.println("The book is not available in the library");
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

    
    
    
    public void searchingBook(String inputTitle){
        
        try{
            FileReader bookbanksearch = new FileReader("BookBank.txt");
            Scanner searchBook = new Scanner(bookbanksearch);
            int value = 0;
            while(searchBook.hasNextLine()){
                if(searchBook.nextLine().contains(inputTitle)){
                    System.out.println("The Book is Available.");
                    value++;
                    break;
                }
            }
            if (value == 0){
                System.out.println("The Book is not Available.");
            }
            bookbanksearch.close();
            searchBook.close();
            
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }

    void returning(String name) {
        try {
            FileReader myFile = new FileReader("BorrowedBooks.txt");
            Scanner scanner = new Scanner(myFile);
            ArrayList<String> Books = new ArrayList<>();
            while (scanner.hasNextLine()) {
                Books.add(scanner.nextLine());
            }
            myFile.close();
    
            Iterator<String> iterator = Books.iterator();
            while (iterator.hasNext()) {
                String book = iterator.next();
                if (book.contains(name)) {
                    iterator.remove();
                    System.out.println("Book Returned Successfully");
                    break; // Assuming you want to remove only the first occurrence
                }
            }
            
            FileWriter myfile = new FileWriter("BorrowedBooks.txt");
            for (String book : Books) {
                myfile.write(book + "\n");
            }
            myfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}