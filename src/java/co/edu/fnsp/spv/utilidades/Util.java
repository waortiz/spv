/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.utilidades;

import co.edu.fnsp.spv.entidades.Telefono;
import com.google.gson.Gson;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author William
 */
public class Util {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat simpleLongDateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "CO"));
    private static final DecimalFormat decimalFormat = new DecimalFormat("'$'###,###");

    public static String obtenerFechaFormateada(Date fecha) {
        if (fecha != null) {
            return simpleDateFormat.format(fecha);
        }

        return "";
    }

    public static String obtenerFechaLargaFormateada(Date fecha) {
        if (fecha != null) {
            return simpleLongDateFormat.format(fecha);
        }

        return "";
    }

    public static Date obtenerFecha(String fecha) throws ParseException {
        return simpleDateFormat.parse(fecha);
    }

    public static String obtenerNumeroFormatoMoneda(Long valor) {
        if (valor != null) {
            return decimalFormat.format(valor);
        }

        return "";
    }

    public static String obtenerNumeroFormatoMoneda(Double valor) {
        if (valor != null) {
            return decimalFormat.format(valor);
        }

        return "";
    }

    public static long obtenerNumero(String numero) throws ParseException {
        return Long.parseLong(numero);
    }

    public static int obtenerEntero(String numero) throws ParseException {
        return Integer.parseInt(numero);
    }

    public static double obtenerNumeroDecimal(String numero) throws ParseException {
        if (numero != null && numero.length() > 0) {
            return decimalFormat.parse(numero).doubleValue();
        }

        return 0;
    }

    public static String obtenerTelefonosJSON(List<Telefono> telefonos) {
        Util.establecerConsecutivoTelefonos(telefonos);
        Gson gson = new Gson();
        String json = gson.toJson(telefonos);

        return json;
    }
    
    public static void establecerConsecutivoTelefonos(List<Telefono> telefonos) {
        for (int i = 0; i < telefonos.size(); i++) {
            Telefono telefono = telefonos.get(i);
            telefono.setConsecutivo(i);
        }
    }
}
