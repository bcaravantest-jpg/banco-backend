package ejercicio5;

import com.google.gson.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonRecursivoApp {

    public static void main(String[] args) {
        try {
            // Leer el archivo JSON
            String json = Files.readString(Path.of("datos.json"), StandardCharsets.UTF_8);

            // Parsear el JSON a un JsonElement
            JsonElement raiz = JsonParser.parseString(json);

            // Recorrer el JSON recursivamente
            recorrer("root", raiz, 0);

        } catch (IOException e) {
            System.err.println("No se pudo leer 'datos.json'. Asegúrese de crearlo en la raíz del proyecto.");
        } catch (JsonSyntaxException e) {
            System.err.println("JSON inválido: " + e.getMessage());
        }
    }

    // Método recursivo para recorrer cualquier estructura JSON
    private static void recorrer(String clave, JsonElement elemento, int nivel) {
        String indent = " ".repeat(nivel * 2); // indentación

        if (elemento == null || elemento.isJsonNull()) {
            System.out.println(indent + clave + ": null");
            return;
        }

        if (elemento.isJsonPrimitive()) {
            JsonPrimitive p = elemento.getAsJsonPrimitive();
            if (p.isString()) {
                System.out.println(indent + clave + ": \"" + p.getAsString() + "\"");
            } else {
                System.out.println(indent + clave + ": " + p.toString());
            }
            return;
        }

        if (elemento.isJsonArray()) {
            System.out.println(indent + clave + ": [");
            int idx = 0;
            for (JsonElement hijo : elemento.getAsJsonArray()) {
                recorrer("[" + idx + "]", hijo, nivel + 1);
                idx++;
            }
            System.out.println(indent + "]");
            return;
        }

        if (elemento.isJsonObject()) {
            System.out.println(indent + clave + ": {");
            for (Map.Entry<String, JsonElement> entry : elemento.getAsJsonObject().entrySet()) {
                recorrer(entry.getKey(), entry.getValue(), nivel + 1);
            }
            System.out.println(indent + "}");
        }
    }
}

