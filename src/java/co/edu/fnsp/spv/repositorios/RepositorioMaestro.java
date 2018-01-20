/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Ciudad;
import co.edu.fnsp.spv.entidades.Departamento;
import co.edu.fnsp.spv.entidades.NivelFormacion;
import co.edu.fnsp.spv.entidades.Pais;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author William
 */
@Repository("repositorioMaestro")
public class RepositorioMaestro implements IRepositorioMaestro {

    private SimpleJdbcCall obtenerPaises;
    private SimpleJdbcCall obtenerDepartamentos;
    private SimpleJdbcCall obtenerCiudades;
    private SimpleJdbcCall obtenerNivelesFormacion;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.obtenerPaises = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerPaises").
                returningResultSet("paises", BeanPropertyRowMapper.newInstance(Pais.class));
        this.obtenerDepartamentos = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerDepartamentos").
                returningResultSet("departamentos", BeanPropertyRowMapper.newInstance(Departamento.class));
        this.obtenerCiudades = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerMunicipios").
                returningResultSet("ciudades", BeanPropertyRowMapper.newInstance(Ciudad.class));
        this.obtenerNivelesFormacion = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerNivelesFormacion").
                returningResultSet("nivelesFormacion", BeanPropertyRowMapper.newInstance(NivelFormacion.class));
    }

    @Override
    public List<Pais> obtenerPaises() {
        Map resultado = obtenerPaises.execute(new HashMap<>());
        List<Pais> paises = (ArrayList<Pais>) resultado.get("paises");

        return paises;
    }

    @Override
    public List<Departamento> obtenerDepartamentos(int idPais) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdPais", idPais);
        Map resultado = obtenerDepartamentos.execute(parametros);
        List<Departamento> departamentos = (ArrayList<Departamento>) resultado.get("departamentos");

        return departamentos;
    }

    @Override
    public List<Ciudad> obtenerCiudades(String codigoDepartamento) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varCodigoDepartamento", codigoDepartamento);

        Map resultado = obtenerCiudades.execute(parametros);
        List<Ciudad> ciudades = (ArrayList<Ciudad>) resultado.get("ciudades");

        return ciudades;
    }

    @Override
    public List<NivelFormacion> obtenerNivelesFormacion() {
        Map resultado = obtenerNivelesFormacion.execute(new HashMap<>());
        List<NivelFormacion> nivelesFormacion = (ArrayList<NivelFormacion>) resultado.get("nivelesFormacion");

        return nivelesFormacion;
    }
}
