package api.sales.models;

import javax.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="sales")
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sale;
    private Integer id_employee;
    private Integer id_branch_office;
    private String name_branch_office;
    private Double total_sale;
    private String description;
    //@Temporal(TemporalType.DATE)
    private String date_sale;
    private String name_employee;

    @Override
    public String toString(){
        return 
                "{id_sale: "+this.id_sale+", "+
                "id_employee: "+this.id_employee+", "+
                "id_branch_office: "+this.id_branch_office+", "+
                "name_branch_office: "+this.name_branch_office+", "+
                "total_sale"+this.total_sale+", "+
                "description "+this.description+", "+
                "date_sale: "+this.date_sale+", "+
                "name_employee: "+this.name_employee+"}";
    }
}
