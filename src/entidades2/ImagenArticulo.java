package entidades2;

import lombok.*;
import lombok.experimental.SuperBuilder;

//import javax.persistence.Entity;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
public class ImagenArticulo {
    private Long id;
    private String nombre;
    private String url;

}
