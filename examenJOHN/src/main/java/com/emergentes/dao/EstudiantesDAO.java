
package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import java.util.List;


public interface EstudiantesDAO {
    
    public void insert (Estudiantes aviso) throws Exception;
    public void update (Estudiantes aviso) throws Exception;
    public void delete (int id) throws Exception;
    public Estudiantes getById (int id) throws Exception;
    public List<Estudiantes> getAll () throws Exception;
    
}
