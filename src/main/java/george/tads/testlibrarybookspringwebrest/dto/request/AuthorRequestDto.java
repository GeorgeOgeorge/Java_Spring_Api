package george.tads.testlibrarybookspringwebrest.dto.request;

import george.tads.testlibrarybookspringwebrest.dto.response.BookResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorRequestDto {
    private Long id;
    private String name;
    private String nationality;
    private List<BookRequestDto> books;

    public Author build() {
        List<Book> newBooks = new ArrayList<>();
        for(BookRequestDto bookDto : this.books)
            newBooks.add(bookDto.build());

        return new Author()
                .setId(this.id)
                .setName(this.name)
                .setNationality(this.nationality)
                .setBooks(newBooks);
    }
}
