package entidades;

/**
 *
 * @author sarac
 */

public class POJO {
    public Integer id;
    public String codigo;
    public String empresa;
    public String contacto;
    public String cargo_contacto;
    public String direccion;
    public String ciudad;
    public String region;
    public String cp;
    public String pais;
    public String telefono;
    public String fax;

    public POJO(Integer id, String codigo, String empresa, String contacto, String cargo_contacto, String direccion, String ciudad, String region, String cp, String pais, String telefono, String fax) {
        this.id = id;
        this.codigo = codigo;
        this.empresa = empresa;
        this.contacto = contacto;
        this.cargo_contacto = cargo_contacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.cp = cp;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }

    public POJO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCargo_contacto() {
        return cargo_contacto;
    }

    public void setCargo_contacto(String cargo_contacto) {
        this.cargo_contacto = cargo_contacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return String.format("  %2s    %5s\t    %-38s  %-19s\t  %-6s\t %15s\t %-12s \t%-18s  %-10s ",id,codigo,empresa,contacto,cp,ciudad,pais,telefono,fax);
    }
    

   
    
    
}
