package api.sales.controllers;

import ConnectionDB.ConnDBH2;
import api.sales.jms.JmsSender;

import api.sales.services.IServiceSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.sales.models.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class SaleController {   
    
    @Autowired
    private JmsSender jmsSender; // componente para enviar json por JMS

    @Autowired
    private IServiceSale serviceSaleImplement;
    
    // Instancias la clase que hemos creado anteriormente
    private static final ConnDBH2 SQL = new ConnDBH2();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private static Connection conn;
    // Query que usarás para hacer lo que necesites
    private static String sSQL = "";
    //ResultSet, devuelve el resultado del un query (SELECT)
    private ResultSet rs;

    @PostMapping("/crear")//change name
    @ResponseStatus(HttpStatus.CREATED)
    public Sale create(@RequestBody Sale sale) throws SQLException {
        
        System.out.println("venta creada"+ sale.toString());

        //consulta a la base de datos para obtener los datos de la sucursal 
        conn = SQL.connectionDbH2();
        sSQL = "SELECT city,name,number,state,street,zip_code FROM BRANCH_OFFICE where id_branch_office = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sSQL);
        preparedStatement.setLong(1, sale.getId_branch_office());
        rs = preparedStatement.executeQuery();

        if(rs.next()){
            
            sale.setCity_branch_office(rs.getString("city"));
            sale.setName_branch_office(rs.getString("name"));
            sale.setState_branch_office(rs.getString("state"));
            sale.setStreet_branch_office(rs.getString("street"));
            sale.setNumber_branch_office(rs.getInt("number"));
            sale.setZip_code_branch_office(rs.getInt("zip_code"));

        }

        jmsSender.sendMsg(sale.toString());
        return serviceSaleImplement.save(sale);	
    }

    @GetMapping("/listar") // change name
    public Iterable<Sale> mostrar() { // Iterable. colección de elementos que se puede recorrer

        return serviceSaleImplement.findAll();

    }

}
