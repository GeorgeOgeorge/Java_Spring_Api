package george.tads.testlibrarybookspringwebrest.dto.request;

import george.tads.testlibrarybookspringwebrest.models.Ibns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IbnsRequestDto {
    private Long id;
    private String publisher;

    public Ibns build() {
        return new Ibns()
                .setId(this.id)
                .setPublisher(this.publisher);
    }
}
