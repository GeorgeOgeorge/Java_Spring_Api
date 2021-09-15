package george.tads.testlibrarybookspringwebrest.dto.response;

import george.tads.testlibrarybookspringwebrest.controllers.BookController;
import george.tads.testlibrarybookspringwebrest.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponseDto extends RepresentationModel<BookResponseDto> {
    private String name;
    private Short yearOfPublishing;
    private Short numberOfPages;
    private Short rating;
    private Boolean read;
    private IbnsResponseDto ibns;

    public BookResponseDto(Book book) {
        this.name = book.getName();
        this.yearOfPublishing = book.getYearOfPublishing();
        this.numberOfPages = book.getNumberOfPages();
        this.rating = book.getRating();
        this.read = book.getRead();
        this.ibns = new IbnsResponseDto(book.getIbns());

        this.add(linkTo(BookController.class).slash(book.getId()).withSelfRel());
        this.add(linkTo(BookController.class).slash("edit/" + book.getId()).withRel("edit book"));
        this.add(linkTo(BookController.class).slash("delete/" + book.getId()).withRel("delete book"));
        this.add(linkTo(BookController.class).withRel("All Books"));
    }
}
