import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// IGNORAR ESTAS LÍNEAS
// SIMPLEMENTE ES PARA PROBAR LOS CAMBIOS Y COMMIT CON GITHUB

public class Main {
    public static void main(String[] args) {
        
        // Creamos el ArrayList
        ArrayList<Residuo> lista = new ArrayList<>();

        // Leemos el CSV
        try (BufferedReader br = new BufferedReader(new FileReader("materiales_radioactivos.csv"))){
            String linea;

            // Ignoramos la cabecera, como no se guarda en ninguna variable
            br.readLine();

            // Leemos linea a linea el resto de líneas, las guarda y comprueba si hay más lineas
            while ((linea = br.readLine()) != null){

                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double nivel = Double.parseDouble(partes[2]);
                double pesoKg = Double.parseDouble(partes[3]);
                int dias = Integer.parseInt(partes[4]);

                // Creamos el objeto Residuo
                Residuo r = new Residuo(id, nombre, nivel, pesoKg, dias);

                // Lo añadimos al ArrayList
                lista.add(r);
            }
        
            // Para capturar los errores
        } catch (IOException e) {   
            e.printStackTrace(); 
        }

        // Generamos el archivo informes.txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("informes.txt"))){

            for (Residuo r : lista){
                bw.write(r.generarInforme());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("Archivo informes.txt generado correctamente");
    }
}
