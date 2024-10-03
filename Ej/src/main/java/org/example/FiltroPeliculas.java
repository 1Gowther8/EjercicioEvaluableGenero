package org.example;


import java.io.*;

class FiltroPeliculas {

public static void filtrarPorGenero(String genero) {


    // Validar que el archivo no sea nulo
    File archivo = new File("peliculas.csv");
    if (archivo == null)
        throw new IllegalArgumentException("El archivo no puede ser nulo");


    // Validar que el archivo exista
    if (!archivo.exists())
        throw new IllegalArgumentException("El archivo no existe");

    BufferedReader br = null;
    BufferedWriter bw = null;

    try  {
        br = new BufferedReader((new FileReader("peliculas.csv")));
        String linea;
        bw = new BufferedWriter(new FileWriter(genero+".csv"));
        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(",");
            if (datos[4].contains(genero)) {


                System.out.println("Titulo: " + datos[0]);
                System.out.println("Titulo: " + datos[1]);
                System.out.println("Año: " + datos[2]);
                System.out.println("Director: " + datos[3]);
                System.out.println("Género: " + datos[4]);

                bw.write(datos[0] + ",");
                bw.write(datos[1] + ",");
                bw.write(datos[2] + ",");
                bw.write(datos[3] + ",");
                bw.write(datos[4] + ",");
                bw.write("\n");



            }



        }



    } catch (FileNotFoundException e) {
        System.out.println("Error al leer lineas");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }finally {
        try {
            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo");
        }
    }

}
}
