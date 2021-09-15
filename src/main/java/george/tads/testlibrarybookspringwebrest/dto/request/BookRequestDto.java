package george.tads.testlibrarybookspringwebrest.dto.request;

import george.tads.testlibrarybookspringwebrest.dto.response.IbnsResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.models.Book;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

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
                .setIbns(this.ibns)
                .setName(this.name)
                .setYearOfPublishing(this.yearOfPublishing)
                .setNumberOfPages(this.yearOfPublishing)
                .setAuthor(this.author);
    }

}
