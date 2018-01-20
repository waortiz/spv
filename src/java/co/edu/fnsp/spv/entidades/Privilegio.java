package co.edu.fnsp.spv.entidades;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;

public class Privilegio implements GrantedAuthority {

    private int idPrivilegio;
    private String codigo;
    private String nombre;
    private ArrayList<OpcionMenu> opcionesMenu = new ArrayList<>();
    
    /**
     * @return the idPrivilegio
     */
    public int getIdPrivilegio() {
        return idPrivilegio;
    }

    /**
     * @param idPrivilegio the idPrivilegio to set
     */
    public void setIdPrivilegio(int idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getAuthority() {
        return this.codigo;
    }

    /**
     * @return the opcionesMenu
     */
    public ArrayList<OpcionMenu> getOpcionesMenu() {
        return opcionesMenu;
    }

    /**
     * @param opcionesMenu the opcionesMenu to set
     */
    public void setOpcionesMenu(ArrayList<OpcionMenu> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }    
}
