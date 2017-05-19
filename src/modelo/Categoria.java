
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Fermín
 */
@Entity
@Table(name="Categoria")
public class Categoria implements Serializable {
    @Id
    @SequenceGenerator(name="seq_categoria", sequenceName="seq_categoria_id", allocationSize=1)
    @GeneratedValue(generator="seq_categoria", strategy=GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max=50, message="La descripción no puede tener más de {max} caracteres")
    @NotBlank(message="La descripción es obligatoria")
    @NotNull(message="La descripción no puede estar vacía")
    @Column(name="descripcion", nullable=false, length=50)
    private String descripcion;
    
    @Length(max=20, message="El tipo no puede tener más de {max} caracteres")
    @NotBlank(message="El tipo es obligatorio")
    @NotNull(message="El tipo no puede estar vacío")
    @Column(name="tipo", nullable=false, length=20)
    private String tipo;

    public Categoria() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


}
