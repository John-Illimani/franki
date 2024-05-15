
package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB;
import com.emergentes.modelo.Estudiantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends ConexionDB implements EstudiantesDAO {

    @Override
    public void insert(Estudiantes aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into estudiantes(nombre,apellido,seminario,confirmado,fecha) value(?,?,?,?,?)");
            ps.setString(1, aviso.getNombre());
            ps.setString(2, aviso.getApellido());
            ps.setString(3, aviso.getSeminario());
            ps.setString(4, aviso.getConfirmado());
            ps.setString(5, aviso.getFecha());
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }

    }

    @Override
    public void update(Estudiantes aviso) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("update estudiantes set nombre = ?, apellido = ?, seminario = ?, confirmado = ?, fecha = ? where id = ?");
            ps.setString(1, aviso.getNombre());
            ps.setString(2, aviso.getApellido());
            ps.setString(3, aviso.getSeminario());
            ps.setString(4, aviso.getConfirmado());
            ps.setString(5, aviso.getFecha());
            ps.setInt(6, aviso.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from estudiantes where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Estudiantes getById(int id) throws Exception {
        Estudiantes avi = new Estudiantes();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from estudiantes  where id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setNombre(rs.getString("nombre"));
                avi.setApellido(rs.getString("apellido"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setConfirmado(rs.getString("confirmado"));
                avi.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> lista = null;

        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from estudiantes");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Estudiantes>();
            while (rs.next()) {
                Estudiantes avi = new Estudiantes();
                avi.setId(rs.getInt("id"));
                avi.setNombre(rs.getString("nombre"));
                avi.setApellido(rs.getString("apellido"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setConfirmado(rs.getString("confirmado"));
                avi.setFecha(rs.getString("fecha"));
                lista.add(avi);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
        } finally {
            this.desconectar();
        }
        return lista;

    }

}
