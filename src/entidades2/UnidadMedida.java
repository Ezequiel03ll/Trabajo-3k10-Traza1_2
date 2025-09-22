package entidades2;

import lombok.*;
import lombok.experimental.SuperBuilder;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString

public class UnidadMedida {

    private Long id;
    private String denominacion;

}
