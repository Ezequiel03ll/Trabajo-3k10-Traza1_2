package entidades1;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;
    private Domicilio domicilio;
    private Empresa empresa;

    @Builder.Default
    private Set<SucursalArticulo> sucursalArticulos=new HashSet<>();

}

