import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegexPlantUML {
    public static void main(String[] args) {
        // Texto que contiene la sintaxis de PlantUML sin cuerpo en la clase
        String text = "@startuml\nclass Test\n@enduml";

        // Expresión regular que combina @startuml ... @enduml y captura sintaxis de PlantUML
        String regex = "^@startuml[\\s\\S]*(class\\s+\\w+(\\s*\\{[\\s\\S]*?\\})?|interface\\s+\\w+|[\\+\\-\\#]\\w+\\s*\\([\\w\\s,]*\\)|[\\+\\-\\#]\\w+\\s*:\\s*\\w+|\\w+\\s*(--\\||<\\|--|-->|..>|..|>)\\s*\\w+)?[\\s\\S]*@enduml$";

        // Compilar el patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear el matcher para buscar en el texto
        Matcher matcher = pattern.matcher(text);

        // Verificar si el patrón se cumple
        if (matcher.matches()) {
            System.out.println("El texto contiene una sintaxis válida de PlantUML.");
            String Classname = matcher.group(3);
            System.out.println("La clase es: " + Classname);
        } else {
            System.out.println("El texto NO cumple con el formato de PlantUML.");
        }
    }
}




