package test;

import dominio.Empleados;
import dominio.Fecha;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestEmpleadoFecha {

    static Scanner datos = new Scanner(System.in);
    static Fecha fechaNacimiento;
    static Fecha fechaIngreso;
    static Fecha fechaActual;

    public static void main(String[] args) {
        ingresarDatos();
    }

    public static void ingresarDatos() {
        System.out.println("¿Cuántos empleados desea registrar?");
        int n = datos.nextInt();
        Empleados trab[] = new Empleados[n];
        llenaEmpresa(trab);
        for (int i = 0; i < trab.length; i++) {
            
            System.out.println("Empleado No." + (i + 1));
            System.out.println("Nombre de empleado: " + trab[i].getNombre());
            System.out.println("Fecha de nacimiento " + trab[i].getFechaN().toString());
            System.out.print("Su edad es: ");
            calcularEdad(trab[i].getFechaN());
            System.out.println("");
            System.out.println("Fecha de ingreso: " + trab[i].getFechaI().toString());
            System.out.print("Tiempo que trabaja en la empresa:  ");
            calcularTiempo(trab[i].getFechaI());
            System.out.println("");
            System.out.println("");
            
        }
    }

    public static void llenaEmpresa(Empleados trab[]) {
        String nombre;
        int anio = 0,mes = 0,dia = 0;

        for (int i = 0; i < trab.length; i++) {
            datos.nextLine();
            System.out.println("Empleado Nro." + (i + 1));
            System.out.print("Ingrese nombre: ");
            nombre = datos.nextLine();
            System.out.println(" ");
            System.out.println("Fecha de nacimiento");
            System.out.println("Ingrese año:");
            anio = datos.nextInt();
            System.out.println("Ingrese mes:");
            mes = datos.nextInt();
            System.out.println("Ingrese dia:");
            dia = datos.nextInt();
            fechaNacimiento = new Fecha(dia, mes, anio);
            System.out.println(" ");
            System.out.println("Fecha de Ingreso:");
            System.out.println("Ingrese año:");
            anio = datos.nextInt();
            System.out.println("Ingrese mes:");
            mes = datos.nextInt();
            System.out.println("Ingrese dia:");
            dia = datos.nextInt();
            fechaIngreso = new Fecha(dia, mes, anio);
            System.out.println(" ");
            trab[i] = new Empleados(nombre, fechaNacimiento, fechaIngreso);
        }
    }

    public static Fecha fechaActual() {
        Calendar calendario = new GregorianCalendar();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DATE);
        fechaActual = new Fecha(dia,mes+1,anio);
        return fechaActual;
    }
    
    public static void calcularEdad(Fecha fechaNacimiento){
        fechaActual = fechaActual();
        LocalDate fechaNac = LocalDate.of(fechaNacimiento.getAnio(), fechaNacimiento.getMes(), fechaNacimiento.getDia());
        LocalDate fechaAct = LocalDate.of(fechaActual.getAnio(), fechaActual.getMes(), fechaActual.getDia());
        Period periodo = Period.between(fechaNac, fechaAct);
        System.out.printf("%s años, %s meses y %s dias.", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
    
        public static void calcularTiempo(Fecha fechaIngreso){
        fechaActual = fechaActual();
        LocalDate fechaIng = LocalDate.of(fechaIngreso.getAnio(), fechaIngreso.getMes(), fechaIngreso.getDia());
        LocalDate fechaAct = LocalDate.of(fechaActual.getAnio(), fechaActual.getMes(), fechaActual.getDia());
        Period periodo = Period.between(fechaIng, fechaAct);
        System.out.printf("%s años, %s meses y %s dias.", periodo.getYears(), periodo.getMonths(), periodo.getDays());
    }
}