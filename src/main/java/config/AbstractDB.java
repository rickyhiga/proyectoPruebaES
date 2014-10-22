package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricky
 */
public abstract class AbstractDB {
    //Deberian declararse en cada Access
    protected static final StringBuilder dbType = new StringBuilder("org.sqlite.JDBC");
    protected StringBuilder dbPath = new StringBuilder("jdbc:sqlite:");
    protected StringBuilder query = new StringBuilder("");
    protected ResultSet rows;
    private Connection con;
    private Statement stmt;

    protected void setQuery(String sql) {
        query.setLength(0);
        query.append(sql);
    }

    
    public void openConnection() {
//        if (con.isClosed() == true) {
            try {
                Class.forName(dbType.toString());
                // System.out.println(dbPath.toString());
                con = DriverManager.getConnection(dbPath.toString());
                con.setAutoCommit(false);
                //System.out.println("DB abierta con éxito");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error al abrir DB - " + e.toString());
                System.exit(0);
            }
//        } else {
//            System.out.println("Ya se encuentra abierta");
//        }

    }

    public void closeConnection() {
//        if (con.isClosed() == false) {
            try {
                this.con.commit();
                this.stmt.close();
                this.con.close();
            } catch (SQLException ex) {
                System.out.println("Error en el cierre de la conexión db -" + ex.toString());
                System.exit(0);
            }
//        }else{
//            System.out.println("Ya se encuentra cerrada la con");
//        }

    }

    protected void executeSingleQuery() {

        System.out.println(query.toString());
        try {
            this.stmt = this.con.createStatement();
            this.stmt.executeUpdate(query.toString());
            System.out.println("SingleQuery ejecutada con éxito");
        } catch (SQLException ex) {

            System.out.println("Error al ejecutar SingleQuery - " + ex.toString());
            System.exit(0);
        }

    }

    protected ResultSet getResultsFromQuery() {

        System.out.println(query.toString());
        ResultSet rows = null;
        try {
            stmt = this.con.createStatement();
            rows = stmt.executeQuery(query.toString());

        } catch (SQLException ex) {

            System.out.println("Error al ejecutar consulta - " + ex.toString());
            System.exit(0);
        }
        return rows;
    }
    //SEPARAR POR CADA CREAR Y abstracto deberia ser en AccessSQLite
    protected void crearTablas() {

        String st = "CREATE TABLE IF NOT EXISTS [ciclo_lectivo] ( "
                + "  [id_ciclo_lectivo] INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "  [descripcion] VARCHAR DEFAULT NULL, "
                + "  [id_estado] INTEGER DEFAULT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [estado] ( "
                + "  [id_estado] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + "  [descripcion] VARCHAR DEFAULT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [plan] ( "
                + "  [id_plan] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + "  [descripcion] VARCHAR DEFAULT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [pregunta] ( "
                + "[id_preg] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "[descripcion] VARCHAR(400)  UNIQUE NOT NULL, "
                + "[id_tema] INTEGER DEFAULT 'NULL' NULL, "
                + "[id_estado] INTEGER DEFAULT 'NULL' NULL, "
                + "[id_plan] INTEGER DEFAULT 'NULL' NULL, "
                + "[id_ciclo_lectivo] INTEGER DEFAULT 'NULL' NULL, "
                + "[id_tipo_pregunta] INTEGER DEFAULT 'NULL' NULL, "
                + "[id_puntaje] INTEGER DEFAULT 'NULL' NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [respuesta] ( "
                + "[id_res] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL, "
                + "[id_preg] INTEGER  NOT NULL, "
                + "[descripcion] VARCHAR(400)  NOT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [tema] ( "
                + "  [id_tema] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + "  [descripcion] INTEGER NOT NULL, "
                + "  [vig_desde] DATE DEFAULT NULL, "
                + "  [vig_hasta] DATE DEFAULT NULL, "
                + "  [id_unidad] INTEGER NOT NULL, "
                + "  [id_estado] VARCHAR DEFAULT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [tipo_pregunta] ( "
                + "  [id_tipo_pregunta] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + "  [descripcion] VARCHAR DEFAULT NULL "
                + "); "
                + " "
                + "CREATE TABLE IF NOT EXISTS [unidad] ( "
                + "  [id_unidad] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + "  [descripcion] VARCHAR NOT NULL, "
                + "  [vig_desde] DATE DEFAULT NULL, "
                + "  [vig_hasta] DATE DEFAULT NULL, "
                + "  [id_estado] INTEGER DEFAULT NULL "
                + " "
                + ");";
        this.setQuery(st);
        this.openConnection();
        this.executeSingleQuery();
        this.closeConnection();
    }

    protected void closeResultSet() throws SQLException {
        this.stmt.close();
    }

    public abstract void insertar(String tabla, String[] columnas, String[] values);

}
