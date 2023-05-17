package co.edu.interlemd.academico.repositorio;

import java.util.ArrayList;
import java.util.List;


import entidades.Materia;

public class MateriaRepositorio {
    private static List<Materia> lista = new ArrayList<Materia>();
    private static int index = 0;
    public Materia crear (Materia materia){
        materia.setId(index++);
        lista.add(materia);
        return materia;
    }
    public List<Materia> leerTodos(){
        return lista;

    }
    public Materia buscarPorId(int materiaId){
        Materia retorno = null;
        for(Materia materia: lista){
            if(materia.getId()==materiaId){
                retorno = materia;
                break;
            }

        }
     return retorno ;
    }
    
    public Materia actualizar(Materia materia){ 
        if(buscarPorId(materia.getId())!=null){
            lista.remove(materia);
        lista.add(materia);
    }
        return materia;
    }
    

}

