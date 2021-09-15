package george.tads.testlibrarybookspringwebrest.services;

import george.tads.testlibrarybookspringwebrest.dto.response.AuthorResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Author;
import george.tads.testlibrarybookspringwebrest.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorResponseDto> list() {
        List<AuthorResponseDto> authorsDto = new ArrayList<>();
        for( Author author : this.authorRepository.findAll())
            authorsDto.add(new AuthorResponseDto(author));
        return authorsDto;
    }

    public Optional<Author> find(Long id) {
        return this.authorRepository.findById(id);
    }

    public Author insert(Author author) {
        return this.authorRepository.save(author);
    }

    public Author update(Author author) {
        return this.authorRepository.saveAndFlush(author);
    }

    public void delete(Long id) {
        this.authorRepository.deleteById(id);
    }
}
