package com.panatlanticdev.clubnauticogt;

import com.parse.ParseFile;

/**
 * Created by acifuina on 5/01/16.
 */
public class Post {


    private ParseFile imagen;
    private String titulo;
    private String informacion;



    public Post(String titulo, String informacion, ParseFile imagen)
    {
        this.imagen = imagen;
        this.titulo = titulo;
        this.informacion = informacion;
    }

    public Post() {
    }


    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo () {
        return this.titulo;
    }

    public void setInformacion (String informacion) {
        this.informacion = informacion;
    }

    public String getInformacion () {
        return this.informacion;
    }

    public void setImagen(ParseFile imagen) {
        this.imagen = imagen;
    }

    public ParseFile getImagen () {
        return this.imagen;
    }


}
