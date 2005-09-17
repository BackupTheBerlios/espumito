package ar.com.espumito.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/*
 * Created on 05-jun-2005
 */

public class CreateBuildfile {

    public CreateBuildfile() {
        super();

    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("¡Faltan parametros!");
            showUsage();
            System.exit(1);
        }
        Configuration config = null;
        try {
            config = new Configuration();
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo de configuracion.");
            e.printStackTrace(System.err);
        }

        String projectName = args[0];
        String destinationDir = config.getProjectsHome() + "/" + projectName;
        File destinationFile = new File(destinationDir + "/"
                + config.getDefaultDestinationFileName());

        if (destinationFile.exists()) {
            String input = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            while (input.equals("")
                    && !(input.equalsIgnoreCase("s") || input
                            .equalsIgnoreCase("n"))) {
                System.out.println("El archivo "
                        + destinationFile.getAbsolutePath() + " ya existe.");
                System.out
                        .print("Si continua, va a sobreescribirlo. ¿Está seguro de que desea continuar? (s/n): ");
                try {
                    input = in.readLine();
                } catch (IOException e) {
                    input = "";
                }
            }
            if (input.equalsIgnoreCase("n"))
                System.exit(0);
        }

        try {
            System.out.println("Inicializando Velocity");
            Velocity.init();
            VelocityContext context = new VelocityContext();
            context.put("projectsHome", config.getProjectsHomeForTemplate());
            context.put("projectName", projectName);
            Template template = Velocity.getTemplate(config
                    .getBuildfileTemplate());
            FileWriter writer = new FileWriter(destinationFile);
            System.out.println("Procesando template.");
            template.merge(context, writer);
            writer.close();
            System.out.println("Procesamiento terminado sin errores.");
            System.out.println("Se genero el archivo " + destinationFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ocurrio un error al procesar el template: "
                    + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /**
     * 
     */
    public static void showUsage() {
        System.out.println(CreateBuildfile.class.getName()
                + " [proyecto] [directorio-destino]");
    }
}
