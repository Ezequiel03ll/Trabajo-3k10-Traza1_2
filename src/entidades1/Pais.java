package entidades1;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = "provincia")

public class Pais {
    private Long id;
    private String nombre;
    @Builder.Default
    private Set<Provincia> provincia =new HashSet<>();

}


