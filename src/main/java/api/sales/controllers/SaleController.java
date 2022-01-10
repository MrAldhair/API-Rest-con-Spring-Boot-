package api.sales.controllers;

import ConnectionDB.ConnDBH2;
import api.sales.jms.JmsSender;

import api.sales.services.IServiceSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.sales.models.Sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SaleController {   
    
    @Autowired
    private JmsSender jmsSender; // componente para enviar json por JMS

    @Qualifier("IServiceSale")
    @Autowired
    private IServiceSale serviceSale;
    
    // Instancias la clase que hemos creado anteriormente
    private static final ConnDBH2 SQL = new ConnDBH2();
    // Llamas al método que tiene la clase y te devuelve una conexión
    private static Connection conn;
    // Query que usarás para hacer lo que necesites
    private static String sSQL = "";
    //ResultSet, devuelve el resultado del un query (SELECT)
    private ResultSet rs;

    /*@PostMapping("/crear")//change name
    @ResponseStatus(HttpStatus.CREATED) //Retorna el estatus de la peticion POST
    public ResponseEntity<?> create(@RequestBody Sale sale) throws SQLException {
        Sale saleNew = null;
        /*
        System.out.println("venta creada"+ sale.toString());


        Map<String, Object> response = new HashMap<>();

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
        return serviceSale.save(sale);*/
        //return ResponseEntity<Sale>(saleNew, HttpStatus.OK);
    //}

    @GetMapping("/listar")
    public Iterable<Sale> mostrar() { // Iterable. colección de elementos que se puede recorrer
        return serviceSale.findAll();
    }

    @GetMapping("/listar/{id}")
    //Puede retornar cualquier tipo de objeto (venta, msj, exception, etc)
    public ResponseEntity<?> mostrarPorId(@PathVariable Long id) { // Iterable. colección de elementos que se puede recorrer

        //Manejo de excepciones
        Sale sale = null;
        Map<String, Object> response = new HashMap<>();

        try {
            sale = serviceSale.findById(id);
        } catch (DataAccessException e){
            response.put("msg","Error en al consulta de la DB");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        //Alamacenar los objetos/valores asociados a un nombre
        //Map(interfaz)/HashMap(implementacion)
        if (sale == null) {
            response.put("msg","La venta: ".concat(id.toString().concat(" no existe!!")));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Sale>(sale, HttpStatus.OK);
    }

}
