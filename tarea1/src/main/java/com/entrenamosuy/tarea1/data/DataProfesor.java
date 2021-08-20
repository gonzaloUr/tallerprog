package com.entrenamosuy.tarea1.data;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class DataProfesor extends DataUsuario {

    private final String descripcion;

    private final String biografia;

    private final URL sitioWeb;

    public DataProfesor(String nickname, String nombre, String apellido, Email correo, LocalDate nacimiento,
            Set<DataActividad> actividades, String descripcion, String biografia, URL sitioWeb) {
        super(nickname, nombre, apellido, correo, nacimiento, actividades);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.sitioWeb = sitioWeb;
   }

   public String getDescripcion() {
       return descripcion;
   }

   public String getBiografia() {
       return biografia;
   }

   public URL getSitioWeb() {
       return sitioWeb;
   }

   @Override
   public int hashCode() {
       return Objects.hash(super.hashCode(), descripcion, biografia, sitioWeb);
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null || getClass() != obj.getClass())
           return false;
       DataProfesor other = (DataProfesor) obj;
       return super.equals(other) && descripcion.equals(other.descripcion)
               && biografia.equals(other.biografia) && sitioWeb.equals(other.sitioWeb);
   }
}
