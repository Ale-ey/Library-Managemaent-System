import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library l1= new Library();
        Book book1 = new Book();
        User user1= new User();
        String inputTitle;

        
        while (true) {
            System.out.println("-----------------------------------------------------");
            
            System.out.println("Wellcome to Library Management Ststem");
            System.out.println("Chose between 1 to 6\n1 Add Books\n2 Add User\n3 Borrow Book\n4 Return Book\n5 Search Book by Title");
            int userInput=0;
            while (true){
           try { 
            userInput = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input Please Enter the between 1 to 6.");
            input.next();
            continue;

        }
        break;
         }
    switch (userInput)
    {
        case 1:
        l1.addBook(book1.bookID, book1.title, book1.aurther, book1.genre, book1.availablity);
        break;
        case 2:
        l1.addUser(user1.userID, user1.userName,user1.contact, user1.borrowedbooks);
        break;
        case 3:
        System.out.println("Enter the title of the Book");
        input.nextLine();
        inputTitle=input.nextLine();
        l1.checkingOutBooks(inputTitle);
        break;
        case 4:
        System.out.println("Enter the Book Title You Want to Return");
        input.nextLine();
        inputTitle=input.nextLine();
        l1.returning(inputTitle);
        break;
        case 5:
        System.out.println("Enter the title of the Book");
        input.nextLine();
        inputTitle = input.nextLine();
        l1.searchingBook(inputTitle);
        break;

        default :
        System.out.println("Invalid Input Please Enter between 1 to 6");
    }
    System.out.println("Enter Between Y or N to If you want the Menu Again");
    char answer = input.next().charAt(0);
    if (answer == 'Y' || answer == 'y') {
        continue;
               
    }
    else  if(answer== 'N' || answer == 'n'){
        break;
    } 

       }
    }
}
