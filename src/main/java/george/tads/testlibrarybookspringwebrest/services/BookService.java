package george.tads.testlibrarybookspringwebrest.services;

import george.tads.testlibrarybookspringwebrest.models.Book;
import george.tads.testlibrarybookspringwebrest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> list() {
        return this.bookRepository.findAll();
    }

    public Optional<Book> find(Long id) {
        return this.bookRepository.findById(id);
    }

    public Book insert(Book book) {
        return this.bookRepository.save(book);
    }

    public Book update(Book book) {
        return this.bookRepository.saveAndFlush(book);
    }

    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }

}
