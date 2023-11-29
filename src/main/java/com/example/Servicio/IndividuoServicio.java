package com.example.Servicio;

import com.example.Dominio.Individuo;
import java.util.List;

public interface IndividuoServicio {
    
    public List<Individuo> listIndividuos();
    
    public void save(Individuo individuo);
    
    public void delete(Individuo individuo);
    
    public Individuo find(Individuo individuo);
    
}
