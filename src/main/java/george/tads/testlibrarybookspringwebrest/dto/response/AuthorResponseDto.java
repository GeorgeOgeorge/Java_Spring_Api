package george.tads.testlibrarybookspringwebrest.dto.response;

import george.tads.testlibrarybookspringwebrest.controllers.AuthorController;
import george.tads.testlibrarybookspringwebrest.controllers.BookController;
import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorResponseDto extends RepresentationModel<AuthorResponseDto> {
    private String name;
    private String nationality;
    private List<BookResponseDto> books;

    public AuthorResponseDto(Author author) {
        this.name = author.getName();
        this.nationality = author.getNationality();

        ArrayList<BookResponseDto> list = new ArrayList<>();
        for(Book book : author.getBooks())
            list.add(new BookResponseDto(book));
        this.books = list;

        this.add(linkTo(AuthorController.class).slash(author.getId()).withSelfRel());
        this.add(linkTo(AuthorController.class).slash("edit/" + author.getId()).withRel("edit Author"));
        this.add(linkTo(AuthorController.class).slash("delete/" + author.getId()).withRel("delete Author"));
        this.add(linkTo(AuthorController.class).withRel("All Authors"));
    }
}
