-- Branch Office
INSERT INTO branch_office(name,state,city,street,number,zip_code) VALUES('Sucursal 1','Coahuila','San Pedro','Calle San Pedro',2332,27957);
INSERT INTO branch_office(name,state,city,street,number,zip_code) VALUES('Sucursal 2','Queretaro','Santiago de Queretaro','Las Olivas',8732,23124);

-- Data sales
--INSERT INTO sales(id_employee,name_employee,id_branch_office,name_branch_office,total_sale,description,date_sale) VALUES(9,'fulano',2,'Sucursal 2',123321,'New Sale 2',NOW());
INSERT INTO sales(id_employee,id_branch_office,total_sale,description,date_sale,name_employee,name_branch_office,state_branch_office,city_branch_office,street_branch_office,number_branch_office,zip_code_branch_office,folio) VALUES(9,1,999.99,'Test sale 1', NOW(), 'fulano', 'Sucursal 1', 'Coahuila', 'San Pedro', 'Calle San Pedro',2356,27957,'Folio test1');
INSERT INTO sales(id_employee,id_branch_office,total_sale,description,date_sale,name_employee,name_branch_office,state_branch_office,city_branch_office,street_branch_office,number_branch_office,zip_code_branch_office,folio) VALUES(9,1,888.88,'Test sale 2', NOW(), 'fulano', 'Sucursal 1', 'Coahuila', 'San Pedro', 'Calle San Pedro',2356,27957,'Folio test1');
