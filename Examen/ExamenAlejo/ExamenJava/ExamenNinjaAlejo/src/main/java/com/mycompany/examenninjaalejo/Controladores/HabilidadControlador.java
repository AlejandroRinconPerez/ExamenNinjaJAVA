package com.mycompany.examenninjaalejo.Controladores;


import com.mycompany.examenninjaalejo.Percistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.examenninjaalejo.Clases.Habilidad;

import com.mycompany.examenninjaalejo.Percistencia.ConexionDB;

public class HabilidadControlador {


    public static boolean insertHabilidad(int idNinja, String nombre, String descripcion) {
        String query = "INSERT INTO Habilidad(ID_Ninja, Nombre, Descripcion) VALUES(?, ?, ?)";
        Habilidad habilidad = new Habilidad(idNinja, nombre, descripcion);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, habilidad.getId_Ninja(), habilidad.getNombre(), habilidad.getDescripcion());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción de habilidad: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static boolean updateHabilidad(int idNinja, String nombre, String descripcion) throws SQLException {
        String query = "UPDATE Habilidad SET Descripcion = ? WHERE ID_Ninja = ? AND Nombre = ?";
        Habilidad habilidad = new Habilidad(idNinja, nombre, descripcion);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, habilidad.getDescripcion(), habilidad.getId_Ninja(), habilidad.getNombre());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización de habilidad: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

 
    public static boolean deleteHabilidad(int idNinja, String nombre) throws SQLException {
        String query = "DELETE FROM Habilidad WHERE ID_Ninja = ? AND Nombre = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idNinja, nombre);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación de habilidad: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }


    public static Habilidad getHabilidadById(int idNinja, String nombre) throws SQLException {
        String query = "SELECT * FROM Habilidad WHERE ID_Ninja = ? AND Nombre = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idNinja, nombre);

            if (rs.next()) {
                Habilidad habilidad = new Habilidad(
                        rs.getInt("ID_Ninja"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                );
                rs.close();
                return habilidad;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la habilidad: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }


    public static List<Habilidad> listHabilidades(int idNinja) throws SQLException {
        String query = "SELECT * FROM Habilidad WHERE ID_Ninja = ?";
        List<Habilidad> habilidadesList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idNinja);

            while (rs.next()) {
                Habilidad habilidad = new Habilidad(
                        rs.getInt("ID_Ninja"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                );
                habilidadesList.add(habilidad);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las habilidades: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return habilidadesList;
    }
}
