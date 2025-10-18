/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDate;
/**
 *
 * @author juank
 */
public class CuentaAhorros extends Cuenta {

    private double tasaInteres; 

    public CuentaAhorros(String numero, String nombreDueno, LocalDate fechaApertura, double saldoInicial, double tasaInteres) {
        super(numero, nombreDueno, fechaApertura, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorros(String numero, String nombreDueno, LocalDate fechaApertura, double saldoInicial) {
        this(numero, nombreDueno, fechaApertura, saldoInicial, 0.02);
    }

    public CuentaAhorros(String numero, String nombreDueno, double saldoInicial, double tasaInteres) {
        this(numero, nombreDueno, LocalDate.now(), saldoInicial, tasaInteres);
    }

    public CuentaAhorros(String numero, String nombreDueno) {
        this(numero, nombreDueno, LocalDate.now(), 0.0, 0.02);
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) return false;
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false; 
    }

    public void aplicarInteres() {
        saldo += saldo * tasaInteres;
    }

    public void aplicarInteres(double nuevaTasa) {
        saldo += saldo * nuevaTasa;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public String getDatos() {
        return "Cuenta de Ahorros\n" +
               "Número: " + numero + "\n" +
               "Dueño: " + nombreDueno + "\n" +
               "Fecha Apertura: " + fechaApertura + "\n" +
               String.format("Saldo: %.2f\n", saldo) +
               String.format("Tasa de interés: %.2f%%", tasaInteres * 100);
    }
}