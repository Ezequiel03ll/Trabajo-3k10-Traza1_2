package entidades1;

import lombok.*;

import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "localidades")
@Builder
public class Provincia {
    private Long id;
    private String nombre;
    private Pais pais;
    @Builder.Default
    private Set<Localidad> localidades=new HashSet<>();


}
