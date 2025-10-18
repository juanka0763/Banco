/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Vista;
import Modelo.Banco;
import Modelo.Cuenta;
import Modelo.CuentaAhorros;
import Modelo.CuentaCorriente;
import javax.swing.*;
import java.time.LocalDate;
/**
 *
 * @author juank
 */
public class MainBanco {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Efraneitor");
        int opcion;

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                        === MENÚ  ===
                        1. Crear cuenta de ahorros
                        2. Crear cuenta corriente
                        3. Consignar dinero
                        4. Retirar dinero
                        5. Consultar saldo
                        6. Mostrar información de una cuenta
                        7. Listar todas las cuentas
                        8. Eliminar cuenta
                        9. Salir
                        """));

                switch (opcion) {

                    case 1 -> { 
                        String numero = JOptionPane.showInputDialog("Número de cuenta:");
                        String nombre = JOptionPane.showInputDialog("Nombre del dueño:");
                        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial:"));
                        double tasa = Double.parseDouble(JOptionPane.showInputDialog("Tasa de interés (ej: 0.03 para 3%):"));
                        CuentaAhorros cuentaAhorros = new CuentaAhorros(numero, nombre, LocalDate.now(), saldo, tasa);
                        banco.registrarCuenta(cuentaAhorros);
                        JOptionPane.showMessageDialog(null, " Cuenta de ahorros creada con éxito.");
                    }

                    case 2 -> { 
                        String numero = JOptionPane.showInputDialog("Número de cuenta:");
                        String nombre = JOptionPane.showInputDialog("Nombre del dueño:");
                        double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo inicial:"));
                        double cupo = Double.parseDouble(JOptionPane.showInputDialog("Cupo de sobregiro:"));
                        CuentaCorriente cCorriente = new CuentaCorriente(numero, nombre, LocalDate.now(), saldo, cupo);
                        banco.registrarCuenta(cCorriente);
                        JOptionPane.showMessageDialog(null, " Cuenta corriente creada con éxito :D.");
                    }

                    case 3 -> { 
                        String num = JOptionPane.showInputDialog("Número de cuenta:");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a consignar:"));
                        if (banco.consignarEnCuenta(num, valor)) {
                            JOptionPane.showMessageDialog(null, " Consignación realizada.");
                        } else {
                            JOptionPane.showMessageDialog(null, "️ Cuenta no encontrada.");
                        }
                    }

                    case 4 -> {
                        String numero = JOptionPane.showInputDialog("Número de cuenta:");
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor a retirar:"));
                        if (banco.retirarDeCuenta(numero, valor)) {
                            JOptionPane.showMessageDialog(null, " Retiro exitoso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "️ Fondos insuficientes o cuenta inexistente.");
                        }
                    }

                    case 5 -> { 
                        String numero = JOptionPane.showInputDialog("Número de cuenta:");
                        Cuenta cuenta = banco.buscarCuenta(numero);
                        if (cuenta != null) {
                            JOptionPane.showMessageDialog(null, " Saldo actual: " + cuenta.getSaldo());
                        } else {
                            JOptionPane.showMessageDialog(null, "️ Cuenta no encontrada.");
                        }
                    }

                    case 6 -> { 
                        String numero = JOptionPane.showInputDialog("Número de cuenta:");
                        Cuenta cuenta = banco.buscarCuenta(numero);
                        if (cuenta != null) {
                            JOptionPane.showMessageDialog(null, cuenta.getDatos());
                        } else {
                            JOptionPane.showMessageDialog(null, "️ Cuenta no encontrada.");
                        }
                    }

                    case 7 -> 
                            JOptionPane.showMessageDialog(null, banco.listarCuentas());

                    case 8 -> { 
                        String numero = JOptionPane.showInputDialog("Número de cuenta a eliminar:");
                        if (banco.eliminarCuenta(numero)) {
                            JOptionPane.showMessageDialog(null, "️ Cuenta eliminada correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "️ No se encontró la cuenta.");
                        }
                    }

                    case 9 -> JOptionPane.showMessageDialog(null, " ¡Gracias por usar el Efraneitor");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Intente de nuevo.");
                opcion = 0;
            }

        } while (opcion != 9);
    }
}
