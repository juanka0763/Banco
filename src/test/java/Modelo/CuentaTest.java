/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author efrai
 */
public class CuentaTest {

    @Test
    void testConsignarYSaldo() {
        Cuenta c = new Cuenta("001", "Juan", LocalDate.now(), 1000);
        c.consignar(500);
        assertEquals(1500, c.getSaldo());
    }

    @Test
    void testConsignarMontoNegativoLanzaExcepcion() {
        Cuenta c = new Cuenta("002", "Pedro", LocalDate.now(), 100);
        assertThrows(IllegalArgumentException.class, () -> c.consignar(-50));
    }

    @Test
    void testRetirarCorrectamente() {
        Cuenta c = new Cuenta("003", "Ana", LocalDate.now(), 200);
        assertTrue(c.retirar(100));
        assertEquals(100, c.getSaldo());
    }

    @Test
    void testRetiroMayorQueSaldoFalla() {
        Cuenta c = new Cuenta("004", "Laura", LocalDate.now(), 100);
        assertFalse(c.retirar(200));
    }

    @Test
    void testGetDatosCorto() {
        Cuenta c = new Cuenta("005", "Luis", LocalDate.now(), 250);
        String datos = c.getDatos(true);
        assertTrue(datos.contains("Cuenta"));
        assertTrue(datos.contains("Saldo"));
    }

}
