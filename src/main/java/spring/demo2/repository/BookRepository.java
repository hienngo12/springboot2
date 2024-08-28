package spring.demo2.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import spring.demo2.entity.BookEntity;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<BookEntity> bookList = new ArrayList<>();

    @PostConstruct
    public  void  init(){
        bookList.add(new BookEntity(1,"Java a-z",13.2,"roger"));
        bookList.add(new BookEntity(2,".net tutorial",23.9,"peter"));

    }
    public  List<BookEntity> findAll(){
        return  bookList;
    }

    public BookEntity save(BookEntity bookEntity){
        bookList.add(bookEntity);
        return  bookEntity;
    }

    public  BookEntity update(BookEntity newBookData) {
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book : bookList) {
            if (book.getId() == newBookData.getId()) {
                isFound = true;
                foundBook = book;
                break;
            }
        }
        if (!isFound) {
            return null;
        }
        bookList.remove(foundBook);
        newBookData.setId(foundBook.getId());
        return newBookData;
    }

    public  boolean delete(int bookID){
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book:bookList){
            if (book.getId()==bookID){
                isFound=true;
                foundBook=book;
                break;
            }
        }
        if (!isFound){
            return  false;
        }
        bookList.remove(foundBook);
        return  true;
    }

    }
