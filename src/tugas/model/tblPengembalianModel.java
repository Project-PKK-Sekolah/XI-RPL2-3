package tugas.model;

/**
 *
 * @author Fadillah
 */
public class tblPengembalianModel {
    private String namaBarang;
    private String jmlh;
    
    public tblPengembalianModel(String namaBarang, String jmlh){
        this.namaBarang = namaBarang;
        this.jmlh = jmlh;
    }

    /**
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @return the jmlh
     */
    public String getJmlh() {
        return jmlh;
    }

    /**
     * @param jmlh the jmlh to set
     */
    public void setJmlh(String jmlh) {
        this.jmlh = jmlh;
    }
}
