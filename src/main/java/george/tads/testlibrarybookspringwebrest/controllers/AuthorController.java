package george.tads.testlibrarybookspringwebrest.controllers;

import george.tads.testlibrarybookspringwebrest.dto.request.AuthorRequestDto;
import george.tads.testlibrarybookspringwebrest.dto.response.AuthorResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping(value = "/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorResponseDto> list() {
        return this.authorService.list();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorResponseDto> find(@PathVariable Long id) {
        Optional<Author> newAuthor = this.authorService.find(id);
        if(newAuthor.isPresent())
            return ResponseEntity.ok().body(new AuthorResponseDto(newAuthor.get()));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> insert(@RequestBody AuthorRequestDto authorDto) {
        Author newAuthor = this.authorService.insert(authorDto.build());
        return ResponseEntity.created(URI.create("authors/" + newAuthor.getId())).body(new AuthorResponseDto(newAuthor));
    }

    @PutMapping(value = "edit/{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable Long id, @RequestBody Author author) {
       Optional<Author> newAuthor = this.authorService.find(id);
       if(newAuthor.isPresent() && newAuthor.get().getId().equals(author.getId()))
           return ResponseEntity.ok(new AuthorResponseDto(author));
       else
           return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if(this.authorService.find(id).isPresent()) {
            this.authorService.delete(id);
            return ResponseEntity.ok(linkTo(AuthorController.class).withRel("All Authors"));
        }
        else
            return ResponseEntity.notFound().build();
    }






}
