import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Student ID: 251-35-533");
        System.out.println("Student Name: MD. Mafujur Rahman");

        Library lib = new Library();
        lib.loadData();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n========== Library Management System ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Display Books");
            System.out.println("4. Search Book");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Title: ");
                String title = sc.nextLine();

                System.out.print("Author: ");
                String author = sc.nextLine();

                System.out.print("Category: ");
                String category = sc.nextLine();

                lib.addBook(
                        new Book(id, title, author, category)
                );

            } else if (choice == 2) {

                System.out.print("Member ID: ");
                int id = sc.nextInt();

                System.out.println("1. Student");
                System.out.println("2. Faculty");
                System.out.print("Type: ");
                int type = sc.nextInt();

                if (type == 1)
                    lib.registerMember(
                            new StudentMember(id, "mafuj")
                    );
                else
                    lib.registerMember(
                            new FacultyMember(
                                    id, "Ms. Afrin Jahan Eva"
                            )
                    );

            } else if (choice == 3) {

                lib.displayBooks();

            } else if (choice == 4) {

                System.out.print("Book Title: ");
                lib.searchBook(sc.nextLine());

            } else if (choice == 5) {

                System.out.print("Book ID: ");
                lib.borrowBook(sc.nextInt());

            } else if (choice == 6) {

                System.out.print("Book ID: ");
                lib.returnBook(sc.nextInt());

            } else if (choice == 7) {

                lib.saveData();

            } else if (choice == 8) {

                lib.saveData();
                System.out.println("Program ended.");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}