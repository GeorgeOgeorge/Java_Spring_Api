package george.tads.testlibrarybookspringwebrest.controllers;

import george.tads.testlibrarybookspringwebrest.dto.request.BookRequestDto;
import george.tads.testlibrarybookspringwebrest.dto.response.BookResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Book;
import george.tads.testlibrarybookspringwebrest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping(value = "/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> list() {
        return this.bookService.list();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BookResponseDto> find(@PathVariable Long id) {
        Optional<Book> newBook = this.bookService.find(id);
        if(newBook.isPresent())
            return ResponseEntity.ok().body(new BookResponseDto(newBook.get()));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> insert(@RequestBody BookRequestDto bookDto) {
        Book newBook = this.bookService.insert(bookDto.build());
        return ResponseEntity.created(URI.create("books/" + newBook.getId())).body(new BookResponseDto(newBook));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> newBook = this.bookService.find(id);
        if(newBook.isPresent() && newBook.get().getId().equals(book.getId()))
            return ResponseEntity.ok(new BookResponseDto(this.bookService.update(book)));
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if(this.bookService.find(id).isPresent()) {
            this.bookService.delete(id);
            return ResponseEntity.ok(linkTo(BookController.class).withRel("All Books"));
        }
        else
            return ResponseEntity.notFound().build();
    }
}
