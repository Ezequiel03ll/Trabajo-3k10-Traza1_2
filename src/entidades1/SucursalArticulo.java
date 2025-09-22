package entidades1;

import entidades2.Articulo;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class SucursalArticulo {
    private Integer stokArt;
    private LocalDate fechaIngreso;
    private Articulo articulo;
    private Sucursal sucursal;





}
