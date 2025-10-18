/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author juank
 */
public class Banco {

    private String nombreBanco;
    private List<Cuenta> cuentas;

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
        this.cuentas = new ArrayList<>();
    }

    public Banco() {
        this("Banco Sin Nombre");
    }

    public void registrarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula.");
        }
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero().equalsIgnoreCase(numero)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean eliminarCuenta(String numero) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            cuentas.remove(cuenta);
            return true;
        }
        return false;
    }

    public int getTotalCuentas() {
        return cuentas.size();
    }

    public List<Cuenta> getCuentas() {
        return new ArrayList<>(cuentas); 
    }

    public boolean consignarEnCuenta(String numero, double monto) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            cuenta.consignar(monto);
            return true;
        }
        return false;
    }

    public boolean retirarDeCuenta(String numero, double monto) {
        Cuenta cuenta = buscarCuenta(numero);
        if (cuenta != null) {
            return cuenta.retirar(monto);
        }
        return false;
    }

    public String listarCuentas() {
        if (cuentas.isEmpty()) {
            return "No hay cuentas registradas.";
        }
        StringBuilder sb = new StringBuilder("=== Cuentas registradas en " + nombreBanco + " ===\n");
        for (Cuenta cuenta : cuentas) {
            sb.append(cuenta.getDatos()).append("\n----------------------\n");
        }
        return sb.toString();
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }
}
