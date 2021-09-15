package george.tads.testlibrarybookspringwebrest.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import george.tads.testlibrarybookspringwebrest.dto.request.IbnsRequestDto;
import george.tads.testlibrarybookspringwebrest.dto.response.BookResponseDto;
import george.tads.testlibrarybookspringwebrest.dto.response.IbnsResponseDto;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import george.tads.testlibrarybookspringwebrest.services.IbnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping(value = "/ibns")
public class IbnsController {

    private IbnsService ibnsService;

    @Autowired
    public void setIbnsService(IbnsService ibnsService) {
        this.ibnsService = ibnsService;
    }

    @GetMapping
    public List<IbnsResponseDto> list(){
        return this.ibnsService.list();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IbnsResponseDto> find(@PathVariable Long id) {
        Optional<Ibns> newIbns = this.ibnsService.find(id);
        if(newIbns.isPresent())
            return ResponseEntity.ok().body(new IbnsResponseDto(newIbns.get()));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<IbnsResponseDto> insert(@RequestBody IbnsRequestDto ibnsDto) {
        Ibns newIbns = this.ibnsService.insert(ibnsDto.build());
        return ResponseEntity.created(URI.create("ibns/" + newIbns.getId())).body(new IbnsResponseDto(newIbns));
    }

    @PutMapping(value = "edit/{id}")
    public ResponseEntity<IbnsResponseDto> update(@PathVariable Long id, @RequestBody Ibns ibns) {
        Optional<Ibns> newIbns = this.ibnsService.find(id);
        if(newIbns.isPresent() && newIbns.get().getId().equals(ibns.getId()))
            return ResponseEntity.ok().body(new IbnsResponseDto(this.ibnsService.update(ibns)));
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if(this.ibnsService.find(id).isPresent()) {
            this.ibnsService.delete(id);
            return ResponseEntity.ok(linkTo(IbnsController.class).withRel("All IBNSs"));
        }
        else
            return ResponseEntity.notFound().build();
    }

}
