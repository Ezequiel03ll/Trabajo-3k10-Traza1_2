package entidades2;

import lombok.*;
import lombok.experimental.SuperBuilder;


import java.util.HashSet;
import java.util.Set;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true, exclude = "articuloManufacturadoDetalles")
@SuperBuilder
public class ArticuloManufacturado  extends Articulo{

    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;



    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new HashSet<>();


}
