package materials.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author pranjal
 * @date 2023-11-29
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Size(max = 256, message = "{validation.text.size}")
    private String additionalInfo;

    @Enumerated
    private Status status;

    private Date createdDate;
    private Date updatedDate;
    private Date deletedDate;

    @NotEmpty
    private Long materialTypeId;

    @NotEmpty
    private Long createdById;

    @NotEmpty
    private Long companyId;

    @PrePersist
    void prePersist() {
        this.status = Status.ACTIVE;
        this.createdDate = new Date();
        this.updatedDate = new Date();
        this.deletedDate = null;
    }

    @PreUpdate
    void preUpdate() {
        this.updatedDate = new Date();

        if (this.status == Status.DELETED) {
            this.deletedDate = new Date();
        }
    }

    public void updateThisWithDataFrom(Material that) {
        this.name = that.getName();
        this.additionalInfo = that.getAdditionalInfo();
    }
}
