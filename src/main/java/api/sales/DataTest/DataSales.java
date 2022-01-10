package api.sales.DataTest;

import api.sales.models.Sale;

import java.util.Date;

public class DataSales {

    public static final Sale sale_1 = new Sale(1L,9,1,999.99,"Test sale 1", new Date().toString(), "Fulano", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test1");
    public static final Sale sale_2 = new Sale(2L,9,1,999.99,"Test sale 2", new Date().toString(), "Fulana", "Sucursal 1", "Coahuila", "San Pedro", "Calle San Pedro",2356,27957,"Folio test2");
    public static final Sale sale_3 = new Sale(3L,45,2,999.99,"Test sale 3", new Date().toString(), "Mangana", "Sucursal 2", "Queretaro", "Santiago de", "Calle Queretaro",56,29548,"Folio test 3");

}
