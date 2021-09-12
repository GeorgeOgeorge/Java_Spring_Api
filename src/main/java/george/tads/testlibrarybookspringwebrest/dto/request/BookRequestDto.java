package george.tads.testlibrarybookspringwebrest.dto.request;

import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.models.Book;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookRequestDto {
    private String name;
    private Short yearOfPublishing;
    private Short numberOfPages;
    private Ibns ibns;
    private Author author;

    public Book build() {
        return new Book()
                .setAuthor(this.author)
                .setIbns(this.ibns)
                .setName(this.name)
                .setYearOfPublishing(this.yearOfPublishing)
                .setNumberOfPages(this.yearOfPublishing);
    }

}
