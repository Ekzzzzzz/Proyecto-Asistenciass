package Modelos.Directorio;

import java.util.Objects;

public class DirectoryFactory {

    public static Directory getDirectoryType(String directorytype, String[] argumentos){

        if(Objects.isNull(directorytype) && Objects.isNull(argumentos))throw new UnsupportedOperationException("No se puede  validar un dato nulo");

        if(directorytype.equalsIgnoreCase("Jar")){
            return new JarDirectory(argumentos[0], argumentos[1]);
        }else if(directorytype.equalsIgnoreCase("normal")){
            return new NormalDirectory(argumentos[0], argumentos[1]);
        }else{
            return null;
        }
    }





}
