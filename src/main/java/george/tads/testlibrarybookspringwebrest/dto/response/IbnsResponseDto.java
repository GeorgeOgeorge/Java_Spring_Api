package george.tads.testlibrarybookspringwebrest.dto.response;

import george.tads.testlibrarybookspringwebrest.controllers.IbnsController;
import george.tads.testlibrarybookspringwebrest.models.Ibns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class IbnsResponseDto extends RepresentationModel<IbnsResponseDto> {
    private Long id;
    private String publisher;

    public IbnsResponseDto(Ibns ibns) {
        this.id = ibns.getId();
        this.publisher = ibns.getPublisher();

        this.add(linkTo(IbnsController.class).slash(ibns.getId()).withSelfRel());
        this.add(linkTo(IbnsController.class).slash(ibns.getId()).withRel("edit ibns"));
        this.add(linkTo(IbnsController.class).slash(ibns.getId()).withRel("delete ibns"));
        this.add(linkTo(IbnsController.class).withRel("All IBNSs"));
    }
}
