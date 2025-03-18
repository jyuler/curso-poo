package co.edu.ean.poo.comisiones;

import java.time.LocalDate;

/**
 * La clase CalculadoraComisiones se encarga de calcular las comisiones de ventas
 * basadas en la fecha de ingreso del empleado, la fecha de la venta y el valor de la venta.
 */
public class CalculadoraComisiones {

    private static FestivosColombia festivos = new FestivosColombia();

    /**
     * Calcula la comisión de una venta.
     * Si la venta se hizo un año posterior al ingreso del empleado, la comisión es del 3%.
     * Si la venta se hizo entre 6 y 12 meses después del ingreso del empleado, la comisión es del 2.5%.
     * Si la venta se hizo antes de 6 meses del ingreso del empleado, la comisión es del 2%.
     * Si la venta se hizo en un día festivo (incluye domingos), se suma un 0.5% adicional a la comisión.
     * 
     * @param fechaIngresoEmpleado La fecha de ingreso del empleado.
     * @param fechaVenta La fecha en que se realizó la venta.
     * @param valorVenta El valor de la venta.
     * @return Un objeto Comision que contiene información sobre si la venta fue en un día festivo,
     *         el porcentaje de comisión y el valor de la comisión.
     */
    public static Comision calcularComision(LocalDate fechaIngresoEmpleado, LocalDate fechaVenta, int valorVenta) {
        boolean festivo = fechaVenta.getDayOfWeek().getValue() == 7 || festivos.esFestivo(fechaVenta);
        var p = fechaIngresoEmpleado.until(fechaVenta);
        var meses = 12 * p.getYears() + p.getMonths();
        float pcom = meses >= 12 ? 0.03f : meses >= 6 ? 0.025f : 0.02f;
        if (festivo) pcom += 0.005f;
        return new Comision(festivo, pcom, valorVenta * pcom);
    }
}