package com.example.assignmentfirebase;

public class Book {
    private String nameBook;
    private String authorName;
    private String descriptionBook;
    private float numberOfPages;
    private float yearOfPublishing;
// this is class book
      public Book(){

      }
    public Book(String nameBook, String authorName, String descriptionBook, float numberOfPages, float yearOfPublishing) {
        this.nameBook = nameBook;
        this.authorName = authorName;
        this.descriptionBook = descriptionBook;
        this.numberOfPages = numberOfPages;
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescriptionBook() {
        return descriptionBook;
    }

    public void setDescriptionBook(String descriptionBook) {
        this.descriptionBook = descriptionBook;
    }

    public float getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(float numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(float yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;



     }
}
