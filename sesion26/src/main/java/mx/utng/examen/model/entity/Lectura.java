package mx.utng.examen.model.entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import jakarta.validation.constraints.NotEmpty;

@Entity
public class Lectura {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String tituloLibro;
    
    @Column(length = 30)
    private String autor;
    
    
    
    
    @Temporal(TemporalType.DATE)
    private Date recordAt;
    
    @PrePersist
    public void prePersist(){
        recordAt = new Date();
    }
    
 



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }





    public String getTituloLibro() {
        return tituloLibro;
    }





    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }





    public String getAutor() {
        return autor;
    }





    public void setAutor(String autor) {
        this.autor = autor;
    }





    public Date getRecordAt() {
        return recordAt;
    }





    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }





   



}

