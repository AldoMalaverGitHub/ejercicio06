/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.ejercicio06.model.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import sunat.gob.pe.ejercicio06.model.dao.IAlumnoDao;
import sunat.gob.pe.ejercicio06.model.entities.Alumno;
import sunat.gob.pe.ejercicio06.model.util.Conexion;

/**
 *
 * @author Aldo Malaver
 */
public class AlumnoDaoImpl implements IAlumnoDao {

    @Override
    public void guardarAlumno(Alumno alumno) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        try {
            
            String sql = "Insert into Alumno(nombres, apellidos, sexo, direccion, correo, estado) VALUES(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, alumno.getNombres());
            pstmt.setString(2,alumno.getApellidos());
            pstmt.setString(3, alumno.getSexo());
            pstmt.setString(4, alumno.getCorreo());
            pstmt.setInt(5, alumno.getEstado());
            
            pstmt.executeUpdate(sql);
            
        } catch (SQLException se) {
            System.out.println(se.getMessage());    
        } finally {
            try{
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
            }catch(SQLException se){
                System.out.println(se.getMessage());    
            }
        }
    }

    @Override
    public List<Alumno> listarAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno buscarAlumnoPorId(Long idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarAlumno(Long idAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
