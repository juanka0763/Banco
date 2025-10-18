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
public class BancoIT {

    Banco banco;
    CuentaAhorros ca;
    CuentaCorriente cc;

    @BeforeEach
    void setUp() {
        banco = new Banco("Banco Test");
        ca = new CuentaAhorros("001", "Andrés", 1000, 0.03);
        cc = new CuentaCorriente("002", "Sofía", 500, 200);
        banco.registrarCuenta(ca);
        banco.registrarCuenta(cc);
    }

    @Test
    void testRegistrarYBuscarCuenta() {
        Cuenta encontrada = banco.buscarCuenta("001");
        assertNotNull(encontrada);
        assertEquals("Andrés", encontrada.getNombreDueno());
    }

    @Test
    void testConsignarEnCuenta() {
        assertTrue(banco.consignarEnCuenta("001", 500));
        assertEquals(1500, ca.getSaldo());
    }

    @Test
    void testRetirarDeCuentaAhorros() {
        assertTrue(banco.retirarDeCuenta("001", 200));
        assertEquals(800, ca.getSaldo());
    }

    @Test
    void testEliminarCuenta() {
        assertTrue(banco.eliminarCuenta("002"));
        assertEquals(1, banco.getTotalCuentas());
    }

    @Test
    void testListarCuentasContieneAmbas() {
        String lista = banco.listarCuentas();
        assertTrue(lista.contains("Andrés"));
        assertTrue(lista.contains("Sofía"));
    }

}
