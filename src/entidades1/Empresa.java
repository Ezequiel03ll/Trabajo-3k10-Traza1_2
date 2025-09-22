package entidades1;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "sucursales")
@Builder

public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Long cuil;
    private String logo;
    private Set<Sucursal> sucursales = new HashSet<>();
}
