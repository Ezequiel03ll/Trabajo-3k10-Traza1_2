package entidades1;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString (exclude = "localidad")
@Builder

public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;
    private Integer piso;
    private Integer nroDpto;


}
