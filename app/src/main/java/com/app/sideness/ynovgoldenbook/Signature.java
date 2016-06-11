package com.app.sideness.ynovgoldenbook;

/**
 * Created by siden on 11/06/2016.
 */
public class Signature {
    private  String nomSignataire="";
    private  String imgSignataire="";
    private  String textSignataire="";

    /*********** Set Methods ******************/

    public void setNomSignataire(String nomSignataire)
    {
        this.nomSignataire = nomSignataire;
    }

    public void setImgSignataire(String imgSignataire)
    {
        this.imgSignataire = imgSignataire;
    }

    public void setTextSignataire(String textSignataire)
    {
        this.textSignataire = textSignataire;
    }

    /*********** Get Methods ****************/

    public String getNomSignataire()
    {
        return this.nomSignataire;
    }

    public String getImgSignataire()
    {
        return this.imgSignataire;
    }

    public String getTextSignataire()
    {
        return this.textSignataire;
    }
}
