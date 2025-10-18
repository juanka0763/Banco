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
public class CuentaCorriente extends Cuenta {

    private double cupoSobregiro; 


    public CuentaCorriente(String numero, String nombreDueno, LocalDate fechaApertura, double saldoInicial, double cupoSobregiro) {
        super(numero, nombreDueno, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    public CuentaCorriente(String numero, String nombreDueno, double saldoInicial, double cupoSobregiro) {
        this(numero, nombreDueno, LocalDate.now(), saldoInicial, cupoSobregiro);
    }

    public CuentaCorriente(String numero, String nombreDueno) {
        this(numero, nombreDueno, LocalDate.now(), 0.0, 500.0); 
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) return false;
        if (saldo + cupoSobregiro >= monto) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public double getCupoSobregiro() {
        return cupoSobregiro;
    }

    public void setCupoSobregiro(double cupoSobregiro) {
        this.cupoSobregiro = cupoSobregiro;
    }

    public double getSobregiroDisponible() {
        if (saldo >= 0) {
            return cupoSobregiro;
        } else {
            return cupoSobregiro + saldo; // saldo es negativo
        }
    }

    @Override
    public String getDatos() {
        return "Cuenta Corriente\n" +
               "Número: " + numero + "\n" +
               "Dueño: " + nombreDueno + "\n" +
               "Fecha Apertura: " + fechaApertura + "\n" +
               String.format("Saldo: %.2f\n", saldo) +
               String.format("Cupo Sobregiro: %.2f\n", cupoSobregiro) +
               String.format("Sobregiro Disponible: %.2f", getSobregiroDisponible());
    }
}
