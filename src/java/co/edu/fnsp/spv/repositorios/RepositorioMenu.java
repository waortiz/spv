/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.OpcionMenu;
import java.util.ArrayList;
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
@Repository("repositorioMenu")
public class RepositorioMenu implements IRepositorioMenu {

    private SimpleJdbcCall obtenerOpcionesMenuUsuario;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.obtenerOpcionesMenuUsuario = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ObtenerOpcionesMenuUsuario").
                returningResultSet("opcionesMenu", BeanPropertyRowMapper.newInstance(OpcionMenu.class));
     }

    @Override
    public ArrayList<OpcionMenu> obtenerOpcionesMenuUsuario(long idUsuario) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdUsuario", idUsuario);
        Map resultado = obtenerOpcionesMenuUsuario.execute(parametros);
        ArrayList<OpcionMenu> opcionesMenu = (ArrayList<OpcionMenu>) resultado.get("opcionesMenu");

        return opcionesMenu;
    }
}
