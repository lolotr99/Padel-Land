package modelo;
// Generated 27-may-2022 20:07:28 by Hibernate Tools 4.3.1



/**
 * Properties generated by hbm2java
 */
public class Properties  implements java.io.Serializable {

     private long id;
     private String propertie;
     private String value;

    public Properties() {
    }

    public Properties(long id, String propertie, String value) {
       this.id = id;
       this.propertie = propertie;
       this.value = value;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public String getPropertie() {
        return this.propertie;
    }
    
    public void setPropertie(String propertie) {
        this.propertie = propertie;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


