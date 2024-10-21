import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.util.regex.*;

import java.util.regex.*;

import java.util.regex.*;
import java.util.*;

public class RegexPlantUML {
    public static void main(String[] args) {
        // Simulamos el string de entrada que contiene el diagrama de PlantUML
        String text = "PlantUML text";

        // 1. Detectar clases, interfaces y abstractas
        Pattern patternClass = Pattern.compile("(class|interface|abstract)\\s+(\\w+)(\\s*\\{[\\s\\S]*?\\})");
        Matcher matcherClass = patternClass.matcher(text);

        // Mapa para almacenar clases y sus detalles (atributos y métodos)
        Map<String, List<String>> classDetails = new LinkedHashMap<>();

        while (matcherClass.find()) {
            String tipo = matcherClass.group(1); // class, interface o abstract
            String nombreClase = matcherClass.group(2); // Nombre de la clase o interfaz
            String cuerpoClase = matcherClass.group(3); // El cuerpo { ... } de la clase

            // Lista para almacenar los atributos y métodos de la clase
            List<String> detallesClase = new ArrayList<>();

            // 2. Buscar atributos dentro del cuerpo de la clase
            Pattern patternAttribute = Pattern.compile("([\\+\\-\\#])\\s*(\\w+)\\s+(\\w+);?");
            Matcher matcherAttribute = patternAttribute.matcher(cuerpoClase);

            while (matcherAttribute.find()) {
                String modificador = matcherAttribute.group(1); // Modificador de acceso
                String tipoDato = matcherAttribute.group(2); // Tipo de dato
                String nombreAtributo = matcherAttribute.group(3); // Nombre del atributo
                String mod = modificadorToJava(modificador); // Convertir el modificador a sintaxis Java
                detallesClase.add(mod + tipoDato + " " + nombreAtributo + ";"); // Sintaxis de atributo en Java
            }

            // 3. Buscar métodos dentro del cuerpo de la clase
            Pattern patternMethod = Pattern.compile("([\\+\\-\\#])\\s*(\\w+)\\s+(\\w+)\\s*\\((.*?)\\)");
            Matcher matcherMethod = patternMethod.matcher(cuerpoClase);

            while (matcherMethod.find()) {
                String modificador = matcherMethod.group(1); // Modificador de acceso
                String tipoRetorno = matcherMethod.group(2); // Tipo de retorno
                String nombreMetodo = matcherMethod.group(3); // Nombre del método
                String parametros = matcherMethod.group(4); // Parámetros del método
                String mod = modificadorToJava(modificador); // Convertir el modificador a sintaxis Java
                detallesClase.add(mod + tipoRetorno + " " + nombreMetodo + "(" + parametros + ") {}"); // Sintaxis de método en Java
            }

            // 4. Almacenar los detalles de la clase en el mapa
            classDetails.put(nombreClase, detallesClase);
        }

        // 5. Mostrar los resultados en formato de sintaxis Java
        for (Map.Entry<String, List<String>> entry : classDetails.entrySet()) {
            String nombreClase = entry.getKey();
            List<String> detalles = entry.getValue();

            System.out.println("public class " + nombreClase + " {"); // Definir la clase

            for (String detalle : detalles) {
                System.out.println("    " + detalle); // Imprimir atributos y métodos con indentación
            }

            System.out.println("}\n"); // Cerrar la clase
        }
    }

    // Convertir los modificadores de PlantUML a modificadores de Java
    private static String modificadorToJava(String modificador) {
        switch (modificador) {
            case "+":
                return "public ";
            case "-":
                return "private ";
            case "#":
                return "protected ";
            default:
                return "";
        }
    }
}






