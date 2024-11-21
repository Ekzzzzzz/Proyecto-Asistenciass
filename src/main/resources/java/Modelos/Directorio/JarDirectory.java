
package Modelos.Directorio;
import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.Objects;

public class JarDirectory extends Directory {

    private File JarFile;

    public JarDirectory(String direction, String file) {
        super(direction, file);
    }
    public JarDirectory(String direction){
        super(direction);
    }

    private void LoadLocation() throws URISyntaxException {
        try {
            CodeSource cs = Directory.class.getProtectionDomain().getCodeSource();
            this.JarFile = new  File(cs.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            throw e;
        }
    }

    private File get() {
        try {
            LoadLocation();
            File directoryJar = JarFile.getParentFile();
            if(directory==null){
                throw  new RuntimeException("No se puede obtener un directorio vacio.");
            }else {
                if ((directoryJar != null) && (directoryJar.isDirectory())) {
                    File arch = new File(directoryJar, directory);
                    return arch;
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean exists(){
        if(file == null && directory == null){
            throw new IllegalStateException("No se puede saber la existencia de un directorio vacio sin definir. ");
        }else if(file == null){
                return Objects.requireNonNull(get()).exists();
        }else{
            return new File(Objects.requireNonNull(get()).getAbsolutePath(),file).exists();
        }
    }


    public boolean create(){
        if(file == null && directory == null){
            throw new IllegalStateException("No se puede crear un directorio nulo");
        }else if(file == null){
            return new File(Objects.requireNonNull(get()).getAbsolutePath()).mkdirs();
        }else if(directory != null) {
            return new File(Objects.requireNonNull(get()).getAbsolutePath()).mkdirs();
        }
        return false;
    }



    public String getpath(){
        if(file != null){
            return new File(Objects.requireNonNull(get()).getAbsolutePath(), file).getAbsolutePath();
        }else{
            return Objects.requireNonNull(get()).getAbsolutePath();
        }
    }
}
