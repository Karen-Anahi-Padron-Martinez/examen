package mx.utng.examen.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

//long tipo de dato primitivo
//Long: Clase envoltoria  que envuelve al tipo de dato long y le da más propiedades o calquier tipo de dato queempuece con mayusculas
@Entity
public class ListaEspera {

    @Id @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @NotEmpty //    NO ACEPTA VALORES NULL
@Column(length = 30)
    private String nombrelista; 

    @Column(length = 30)
    private String persona; 

   

   


    @Temporal(TemporalType.DATE)//Guardala fecha temporalmente
    private Date recordAt;

    @PrePersist
    public void prePersist(){
        recordAt = new Date();//Asigna la fecha y hora ACTUAL. del momento 

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrelista() {
        return nombrelista;
    }

    public void setNombrelista(String nombrelista) {
        this.nombrelista = nombrelista;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Date getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }

    



    
}
