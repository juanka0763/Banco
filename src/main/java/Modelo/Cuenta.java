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
public class Cuenta {
    protected String numero;
    protected String nombreDueno;
    protected LocalDate fechaApertura;
    protected double saldo;

    public Cuenta(String numero, String nombreDueno, LocalDate fechaApertura, double saldoInicial) {
        this.numero = numero;
        this.nombreDueno = nombreDueno;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
    }

    public Cuenta(String numero, String nombreDueno, double saldoInicial) {
        this(numero, nombreDueno, LocalDate.now(), saldoInicial);
    }

    public Cuenta(String numero, String nombreDueno) {
        this(numero, nombreDueno, LocalDate.now(), 0.0);
    }

    public void consignar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a consignar debe ser mayor que 0.");
        }
        saldo += monto;
    }

    public void consignar(double monto, String referencia) {
        consignar(monto);
    }


    public boolean retirar(double monto) {
        if (monto <= 0) return false;
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    
    public String getDatos() {
        return "Cuenta\n" +
               "Número: " + numero + "\n" +
               "Dueño: " + nombreDueno + "\n" +
               "Fecha apertura: " + fechaApertura + "\n" +
               String.format("Saldo: %.2f", saldo);
    }

    public String getDatos(boolean corto) {
        if (corto) {
            return String.format("Cuenta %s - Saldo: %.2f", numero, saldo);
        } else {
            return getDatos();
        }
    }

    @Override
    public String toString() {
        return getDatos(true);
    }
}
