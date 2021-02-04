/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Persona;
import co.edu.fnsp.spv.entidades.User;
import co.edu.fnsp.spv.utilidades.Util;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jedag
 */
@Repository("repositorioAdministracion")
public class RepositorioAdministracion implements IRepositorioAdministracion{
    
    private SimpleJdbcCall ingresarUsuario;
    private SimpleJdbcCall obtenerPersonas;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.ingresarUsuario = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ingresarUsuario");
        this.obtenerPersonas = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerPersonas").returningResultSet("personas", BeanPropertyRowMapper.newInstance(Persona.class));
        
    }
    
    
    @Override
    public User ingresarUser(User user) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varNombreUsuario", user.getPersona());
        parametros.addValue("varIdPersona", user.getPerfil());
        parametros.addValue("varClave", user.getClave());
        
        Map resultado = ingresarUsuario.execute(parametros);
        

        return user;
    }
    
    @Override
    public List<Persona> obtenerPersonas() {
        Map resultado = obtenerPersonas.execute();
        List <Persona> personas = (List<Persona>) resultado.get("personas");
       
        return personas;
    }

   }
