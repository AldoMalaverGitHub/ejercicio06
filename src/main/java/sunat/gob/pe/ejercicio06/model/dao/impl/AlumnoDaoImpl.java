/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.ejercicio06.model.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
             pstmt.setString(4, alumno.getDireccion());
            pstmt.setString(5, alumno.getCorreo());
            pstmt.setInt(6, alumno.getEstado());
            
            pstmt.executeUpdate();
            
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
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();
        PreparedStatement pstmt = null;
        List<Alumno> listaAlumno = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            
            String sql = "Select idAlumno, nombres, apellidos, sexo, direccion, correo, estado from Alumno";
            pstmt = conn.prepareStatement(sql);
           
            rs = pstmt.executeQuery();
            while(rs.next()){
                listaAlumno.add(new Alumno(rs.getLong(1), rs.getString(2), rs.getString(3),
                rs.getString(4), rs.getString(5), 
                        rs.getString(6), rs.getInt(7)));
            }
            
        } catch (SQLException se) {
            System.out.println(se.getMessage());    
        } finally {
            try{
                if(conn != null)
                    conn.close();
                if(pstmt != null)
                    pstmt.close();
                if(rs != null)
                    rs.close();
            }catch(SQLException se){
                System.out.println(se.getMessage());    
            }
        }
        
        return listaAlumno;
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
