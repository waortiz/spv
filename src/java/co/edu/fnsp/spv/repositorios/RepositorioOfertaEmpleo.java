/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.fnsp.spv.repositorios;

import co.edu.fnsp.spv.entidades.Documento;
import co.edu.fnsp.spv.entidades.OfertaEmpleo;
import co.edu.fnsp.spv.entidades.Telefono;
import co.edu.fnsp.spv.utilidades.Util;
import java.util.ArrayList;
import java.util.Date;
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
@Repository("repositorioOfertaEmpleo")
public class RepositorioOfertaEmpleo implements IRepositorioOfertaEmpleo {

    private SimpleJdbcCall ingresarOfertaEmpleo;
    private SimpleJdbcCall actualizarOfertaEmpleo;
    private SimpleJdbcCall obtenerOfertasEmpleo;
    private SimpleJdbcCall obtenerOfertaEmpleo;
    private SimpleJdbcCall obtenerCodigoOfertaEmpleo;

    private SimpleJdbcCall obtenerDocumentoOfertaEmpleo;
    private SimpleJdbcCall ingresarDocumentoOfertaEmpleo;
    private SimpleJdbcCall actualizarDocumentoOfertaEmpleo;

    private SimpleJdbcCall ingresarTelefonoOferta;
    private SimpleJdbcCall eliminarTelefonoOferta;
    private SimpleJdbcCall actualizarTelefonoOferta;
    private SimpleJdbcCall obtenerTelefonosOferta;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        this.ingresarOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ingresarOfertaEmpleo");
        this.actualizarOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("actualizarOfertaEmpleo");
        this.obtenerOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerOfertaEmpleo");
        this.obtenerCodigoOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerCodigoOfertaEmpleo");
        this.obtenerOfertasEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerOfertasEmpleo").returningResultSet("ofertasEmpleo", BeanPropertyRowMapper.newInstance(OfertaEmpleo.class));

        this.obtenerDocumentoOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerDocumentoOfertaEmpleo");
        this.actualizarDocumentoOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("actualizarDocumentoOfertaEmpleo");
        this.ingresarDocumentoOfertaEmpleo = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ingresarDocumentoOfertaEmpleo");

        this.ingresarTelefonoOferta = new SimpleJdbcCall(jdbcTemplate).withProcedureName("ingresarTelefonoOferta");
        this.eliminarTelefonoOferta = new SimpleJdbcCall(jdbcTemplate).withProcedureName("eliminarTelefonoOferta");
        this.obtenerTelefonosOferta = new SimpleJdbcCall(jdbcTemplate).withProcedureName("obtenerTelefonosOferta").returningResultSet("telefonos", BeanPropertyRowMapper.newInstance(Telefono.class));
    }

    @Override
    public String ingresarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varCargo", ofertaEmpleo.getCargo());
        parametros.addValue("varDescripcion", ofertaEmpleo.getDescripcion());
        parametros.addValue("varEmpresa", ofertaEmpleo.getEmpresa());
        parametros.addValue("varFechaVigencia", ofertaEmpleo.getFechaVigencia());
        parametros.addValue("varNombreOfertante", ofertaEmpleo.getNombreOfertante());
        parametros.addValue("varPerfilAspirante", ofertaEmpleo.getPerfilAspirante());
        parametros.addValue("varTitulo", ofertaEmpleo.getTitulo());
        parametros.addValue("varSalario", ofertaEmpleo.getSalario());
        parametros.addValue("varUbicacion", ofertaEmpleo.getUbicacion());
        if (ofertaEmpleo.getNivelFormacion()!= null && ofertaEmpleo.getNivelFormacion() != "") {
            parametros.addValue("varNivelFormacion", ofertaEmpleo.getNivelFormacion());
        } else {
            parametros.addValue("varNivelFormacion", null);
        }
        parametros.addValue("varExperienciaMinina", ofertaEmpleo.getExperienciaMinina());
        parametros.addValue("varCorreoElectronicoPublicador", ofertaEmpleo.getCorreoElectronicoPublicador());
        Map resultado = ingresarOfertaEmpleo.execute(parametros);
        int idOfertaEmpleo = (int) resultado.get("varIdOfertaEmpleo");
        String codigo = (String) resultado.get("varCodigo");

        MapSqlParameterSource parametrosIngresoTelefono = new MapSqlParameterSource();
        parametrosIngresoTelefono.addValue("varIdOfertaEmpleo", idOfertaEmpleo);
        for (Telefono telefono : ofertaEmpleo.getTelefonos()) {
            parametrosIngresoTelefono.addValue("varCorreoElectronico", telefono.getCorreoElectronico());
            parametrosIngresoTelefono.addValue("varNombreContacto", telefono.getNombreContacto());
            parametrosIngresoTelefono.addValue("varNumero", telefono.getNumero());
            ingresarTelefonoOferta.execute(parametrosIngresoTelefono);
        }

        Documento documento = ofertaEmpleo.getDocumento();
        if (documento != null) {
            MapSqlParameterSource parametrosIngresoDocumentoOfertaEmpleo = new MapSqlParameterSource();
            parametrosIngresoDocumentoOfertaEmpleo.addValue("varIdOfertaEmpleo", idOfertaEmpleo);
            parametrosIngresoDocumentoOfertaEmpleo.addValue("varNombre", documento.getNombre());
            parametrosIngresoDocumentoOfertaEmpleo.addValue("varTipoContenido", documento.getTipoContenido());
            parametrosIngresoDocumentoOfertaEmpleo.addValue("varContenido", documento.getContenido());
            ingresarDocumentoOfertaEmpleo.execute(parametrosIngresoDocumentoOfertaEmpleo);
        }

        return codigo;
    }

    @Override
    public void actualizarOfertaEmpleo(OfertaEmpleo ofertaEmpleo) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdOfertaEmpleo", ofertaEmpleo.getId());
        parametros.addValue("varCargo", ofertaEmpleo.getCargo());
        parametros.addValue("varDescripcion", ofertaEmpleo.getDescripcion());
        parametros.addValue("varEmpresa", ofertaEmpleo.getEmpresa());
        parametros.addValue("varFechaVigencia", ofertaEmpleo.getFechaVigencia());
        parametros.addValue("varNombreOfertante", ofertaEmpleo.getNombreOfertante());
        parametros.addValue("varTitulo", ofertaEmpleo.getTitulo());
        parametros.addValue("varPerfilAspirante", ofertaEmpleo.getPerfilAspirante());
        parametros.addValue("varSalario", ofertaEmpleo.getSalario());
        parametros.addValue("varUbicacion", ofertaEmpleo.getUbicacion());
        if (ofertaEmpleo.getNivelFormacion() != null && ofertaEmpleo.getNivelFormacion() != "" ) {
            parametros.addValue("varNivelFormacion", ofertaEmpleo.getNivelFormacion());
        } else {
            parametros.addValue("varNivelFormacion", null);
        }
        parametros.addValue("varExperienciaMinina", ofertaEmpleo.getExperienciaMinina());
        parametros.addValue("varCorreoElectronicoPublicador", ofertaEmpleo.getCorreoElectronicoPublicador());
        actualizarOfertaEmpleo.execute(parametros);

        actualizarTelefono(ofertaEmpleo.getId(), ofertaEmpleo.getTelefonos());

        Documento documento = ofertaEmpleo.getDocumento();
        if (documento != null) {
            MapSqlParameterSource parametrosActualizacionDocumentoOfertaEmpleo = new MapSqlParameterSource();
            parametrosActualizacionDocumentoOfertaEmpleo.addValue("varIdOfertaEmpleo", ofertaEmpleo.getId());
            parametrosActualizacionDocumentoOfertaEmpleo.addValue("varNombre", documento.getNombre());
            parametrosActualizacionDocumentoOfertaEmpleo.addValue("varTipoContenido", documento.getTipoContenido());
            parametrosActualizacionDocumentoOfertaEmpleo.addValue("varContenido", documento.getContenido());
            actualizarDocumentoOfertaEmpleo.execute(parametrosActualizacionDocumentoOfertaEmpleo);
        }
    }

    @Override
    public List<OfertaEmpleo> obtenerOfertasEmpleo() {
        Map resultado = obtenerOfertasEmpleo.execute();
        List<OfertaEmpleo> ofertasEmpleo = (List<OfertaEmpleo>) resultado.get("ofertasEmpleo");
        for (OfertaEmpleo ofertaEmpleo : ofertasEmpleo) {
            ofertaEmpleo.setFechaVigenciaFormateada(Util.obtenerFechaFormateada(ofertaEmpleo.getFechaVigencia()));
            ofertaEmpleo.setSalarioFormateado(Util.obtenerNumeroFormatoMoneda(ofertaEmpleo.getSalario()));
        }

        return ofertasEmpleo;
    }

    @Override
    public OfertaEmpleo obtenerOfertaEmpleo(int idOfertaEmpleo) {
        OfertaEmpleo ofertaEmpleo = new OfertaEmpleo();
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdOfertaEmpleo", idOfertaEmpleo);

        Map resultado = obtenerOfertaEmpleo.execute(parametros);
        ofertaEmpleo.setId(idOfertaEmpleo);
        ofertaEmpleo.setCargo((String) resultado.get("varCargo"));
        ofertaEmpleo.setDescripcion((String) resultado.get("varDescripcion"));
        ofertaEmpleo.setEmpresa((String) resultado.get("varEmpresa"));
        ofertaEmpleo.setTitulo((String) resultado.get("varTitulo"));
        ofertaEmpleo.setFechaPublicacion((Date) resultado.get("varFechaPublicacion"));
        ofertaEmpleo.setFechaPublicacionFormateada(Util.obtenerFechaFormateada(ofertaEmpleo.getFechaPublicacion()));
        ofertaEmpleo.setFechaVigencia((Date) resultado.get("varFechaVigencia"));
        ofertaEmpleo.setFechaVigenciaFormateada(Util.obtenerFechaFormateada(ofertaEmpleo.getFechaVigencia()));
        ofertaEmpleo.setNombreOfertante((String) resultado.get("varNombreOfertante"));
        ofertaEmpleo.setPerfilAspirante((String) resultado.get("varPerfilAspirante"));
        ofertaEmpleo.setTieneDocumento(((Boolean) resultado.get("varTieneDocumento")));
        if (resultado.get("varSalario") != null) {
            ofertaEmpleo.setSalario((double) resultado.get("varSalario"));
            ofertaEmpleo.setSalarioFormateado(Util.obtenerNumeroFormatoMoneda(ofertaEmpleo.getSalario()));
        }
        ofertaEmpleo.setUbicacion((String) resultado.get("varUbicacion"));
        ofertaEmpleo.setNombreUbicacion((String) resultado.get("varNombreUbicacion"));
        if (resultado.get("varNivelFormacion") != null) {
            ofertaEmpleo.setNivelFormacion(Integer.toString((int) resultado.get("varNivelFormacion")));
        }
        ofertaEmpleo.setNombreNivelFormacion((String) resultado.get("varNombreNivelFormacion"));
        if (resultado.get("varExperienciaMinina") != null) {
            ofertaEmpleo.setExperienciaMinina((int) resultado.get("varExperienciaMinina"));
        }

        Map resultadoTelefonos = obtenerTelefonosOferta.execute(parametros);
        List<Telefono> telefonos = (List<Telefono>) resultadoTelefonos.get("telefonos");
        ofertaEmpleo.setTelefonos(telefonos);

        return ofertaEmpleo;
    }

    @Override
    public Documento obtenerDocumentoOfertaEmpleo(int idOfertaEmpleo) {
        Documento documento = null;
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdOfertaEmpleo", idOfertaEmpleo);

        Map resultado = obtenerDocumentoOfertaEmpleo.execute(parametros);

        if (resultado.get("varNombre") != null) {
            documento = new Documento();
            documento.setNombre((String) resultado.get("varNombre"));
            documento.setTipoContenido((String) resultado.get("varTipoContenido"));
            documento.setContenido((byte[]) resultado.get("varContenido"));
        }

        return documento;
    }

    private void actualizarTelefono(int idOfertaEmpleo, List<Telefono> telefonos) {
        MapSqlParameterSource parametrosConsultaTelefonos = new MapSqlParameterSource();
        parametrosConsultaTelefonos.addValue("varIdOfertaEmpleo", idOfertaEmpleo);
        Map resultadoTelefonos = obtenerTelefonosOferta.execute(parametrosConsultaTelefonos);
        ArrayList<Telefono> telefonosActuales = (ArrayList<Telefono>) resultadoTelefonos.get("telefonos");

        MapSqlParameterSource parametrosEliminacionTelefono = new MapSqlParameterSource();
        MapSqlParameterSource parametrosActualizacionTelefono = new MapSqlParameterSource();
        for (Telefono telefonoActual : telefonosActuales) {
            Telefono telefonoModificado = null;
            for (Telefono telefono : telefonos) {
                if (telefono.getId() == telefonoActual.getId()) {
                    telefonoModificado = telefono;
                    break;
                }
            }
            if (telefonoModificado == null) {
                parametrosEliminacionTelefono.addValue("varId", telefonoActual.getId());
                eliminarTelefonoOferta.execute(parametrosEliminacionTelefono);
            } else {
                parametrosActualizacionTelefono.addValue("varId", telefonoModificado.getId());
                parametrosActualizacionTelefono.addValue("varCorreoElectronico", telefonoModificado.getCorreoElectronico());
                parametrosActualizacionTelefono.addValue("varNombreContacto", telefonoModificado.getNombreContacto());
                parametrosActualizacionTelefono.addValue("varNumero", telefonoModificado.getNumero());
                actualizarTelefonoOferta.execute(parametrosActualizacionTelefono);
            }
        }

        MapSqlParameterSource parametrosIngresoTelefono = new MapSqlParameterSource();
        parametrosIngresoTelefono.addValue("varIdOfertaEmpleo", idOfertaEmpleo);
        for (Telefono telefono : telefonos) {
            if (telefono.getId() == 0) {
                parametrosIngresoTelefono.addValue("varCorreoElectronico", telefono.getCorreoElectronico());
                parametrosIngresoTelefono.addValue("varNombreContacto", telefono.getNombreContacto());
                parametrosIngresoTelefono.addValue("varNumero", telefono.getNumero());
                ingresarTelefonoOferta.execute(parametrosIngresoTelefono);
            }
        }
    }

    @Override
    public String obtenerCodigoOfertaEmpleo(int idOfertaEmpleoValidar) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue("varIdOfertaEmpleo", idOfertaEmpleoValidar);

        Map resultado = obtenerCodigoOfertaEmpleo.execute(parametros);
        return ((String) resultado.get("varCodigo"));
    }
}
