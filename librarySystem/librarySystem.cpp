// cpp code for a library management system

#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wformat"
using namespace std;


typedef struct {
    string name;
    string author;
    bool available;
    int id;
} Book;


class librarySystem
{
private:
    vector<Book> books;
public:
    librarySystem(/* args */);
    ~librarySystem();
    void addBook(const string &title, const string &author);
    void print_book(int id);

    int total_books;

};

librarySystem::librarySystem(/* args */)
{
    total_books = 0;
}

librarySystem::~librarySystem()
{
}

void librarySystem::addBook(const string &title, const string &author) {
    Book newBook;
    newBook.name = title;
    newBook.author = author;
    newBook.id = ++total_books;
    newBook.available = false;
    printf("addBook #%i successful\n", newBook.id);
    books.push_back(newBook);
}

void librarySystem::print_book(int id) {
    int idx = id-1;
    printf("\n*******************************\n");
    printf("*********** BOOK #%i **********\n", id);
    printf("\nTitle : %s", &books[idx].name);
    printf("\nAuthor: %s", &books[idx].author);
    printf("\nAvailability: %s ", &books[idx].available ? "YES" : "NO");
//    printf("\nAvailability: %c ", &books[idx].available);
    printf("\n*******************************\n\n");
}


int main() {

    system("clear");
    librarySystem lib;
    lib.addBook("ShitSniffer", "Bula");
    lib.print_book(1);

    return 0;
}
#pragma clang diagnostic pop