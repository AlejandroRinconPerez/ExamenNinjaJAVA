
package com.mycompany.examenninjaalejo.Controladores;

import com.mycompany.examenninjaalejo.Clases.MisionNinja;
import com.mycompany.examenninjaalejo.Percistencia.CRUD;
import com.mycompany.examenninjaalejo.Percistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MisionNinjaControlador {
    
   
    public static boolean insertMisionNinja(int idNinja, int idMision, LocalDate fechaInicio, LocalDate fechaFin) {
        String query = "INSERT INTO MisionNinja(ID_Ninja, ID_Mision, FechaInicio, FechaFin) VALUES(?, ?, ?, ?)";
        MisionNinja misionNinja = new MisionNinja(idNinja, idMision, fechaInicio, fechaFin);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, misionNinja.getIdNinja(), misionNinja.getIdMision(),
                        misionNinja.getFechaInicio(), misionNinja.getFechaFin());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción de misión ninja: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static boolean updateMisionNinja(int idNinja, int idMision, LocalDate fechaInicio, LocalDate fechaFin) throws SQLException {
        String query = "UPDATE MisionNinja SET FechaInicio = ?, FechaFin = ? WHERE ID_Ninja = ? AND ID_Mision = ?";
        MisionNinja misionNinja = new MisionNinja(idNinja, idMision, fechaInicio, fechaFin);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, misionNinja.getFechaInicio(), misionNinja.getFechaFin(),
                        misionNinja.getIdNinja(), misionNinja.getIdMision());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización de misión ninja: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

 
    public static boolean deleteMisionNinja(int idNinja, int idMision) throws SQLException {
        String query = "DELETE FROM MisionNinja WHERE ID_Ninja = ? AND ID_Mision = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idNinja, idMision);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación de misión ninja: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static List<MisionNinja> getMisionNinjaByNinja(int idNinja) throws SQLException {
        String query = "SELECT * FROM MisionNinja WHERE ID_Ninja = ?";
        List<MisionNinja> misionesNinja = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idNinja);

            while (rs.next()) {
                MisionNinja misionNinja = new MisionNinja(
                        rs.getInt("ID_Ninja"),
                        rs.getInt("ID_Mision"),
                        rs.getDate("FechaInicio").toLocalDate(),
                        rs.getDate("FechaFin").toLocalDate()
                );
                misionesNinja.add(misionNinja);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener las misiones del ninja: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return misionesNinja;
    }


    public static List<MisionNinja> getMisionNinjaByMision(int idMision) throws SQLException {
        String query = "SELECT * FROM MisionNinja WHERE ID_Mision = ?";
        List<MisionNinja> misionesNinja = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idMision);

            while (rs.next()) {
                MisionNinja misionNinja = new MisionNinja(
                        rs.getInt("ID_Ninja"),
                        rs.getInt("ID_Mision"),
                        rs.getDate("FechaInicio").toLocalDate(),
                        rs.getDate("FechaFin").toLocalDate()
                );
                misionesNinja.add(misionNinja);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los ninjas de la misión: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return misionesNinja;
    }
    
}
