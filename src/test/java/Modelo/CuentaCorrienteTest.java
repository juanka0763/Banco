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
public class CuentaCorrienteTest {

    CuentaCorriente cc;

    @BeforeEach
    void setUp() {
        cc = new CuentaCorriente("2001", "Carlos", 500, 300);
    }

    @Test
    void testRetiroDentroDelSaldo() {
        assertTrue(cc.retirar(200));
        assertEquals(300, cc.getSaldo());
    }

    @Test
    void testRetiroConSobregiro() {
        assertTrue(cc.retirar(700));
        assertEquals(-200, cc.getSaldo());
    }

    @Test
    void testRetiroExcedeSobregiro() {
        assertFalse(cc.retirar(1000));
        assertEquals(500, cc.getSaldo());
    }

    @Test
    void testSobregiroDisponibleCorrecto() {
        cc.retirar(600); // queda -100
        assertEquals(200, cc.getSobregiroDisponible());
    }

    @Test
    void testGetDatosIncluyeCupo() {
        String datos = cc.getDatos();
        assertTrue(datos.contains("Cupo Sobregiro"));
    }

}
