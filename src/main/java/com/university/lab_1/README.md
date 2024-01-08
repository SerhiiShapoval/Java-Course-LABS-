The Book class represents a book with attributes like title, author, ISBN, and publication year. It provides constructors to initialize these attributes and getter methods to retrieve the title and ISBN. It also overrides the toString method to provide a customized string representation of the book.

The Library class represents a library that can store a collection of books. It uses an ArrayList to store the books. It provides methods to:

addBook: Add a book to the library's collection.
showAllBooks: Display all books in the library.
findBookByTitle: Find a book by its title (case-insensitive search).
removeBookByIsbn: Remove a book from the library by its ISBN.
The LibraryManagement class contains the main method and demonstrates how to use the Library class. It creates a Library object, adds some books to it, and then performs various operations such as displaying all books, finding a book by title, and removing a book by ISBN.

Here's a breakdown of what happens in the main method:

Three books are added to the library using the addBook method.
All books in the library are displayed using showAllBooks.
A book with the title "Book 2" is searched for using findBookByTitle, and the result is printed.
A book with ISBN "ISBN2" is removed from the library using removeBookByIsbn.
After the removal, all books in the library are displayed again to show the updated collection.
