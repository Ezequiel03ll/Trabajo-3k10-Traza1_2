package entidades2;
import lombok.*;
import lombok.experimental.SuperBuilder;

//import javax.persistence.Entity;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "categoria")
@Setter
@SuperBuilder


public abstract class Articulo  {
    protected Long id;
    protected String denominacion;
    protected Double precioVenta;



    @Builder.Default

    protected Set<ImagenArticulo> imagenes = new HashSet<>();


    protected UnidadMedida unidadMedida;


    private  Categoria categoria;



}
