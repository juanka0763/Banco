/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author efrai
 */
public class CuentaAhorrosTest {

    CuentaAhorros ca;

    @BeforeEach
    void setUp() {
        ca = new CuentaAhorros("1001", "Maria", 1000, 0.05);
    }

    @Test
    void testAplicarInteres() {
        ca.aplicarInteres();
        assertEquals(1050, ca.getSaldo());
    }

    @Test
    void testAplicarInteresConTasaNueva() {
        ca.aplicarInteres(0.10);
        assertEquals(1100, ca.getSaldo());
    }

    @Test
    void testRetiroExitoso() {
        assertTrue(ca.retirar(200));
        assertEquals(800, ca.getSaldo());
    }

    @Test
    void testRetiroExcedeSaldo() {
        assertFalse(ca.retirar(2000));
        assertEquals(1000, ca.getSaldo());
    }

    @Test
    void testGetDatosIncluyeInteres() {
        String datos = ca.getDatos();
        assertTrue(datos.contains("Tasa de interés"));
    }

}
