-- Branch Office
INSERT INTO branch_office(country,city,street,number,zip_code) VALUES('México','Coahuila','San Pedro',2332,27957);
INSERT INTO branch_office(country,city,street,number,zip_code) VALUES('México','Queretaro','Las Olivas',8732,23124);

-- Data sales
INSERT INTO sales(id_employee,id_branch_office,total_sale,description,date_sale) VALUES(1,34,123.321,'New Sale 2',NOW());
INSERT INTO sales(id_employee,id_branch_office,total_sale,description,date_sale) VALUES(1,54,647.22,'New Sale 3',NOW());
INSERT INTO sales(id_employee,id_branch_office,total_sale,description,date_sale) VALUES(32,34,967.23,'New Sale 4',NOW());