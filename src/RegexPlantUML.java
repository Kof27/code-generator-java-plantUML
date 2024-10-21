import java.util.regex.Matcher;
import java.util.regex.Pattern;



import java.util.regex.*;

import java.util.regex.*;

import java.util.regex.*;
import java.util.*;

public class RegexPlantUML {
    public static void main(String[] args) {
        // Simulamos el string de entrada que contiene el diagrama de PlantUML
        String text = "@startuml\n" +
                "class Main \n" +
                "{\n" +
                " +void main (String[] args)\n" +
                "}\n" +
                "\n" +
                "class PopUp\n" +
                "{\n" +
                " +void displayResults(String msg)\n" +
                " +double readDouble(String prompt)\n" +
                " +int readIntgreaterThan(String prompt, int min)\n" +
                " +boolean yesOrNo (String prompt)\n" +
                " +int readMenuChoiceButtons(String prompt, String[] options)\n" +
                " +int readMenuChoiceIndex(String prompt, String[] options)\n" +
                " +String readMenuChoiceString(String prompt, String[] options)\n" +
                "}\n" +
                "\n" +
                "class Figures {\n" +
                "- ArrayList<GeometricFigure2D> figures2D\n" +
                "- ArrayList<GeometricFigure3D> figures3D\n" +
                "- int ID = 0\n" +
                "- String jsonStr = \"\"\n" +
                "- String json2D = \"\"\n" +
                "- String json3D = \"\"\n" +
                "- String jsonStrFinal = \"\"\n" +
                "- String Json\n" +
                "- String JSON\n" +
                "+ Figures() \n" +
                "- int IDgenerator() \n" +
                "+ void createCircle() \n" +
                "+ void createRectangle() \n" +
                "+ void createSquare() \n" +
                "+ void createEllipse() \n" +
                "+ void createSphere() \n" +
                "+ void createCuboid() \n" +
                "+ void createCube() \n" +
                "+ void createCone() \n" +
                "+ String setJSON() \n" +
                "+ String returnJSON() \n" +
                "+ String getJSON() \n" +
                "- String UpdateJSON2D() \n" +
                "- String UpdateJSON3D() \n" +
                "- String updateFinalJSON() \n" +
                "+ void deleteFigure()\n" +
                "\n" +
                "\n" +
                "}\n" +
                "class Interaction\n" +
                "{\n" +
                " - final PopUp popup\n" +
                " - final String[] menuOptions\n" +
                " - final String[] FigureOptions2D\n" +
                " - final String[] FigureOptions3D\n" +
                " - final String[] dimensionsFigureToDelete\n" +
                " - int options\n" +
                " - String jsonStr\n" +
                " - int ID_deleted\n" +
                " - Figures figures\n" +
                " - static org.apache.log4j.Logger logger\n" +
                "\n" +
                " +Interaction()\n" +
                " + void menu()\n" +
                " - void create2DFigure()\n" +
                " - void create3DFigure()\n" +
                " - void deleteFigure()\n" +
                "\n" +
                "}\n" +
                "\n" +
                "interface FigureGeometric2DInterface\n" +
                "{\n" +
                " +void calculateArea()\n" +
                " +void calculatePerimeter()\n" +
                "}\n" +
                "\n" +
                "interface FigureGeometric3DInterface\n" +
                "{\n" +
                " +void calculateVolume()\n" +
                " +void calculateSurface()\n" +
                "}\n" +
                "\n" +
                "abstract GeometricFigure3D\n" +
                "{\n" +
                " #double volume\n" +
                " #double surface\n" +
                " #int identificator\n" +
                " #String typeOfFigure\n" +
                " +FiguraGeometrica3D(String typeOfFigure, int identificator)\n" +
                " +void getVolume()\n" +
                " +void getSurface()\n" +
                " +abstract String toJson()\n" +
                "}\n" +
                "\n" +
                "abstract GeometricFigure2D\n" +
                "{\n" +
                " #double area\n" +
                " #double perimeter\n" +
                " #int identificator\n" +
                " #String typeOfFigure\n" +
                " +FiguraGeometrica2D(String typeOfFigure, int identificator)\n" +
                " +void getArea()\n" +
                " +void getPerimeter()\n" +
                " +String abstract toJSON()\n" +
                "}\n" +
                "\n" +
                "class circle\n" +
                "{\n" +
                " -double radio\n" +
                " +circle(double radius, int identificator)\n" +
                " +void calculateArea()\n" +
                " +void calculatePerimeter()\n" +
                " +String toJSON()\n" +
                "\n" +
                "}\n" +
                "\n" +
                "class square\n" +
                "{\n" +
                " -double length\n" +
                " +square(double Length, int identificator)\n" +
                " +void calculateArea()\n" +
                " +void calculatePerimeter()\n" +
                " +String toJSON()\n" +
                "}\n" +
                "\n" +
                "class  rectangle\n" +
                "{\n" +
                " -double length\n" +
                " -double height\n" +
                " +rectangle (double width, double height, int identification)\n" +
                " +void calculateArea()\n" +
                " +void calculatePerimeter()\n" +
                " +String toJSON()\n" +
                "}\n" +
                "\n" +
                "class sphere\n" +
                "{\n" +
                " -double radio\n" +
                " +sphere(double radius, int identificator)\n" +
                " + void calculateVolume()\n" +
                " + void calculateSurface()\n" +
                " + String toJSON()\n" +
                "}\n" +
                "\n" +
                "class cube\n" +
                "{\n" +
                " -double length\n" +
                " +cube (double length, int identificator)\n" +
                " + void calculateVolume()\n" +
                " + void calculateSurface()\n" +
                " + String toJSON()\n" +
                "}\n" +
                "\n" +
                "class cuboid\n" +
                "{\n" +
                " -double height\n" +
                " -double length\n" +
                " -double width\n" +
                " +cuboid (double height, double length, double width, int identificator)\n" +
                " + void calculateVolume()\n" +
                " + void calculateSurface()\n" +
                " + String toJSON()\n" +
                "}  \n" +
                "\n" +
                "\n" +
                "Interaction*-- PopUp\n" +
                "Interaction*-- Figures\n" +
                "Main --> Interaction\n" +
                "GeometricFigure3D ..|> FigureGeometric3DInterface\n" +
                "GeometricFigure2D ..|> FigureGeometric2DInterface\n" +
                "Interaction o--GeometricFigure3D\n" +
                "Interaction o--GeometricFigure2D\n" +
                "circle --|> GeometricFigure2D\n" +
                "square --|> GeometricFigure2D\n" +
                "rectangle --|> GeometricFigure2D\n" +
                "sphere --|>GeometricFigure3D\n" +
                "cube--|>GeometricFigure3D\n" +
                "cuboid--|>GeometricFigure3D\n" +
                "@enduml";

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






