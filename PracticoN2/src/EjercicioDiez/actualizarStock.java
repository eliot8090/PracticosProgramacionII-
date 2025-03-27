package EjercicioDiez;

public class actualizarStock {
    public static int ActualStock(int stockActual, int cantidadVendida, int cantidadRecibidaNuevoStock){
        return stockActual-cantidadVendida+cantidadRecibidaNuevoStock;
    }
}
