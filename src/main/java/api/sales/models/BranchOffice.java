package api.sales.models;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "branch_office")
public class BranchOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_branch_office;
	private String name;
	private String state;
	private String city;
	private String street;
	private String number;
	private Integer zip_code;
	
}
