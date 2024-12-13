package com.mycompany.examenninjaalejo.Controladores;

import com.mycompany.examenninjaalejo.Clases.Ninja;
import com.mycompany.examenninjaalejo.Percistencia.CRUD;
import com.mycompany.examenninjaalejo.Percistencia.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NinjaControlador {

    public static boolean insertNinja(String nombre, String rango, String aldea) {
        String query = "INSERT INTO Ninja(Nombre, Rango, Aldea) VALUES(?, ?, ?)";
        Ninja ninja = new Ninja(nombre, rango, aldea);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.insertIntoDB(query, ninja.getNombre(), ninja.getRango(), ninja.getAldea());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de inserción: " + e.getMessage());
            CRUD.rollbackDB();
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    public static boolean updateNinja(Ninja ninjas) throws SQLException {
        
        int idNinja = 0;
        String nombre = "";
        String rango;
        String aldea;
        
       idNinja=  ninjas.getIdNinja();
       nombre = ninjas.getNombre() ;
       rango =   ninjas.getRango();
       aldea = ninjas.getAldea();
  
        String query = "UPDATE Ninja SET Nombre = ?, Rango = ?, Aldea = ? WHERE ID = ?";
        Ninja ninja = new Ninja(idNinja, nombre, rango, aldea);

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.updateInDB(query, ninja.getNombre(), ninja.getRango(), ninja.getAldea(), ninja.getIdNinja());
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de actualización: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Delete a Ninja by ID
    public static boolean deleteNinja(int idNinja) throws SQLException {
        String query = "DELETE FROM Ninja WHERE ID = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            if (CRUD.setAutoCommitDB(false)) {
                boolean result = CRUD.deleteFromDB(query, idNinja);
                if (result) {
                    CRUD.commitDB();
                } else {
                    CRUD.rollbackDB();
                }
                return result;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación de eliminación: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return false;
    }

    // Get a Ninja by ID
    public static Ninja getNinjaById(int idNinja) throws SQLException {
        String query = "SELECT * FROM Ninja WHERE ID = ?";

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query, idNinja);

            if (rs.next()) {
                Ninja ninja = new Ninja(
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Rango"),
                        rs.getString("Aldea")
                );
                rs.close();
                return ninja;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ninja: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return null;
    }

    // List all Ninjas
    public static List<Ninja> listNinjas() throws SQLException {
        String query = "SELECT * FROM Ninja";
        List<Ninja> ninjasList = new ArrayList<>();

        try {
            CRUD.setConnection(ConexionDB.getConexion());
            ResultSet rs = CRUD.queryDB(query);

            while (rs.next()) {
                Ninja ninja = new Ninja(
                        rs.getInt("ID"),
                        rs.getString("Nombre"),
                        rs.getString("Rango"),
                        rs.getString("Aldea")
                );
                ninjasList.add(ninja);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los ninjas: " + e.getMessage());
            CRUD.rollbackDB();
            throw e;
        } finally {
            CRUD.closeConnection();
        }

        return ninjasList;
    }
}
