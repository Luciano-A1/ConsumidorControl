package com.example.Servicio;

import com.example.Data.IndividuoDAO;
import com.example.Dominio.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IndividuoServicioImp implements IndividuoServicio{
    
    @Autowired
    private IndividuoDAO IndividuoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listIndividuos() {
         return (List<Individuo>) IndividuoDao.findAll();
    }

    @Override
    @Transactional
    public void save(Individuo individuo) {
        IndividuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void delete(Individuo individuo) {
        IndividuoDao.delete(individuo);
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo find(Individuo individuo) {
        return IndividuoDao.findById(individuo.getIdIndividuo()).orElse(null);
    }
    
}
