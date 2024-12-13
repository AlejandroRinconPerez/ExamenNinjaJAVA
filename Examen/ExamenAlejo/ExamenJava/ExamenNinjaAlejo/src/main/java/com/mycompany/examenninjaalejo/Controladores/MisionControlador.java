package com.mycompany.examenninjaalejo.Controladores;

import com.mycompany.examenninjaalejo.Clases.Mision;
import com.mycompany.examenninjaalejo.Percistencia.CRUD;
import com.mycompany.examenninjaalejo.Percistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MisionControlador {

    
    public static boolean insertMision(String descripcion, String rango, double recompensa) {
        String query = "INSERT INTO Mision (Descripcion, Rango, Recompensa) VALUES(?, ?, ?)";
        Mision mision = new Mision(descripcion, rango, recompensa);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, mision.getDescripcion(), mision.getRango(), mision.getRecompensa());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción de misión: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

 
    public static boolean updateMision(int idMision, String descripcion, String rango, double recompensa) throws SQLException {
        String query = "UPDATE Mision SET Descripcion = ?, Rango = ?, Recompensa = ? WHERE ID = ?";
        Mision mision = new Mision(idMision, descripcion, rango, recompensa);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, mision.getDescripcion(), mision.getRango(), mision.getRecompensa(), mision.getIdMision());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización de misión: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static boolean deleteMision(int idMision) throws SQLException {
        String query = "DELETE FROM Mision WHERE ID = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idMision);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación de misión: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static List<Mision> getAllMisiones() throws SQLException {
        String query = "SELECT * FROM Mision";
        List<Mision> misiones = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Mision mision = new Mision(
                        rs.getInt("ID"),
                        rs.getString("Descripcion"),
                        rs.getString("Rango"),
                        rs.getBigDecimal("Recompensa").doubleValue()
                );
                misiones.add(mision);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener las misiones: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return misiones;
    }

   
    public static Mision getMisionById(int idMision) throws SQLException {
        String query = "SELECT * FROM Mision WHERE ID = ?";
        Mision mision = null;

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idMision);

            if (rs.next()) {
                mision = new Mision(
                        rs.getInt("ID"),
                        rs.getString("Descripcion"),
                        rs.getString("Rango"),
                        rs.getBigDecimal("Recompensa").doubleValue()
                );
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la misión por ID: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return mision;
    }
}
