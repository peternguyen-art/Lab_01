
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;

/**
 *
 * @author wulft
 *
 * Use the thread safe NIO IO library to read a file
 */
public class PersonReader
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<Person> persons = new ArrayList<>();

        try
        {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");

            // use the toolkit to get the current working directory of the IDE
            // Not sure if the toolkit is thread safe...
            File workingDirectory = new File(System.getProperty("user.dir"));

            // Typiacally, we want the user to pick the file so we use a file chooser
            // kind of ugly code to make the chooser work with NIO.
            // Because the chooser is part of Swing it should be thread safe.
            chooser.setCurrentDirectory(workingDirectory);
            // Using the chooser adds some complexity to the code.
            // we have to code the complete program within the conditional return of
            // the filechooser because the user can close it without picking a file

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally we can read the file LOL!
                int line = 0;

                //header
                String myFormat = "%-8s %-12s %-12s %-8s %-5s";
                String header = String.format(myFormat, "ID#", "Firstname", "Lastname", "Title", "YOB");
                System.out.println(header);
                System.out.println("====================================================");
                while(reader.ready())
                {
                    rec = reader.readLine();
                    // echo to screen

                    // Split by comma
                    String[] parts = rec.split(",");

                    if (parts.length == 5) {
                        String id = parts[0].trim();
                        String firstName = parts[1].trim();
                        String lastName = parts[2].trim();
                        String title = parts[3].trim();
                        int yob = Integer.parseInt(parts[4].trim());

                        // Person object and add to arrayList
                        Person p = new Person(id, firstName, lastName, title, yob);
                        persons.add(p);

                        // Print nicely formatted
                        String data = String.format(myFormat, id, firstName, lastName, title, yob);
                        System.out.println(data);
                    }
                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
