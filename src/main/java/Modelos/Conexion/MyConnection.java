package Modelos.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public interface MyConnection{
    Connection conect() throws SQLException;
}
