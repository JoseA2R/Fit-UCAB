package Domain;

import java.sql.*;

public class Sql {

    private static Connection conInstance;
    private Connection conn =bdConnect();
    private Statement _st;
    private ResultSet _rs;
    private static String BD_USER = "fitucab";
    private static String BD_PASSWORD = "fitucab";
    private static String BD_URL = "jdbc:postgresql://localhost/fitucabdb";
    private static String BD_CLASS_FOR_NAME = "org.postgresql.Driver";

    /**
     * Metodo para devolver una unica instancia de la conexion
     * @return instancia de la conexion
     */
    public static Connection getConInstance(){
        if (conInstance == null){
            conInstance = bdConnect();
        }
        return conInstance;
    }

    /**
     * Metodo que realiza la conexion contra la bd
     * @return
     */
    private static Connection bdConnect()
    {
        Connection conn = null;
        try
        {
            Class.forName(BD_CLASS_FOR_NAME);
            conn = DriverManager.getConnection(BD_URL,BD_USER, BD_PASSWORD);
        }
        catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( SQLException e ){
            e.printStackTrace();
        }
        catch ( Exception e ){
            e.printStackTrace();
        }
        finally {
            return _conn;
        }

    }

    /**
     * Metodo que realiza un query a la base de datos con devolucion
     * Realizar preferiblemente antes de bdConnect
     * @param query
     * @return Tabla que representa la consulta del query
     * @throws SQLException Error en SQL
     * @throws Exception
     * @see ResultSet
     */
    public ResultSet sql ( String query ) throws SQLException {

        _st = conn.createStatement();
        _rs  = _st.executeQuery(query);
        conn.close();
        return _rs;
    }

}
