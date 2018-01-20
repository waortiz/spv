/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Usuario;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author William
 */
@Repository("repositorioSeguridad")
public class RepositorioSeguridad implements IRepositorioSeguridad {

    private SimpleJdbcCall obtenerUsuario;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        this.obtenerUsuario = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerUsuario");
     }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario usuario = null;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varNombreUsuario", nombreUsuario);

        Map resultado = obtenerUsuario.execute(parametros);
        if (resultado.get("varIdUsuario") != null) {
            usuario = new Usuario();
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setNombres((String) resultado.get("varNombres"));
            usuario.setApellidos((String) resultado.get("varApellidos"));
            usuario.setClave((String) resultado.get("varClave"));
            usuario.setCorreoElectronico((String) resultado.get("varCorreoElectronico"));
            usuario.setIdUsuario(Integer.parseInt(resultado.get("varIdUsuario").toString()));
        }

        return usuario;
    }
}
