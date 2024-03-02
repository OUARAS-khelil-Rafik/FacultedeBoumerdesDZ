package facultdeboumerdes.umbb.dz;

public class Faculty {
    String nameFac;
    String nameDoyen;
    String telFax;
    String mail;
    String siteWeb;
    String adresse;

    public Faculty(){

    }

    public Faculty(String nameFac, String nameDoyen, String telFax, String mail, String siteWeb, String adresse){
        this.nameFac=nameFac;
        this.nameDoyen=nameDoyen;
        this.telFax=telFax;
        this.mail=mail;
        this.siteWeb=siteWeb;
        this.adresse=adresse;
    }

    public void setNameFac(String nameFac) {
        this.nameFac = nameFac;
    }

    public String getNameFac(){
        return this.nameFac;
    }

    public void setNameDoyen(String nameDoyen) {
        this.nameDoyen = nameDoyen;
    }

    public String getNameDoyen(){
        return this.nameDoyen;
    }

    public void setTelFax(String telFax) {
        this.telFax = telFax;
    }

    public String getTelFax(){
        return this.telFax;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getSiteWeb(){
        return this.siteWeb;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse(){
        return this.adresse;
    }
}
