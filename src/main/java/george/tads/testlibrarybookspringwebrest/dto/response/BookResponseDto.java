package george.tads.testlibrarybookspringwebrest.dto.response;

import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.models.Book;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookResponseDto {
    private Long id;
    private String name;
    private Short yearOfPublishing;
    private Short numberOfPages;
    private Short rating;
    private Boolean read;
    private Ibns ibns;
    private Author author;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.ibns = book.getIbns();
        this.author = book.getAuthor();
        this.name = book.getName();
        this.yearOfPublishing = book.getYearOfPublishing();
        this.numberOfPages = book.getNumberOfPages();
        this.rating = book.getRating();
        this.read = book.getRead();
    }
}
