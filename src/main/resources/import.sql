-- Branch Office
INSERT INTO branch_office(name,state,city,street,number,zip_code) VALUES('Sucursal 1','Coahuila','San Pedro','Calle San Pedro',2332,27957);
INSERT INTO branch_office(name,state,city,street,number,zip_code) VALUES('Sucursal 2','Queretaro','Santiago de Queretaro','Las Olivas',8732,23124);

-- Data sales
INSERT INTO sales(id_employee,name_employee,id_branch_office,name_branch_office,total_sale,description,date_sale) VALUES(9,'fulano',2,'Sucursal 2',123321,'New Sale 2',NOW());
INSERT INTO sales(id_employee,name_employee,id_branch_office,name_branch_office,total_sale,description,date_sale) VALUES(9,'fulano',2,'Sucursal 2',64722,'New Sale 3',NOW());
