package george.tads.testlibrarybookspringwebrest.services;

import george.tads.testlibrarybookspringwebrest.dto.response.IbnsResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import george.tads.testlibrarybookspringwebrest.repositories.IbnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IbnsService {
    private IbnsRepository ibnsRepository;

    @Autowired
    public void setIbnsRepository(IbnsRepository ibnsRepository) {
        this.ibnsRepository = ibnsRepository;
    }

    public List<IbnsResponseDto> list() {
        List<IbnsResponseDto> ibnsDto = new ArrayList<>();
        for(Ibns ibns : this.ibnsRepository.findAll())
            ibnsDto.add(new IbnsResponseDto(ibns));
        return ibnsDto;
    }

    public Optional<Ibns> find(Long id) {
        return this.ibnsRepository.findById(id);
    }

    public Ibns insert(Ibns ibns) {
        return this.ibnsRepository.save(ibns);
    }

    public Ibns update(Ibns ibns) {
        return this.ibnsRepository.saveAndFlush(ibns);
    }

    public void delete(Long id) {
        this.ibnsRepository.deleteById(id);
    }
}
