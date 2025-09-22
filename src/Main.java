import entidades1.*;
import entidades2.*;
import repositorios.InMemoryRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {



        //+++++++++++++++++++++++++++++++++++++++
        // Crear Repositorio de Empresas
        //+++++++++++++++++++++++++++++++++++++++
        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();

        System.out.println(" ----------- PROBAMOS EL SISTEMA CON ARTÍCULOS -----------");


        //+++++++++++++++++++++++++++++++++++++++
        // Crear País y Provincias
        //+++++++++++++++++++++++++++++++++++++++
        Pais argentina = Pais.builder().id(1L).nombre("Argentina").build();

        Provincia buenosAires = Provincia.builder().id(1L).nombre("Buenos Aires").pais(argentina).build();
        Provincia cordoba = Provincia.builder().id(2L).nombre("Cordoba").pais(argentina).build();


        //+++++++++++++++++++++++++++++++++++++++
        // Localidades y Domicilios
        //+++++++++++++++++++++++++++++++++++++++
        Localidad caba = Localidad.builder().id(1L).nombre("CABA").provincia(buenosAires).build();
        Domicilio domicilio1 = Domicilio.builder().id(1L).calle("Av. Corrientes").cp(1000).localidad(caba)
                .numero(123).piso(1).nroDpto(10).build();

        Localidad laPlata = Localidad.builder().id(2L).nombre("La Plata").provincia(buenosAires).build();
        Domicilio domicilio2 = Domicilio.builder().id(2L).calle("Calle 50").cp(1900).localidad(laPlata)
                .numero(456).piso(2).nroDpto(5).build();

        Localidad cordobaCapital = Localidad.builder().id(3L).nombre("Córdoba Capital").provincia(cordoba).build();
        Domicilio domicilio3 = Domicilio.builder().id(3L).calle("Av. Colón").cp(5000).localidad(cordobaCapital)
                .numero(789).piso(3).nroDpto(7).build();


        //+++++++++++++++++++++++++++++++++++++++
        // Categorías y Unidades de Medida
        //+++++++++++++++++++++++++++++++++++++++
        Categoria comidas = Categoria.builder().denominacion("Comidas").esInsumo(false).build();
        Categoria bebidas = Categoria.builder().denominacion("Bebidas").esInsumo(false).build();

        UnidadMedida gramos = UnidadMedida.builder().id(1L).denominacion("Gramos").build();
        UnidadMedida litros = UnidadMedida.builder().id(2L).denominacion("Litros").build();


        //+++++++++++++++++++++++++++++++++++++++
        // Artículos + Imágenes
        //+++++++++++++++++++++++++++++++++++++++
        ImagenArticulo img1 = ImagenArticulo.builder().nombre("BigMac").url("http://hamburguesa.com/bigmac").build();
        ImagenArticulo img2 = ImagenArticulo.builder().nombre("CocaCola").url("http://gaseosa.com/cocacola").build();

        ArticuloManufacturado hamburguesa = ArticuloManufacturado.builder()
                .denominacion("Big Mac")
                .categoria(comidas)
                .descripcion("Hamburguesa doble carne con queso")
                .precioVenta(15.0)
                .preparacion("Rápida")
                .unidadMedida(gramos)
                .imagenes(new HashSet<>(Set.of(img1)))
                .tiempoEstimadoMinutos(10)
                .build();

        ArticuloInsumo cocaCola = ArticuloInsumo.builder()
                .denominacion("Coca Cola 500ml")
                .stockActual(200)
                .stockMinimo(20)
                .stockMaximo(500)
                .esParaElaborar(false)
                .unidadMedida(litros)
                .categoria(bebidas)
                .build();



        //+++++++++++++++++++++++++++++++++++++++
        // Stock en sucursales
        //+++++++++++++++++++++++++++++++++++++++



        SucursalArticulo stockHamburguesa = SucursalArticulo.builder()
                .stokArt(50)
                .articulo(hamburguesa)
                .fechaIngreso(LocalDate.of(2025, 1, 10))
                .build();



        SucursalArticulo stockCoca = SucursalArticulo.builder()
                .stokArt(100)
                .articulo(cocaCola)
                .fechaIngreso(LocalDate.of(2025, 1, 12))
                .build();




        //+++++++++++++++++++++++++++++++++++++++
        // Sucursales McDonald's
        //+++++++++++++++++++++++++++++++++++++++
        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal McDonald's CABA")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(22, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio1)
                .sucursalArticulos(new HashSet<>(Set.of(stockHamburguesa)))
                .build();

        


        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal McDonald's La Plata")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(23, 0))
                .esCasaMatriz(false)
                .domicilio(domicilio2)
                .sucursalArticulos(new HashSet<>(Set.of(stockCoca)))
                .build();




        //+++++++++++++++++++++++++++++++++++++++
        // Empresa McDonald's
        //+++++++++++++++++++++++++++++++++++++++
        Empresa mcdonalds = Empresa.builder()
                .id(1L)
                .nombre("McDonald's")
                .razonSocial("McDonald's Argentina S.A.")
                .cuil(30547896541L)
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        sucursal1.setEmpresa(mcdonalds);
        sucursal2.setEmpresa(mcdonalds);


        //+++++++++++++++++++++++++++++++++++++++
        //  Carrefour
        //+++++++++++++++++++++++++++++++++++++++
        ImagenArticulo img3 = ImagenArticulo.builder().nombre("PanCarrefour").url("http://example.com/pan").build();

        ArticuloManufacturado pan = ArticuloManufacturado.builder()
                .denominacion("Pan Integral")
                .categoria(comidas)
                .descripcion("Pan integral de molde Carrefour")
                .precioVenta(3.5)
                .preparacion("Industrial")
                .unidadMedida(gramos)
                .imagenes(new HashSet<>(Set.of(img3)))
                .tiempoEstimadoMinutos(0)
                .build();

        SucursalArticulo stockPan = SucursalArticulo.builder()
                .stokArt(300)
                .articulo(pan)
                .fechaIngreso(LocalDate.of(2025, 2, 1))
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Carrefour Córdoba")
                .horarioApertura(LocalTime.of(8, 30))
                .horarioCierre(LocalTime.of(21, 0))
                .esCasaMatriz(true)
                .domicilio(domicilio3)
                .sucursalArticulos(new HashSet<>(Set.of(stockPan)))
                .build();

        Empresa carrefour = Empresa.builder()
                .id(2L)
                .nombre("Carrefour")
                .razonSocial("Carrefour Argentina S.A.")
                .cuil(30456789412L)
                .sucursales(new HashSet<>(Set.of(sucursal3)))
                .build();

        sucursal3.setEmpresa(carrefour);


        //+++++++++++++++++++++++++++++++++++++++
        // Guardar empresas en el repositorio
        //+++++++++++++++++++++++++++++++++++++++
        empresaRepository.save(mcdonalds);
        empresaRepository.save(carrefour);


        //+++++++++++++++++++++++++++++++++++++++
        // Punto A - Mostrar todas las empresas
        //+++++++++++++++++++++++++++++++++++++++
        System.out.println("\nTodas las empresas:");
        List<Empresa> todasLasEmpresas = empresaRepository.findAll();
        todasLasEmpresas.forEach(System.out::println);


        //+++++++++++++++++++++++++++++++++++++++
        // Punto B - Buscar empresas por su ID
        //+++++++++++++++++++++++++++++++++++++++
        System.out.println("\n---------- Empresas Buscadas por ID ----------");
        Optional<Empresa> empresaEncontrada = empresaRepository.findById(1L);
        empresaEncontrada.ifPresent(e -> System.out.println("Empresa encontrada por ID 1: " + e));


        //+++++++++++++++++++++++++++++++++++++++
        // Punto C - Buscar empresas por nombre
        //+++++++++++++++++++++++++++++++++++++++
        System.out.println("\n---------- Empresas Buscadas por Nombre ----------");
        List<Empresa> empresasPorNombre = empresaRepository.genericFindByField("nombre", "McDonald's");
        empresasPorNombre.forEach(System.out::println);


        //+++++++++++++++++++++++++++++++++++++++
        // Punto D - Actualizar empresa por su ID
        //+++++++++++++++++++++++++++++++++++++++
        Empresa empresaActualizada = Empresa.builder()
                .id(1L)
                .nombre("Carrefour Azul Actualizado")
                .razonSocial("Carrefour Azul S.A. Actualizado")
                .cuil(30111222333L)
                .sucursales(mcdonalds.getSucursales())
                .build();

        empresaRepository.genericUpdate(1L, empresaActualizada);
        Optional<Empresa> empresaVerificada = empresaRepository.findById(1L);
        empresaVerificada.ifPresent(e -> System.out.println("\n-------- Empresa después de la actualización: " + e));


        //+++++++++++++++++++++++++++++++++++++++
        // Punto E - Eliminar empresa por su ID
        //+++++++++++++++++++++++++++++++++++++++
        System.out.println("\n---------- Empresas Eliminadas ----------");
        empresaRepository.genericDelete(2L);
        Optional<Empresa> empresaEliminada = empresaRepository.findById(1L);
        if (empresaEliminada.isEmpty()) {
            System.out.println("La empresa con ID 1 ha sido eliminada.\n");
        }


        //+++++++++++++++++++++++++++++++++++++++
        // Mostrar todas las empresas restantes
        //+++++++++++++++++++++++++++++++++++++++
        System.out.println("Todas las empresas después de la eliminación:");
        List<Empresa> empresasRestantes = empresaRepository.findAll();
        empresasRestantes.forEach(System.out::println);

       // ++++++++++++++++++++++++++++++++++++++++++++++++++
        // Mostrar las sucursales de una empresa determinada
        //++++++++++++++++++++++++++++++++++++++++++++++++++
        Optional<Empresa> empresa = empresaRepository.findById(1L);
        if (empresa.isPresent()) {
            System.out.println("\n-----------Sucursales de la empresa con ID---------------- " +empresa.get().getId() + ":");
            Set<Sucursal> sucursales = empresa.get().getSucursales();
            sucursales.forEach(System.out::println);
        } else {
            System.out.println("Empresa con ID " + " no encontrada.");
        }

















        System.out.println("\n++++++++++++++++++++++Pruebas del Traza 2 +++++++++++++++++++++++++++++++");
        // Inicializar repositorios
        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();

        // Crear categorías
        Categoria pizzas = Categoria.builder().denominacion("Pizzas").esInsumo(false).build();
        Categoria sandwiches = Categoria.builder().denominacion("Sandwiches").esInsumo(false).build();
        Categoria bebidas1 = Categoria.builder().denominacion("Bebidas").esInsumo(false).build();
        Categoria insumos = Categoria.builder().denominacion("Insumos").esInsumo(true).build();

        categoriaRepository.save(pizzas);
        categoriaRepository.save(sandwiches);
        categoriaRepository.save(bebidas);
        categoriaRepository.save(insumos);

        // Crear unidades de medida
        UnidadMedida kg = UnidadMedida.builder().denominacion("Kg").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litro").build();
        UnidadMedida gramos1 = UnidadMedida.builder().denominacion("Gramos").build();

        unidadMedidaRepository.save(kg);
        unidadMedidaRepository.save(litro);
        unidadMedidaRepository.save(gramos);

        // Crear artículos insumos
        ArticuloInsumo sal = ArticuloInsumo.builder()
                .denominacion("Sal")
                .stockActual(100)
                .stockMinimo(10)
                .stockMaximo(200)
                .esParaElaborar(true)
                .unidadMedida(gramos)
                .categoria(insumos)
                .build();

        ArticuloInsumo harina = ArticuloInsumo.builder()
                .denominacion("Harina")
                .stockActual(50)
                .stockMinimo(5)
                .stockMaximo(100)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        ArticuloInsumo aceite = ArticuloInsumo.builder()
                .denominacion("Aceite")
                .stockActual(30)
                .stockMinimo(3)
                .stockMaximo(60)
                .esParaElaborar(true)
                .unidadMedida(litro)
                .categoria(insumos)
                .build();

        ArticuloInsumo carne = ArticuloInsumo.builder()
                .denominacion("Carne")
                .stockActual(20)
                .stockMinimo(2)
                .stockMaximo(40)
                .esParaElaborar(true)
                .unidadMedida(kg)
                .categoria(insumos)
                .build();

        articuloInsumoRepository.save(sal);
        articuloInsumoRepository.save(harina);
        articuloInsumoRepository.save(aceite);
        articuloInsumoRepository.save(carne);

        // Crear imágenes para los artículos
        ImagenArticulo img11 = ImagenArticulo.builder().
                nombre("HawaianaPizza1").url("http://example.com/pizza1").build();
        ImagenArticulo img21 = ImagenArticulo.builder().nombre("HawaianaPizza2").url("http://example.com/pizza2").build();
        ImagenArticulo img31 = ImagenArticulo.builder().nombre("HawaianaPizza3").url("http://example.com/pizza3").build();
        ImagenArticulo img4 = ImagenArticulo.builder().nombre("LomoCompletoLomo1").url("http://example.com/lomo1").build();
        ImagenArticulo img5 = ImagenArticulo.builder().nombre("LomoCompletoLomo2").url("http://example.com/lomo2").build();
        ImagenArticulo img6 = ImagenArticulo.builder().nombre("LomoCompletoLomo3").url("http://example.com/lomo3").build();

        // Crear detalles de artículos manufacturados
        ArticuloManufacturadoDetalle detalle1PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(harina)
                .build();

        ArticuloManufacturadoDetalle detalle3PizzaHawaina = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle1LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(sal)
                .build();

        ArticuloManufacturadoDetalle detalle2LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(1)
                .articuloInsumo(aceite)
                .build();

        ArticuloManufacturadoDetalle detalle3LomoCompleto = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(carne)
                .build();

        // Crear artículos manufacturados
        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaina")
                .precioVenta(12.0)
                .descripcion("Pizza con piña y jamón")
                .tiempoEstimadoMinutos(20)
                .preparacion("Hornear por 20 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();



        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(15.0)
                .descripcion("Lomo completo con todos los ingredientes")
                .tiempoEstimadoMinutos(25)
                .preparacion("Cocinar a la parrilla por 25 minutos")
                .categoria(sandwiches)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1LomoCompleto, detalle2LomoCompleto, detalle3LomoCompleto)))
                .build();

        articuloManufacturadoRepository.save(pizzaHawaina);
        articuloManufacturadoRepository.save(lomoCompleto);

        // Mostrar todas las categorías
        System.out.println("Todas las categorías:");
        List<Categoria> todasLasCategorias = categoriaRepository.findAll();
        todasLasCategorias.forEach(System.out::println);

        // Mostrar todos los artículos insumos
        System.out.println("Todos los artículos insumos:");
        List<ArticuloInsumo> todosLosArticulosInsumos = articuloInsumoRepository.findAll();
        todosLosArticulosInsumos.forEach(System.out::println);

        // Mostrar todos los artículos manufacturados
        System.out.println("Todos los artículos manufacturados:");
        List<ArticuloManufacturado> todosLosArticulosManufacturados = articuloManufacturadoRepository.findAll();
        todosLosArticulosManufacturados.forEach(System.out::println);

        // Buscar un artículo manufacturado por ID
        Optional<ArticuloManufacturado> articuloEncontrado = articuloManufacturadoRepository.findById(1L);
        articuloEncontrado.ifPresent(a -> System.out.println("Artículo manufacturado encontrado por ID 1: " + a));

        // Actualizar un artículo manufacturado por ID
        ArticuloManufacturado pizzaHawainaActualizada = ArticuloManufacturado.builder()

                .id(1L)
                .denominacion("Pizza Hawaina Actualizada")
                .precioVenta(14.0)
                .descripcion("Pizza con piña, jamón y queso extra")
                .tiempoEstimadoMinutos(22)
                .preparacion("Hornear por 22 minutos")
                .categoria(pizzas)
                .unidadMedida(kg)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .articuloManufacturadoDetalles(new HashSet<>(Set.of(detalle1PizzaHawaina, detalle2PizzaHawaina, detalle3PizzaHawaina)))
                .build();

        articuloManufacturadoRepository.genericUpdate(1L, pizzaHawainaActualizada);
        Optional<ArticuloManufacturado> articuloVerificado = articuloManufacturadoRepository.findById(1L);
        articuloVerificado.ifPresent(a -> System.out.println("Artículo manufacturado después de la actualización: " + a));

        // Eliminar un artículo manufacturado por ID
        articuloManufacturadoRepository.genericDelete(1L);
        Optional<ArticuloManufacturado> articuloEliminado = articuloManufacturadoRepository.findById(1L);
        if (articuloEliminado.isEmpty()) {
            System.out.println("El artículo manufacturado con ID 1 ha sido eliminado.");
        }

        // Mostrar todos los artículos manufacturados restantes
        System.out.println("Todos los artículos manufacturados restantes:");
        todosLosArticulosManufacturados = articuloManufacturadoRepository.findAll();
        todosLosArticulosManufacturados.forEach(System.out::println);




    }


}
