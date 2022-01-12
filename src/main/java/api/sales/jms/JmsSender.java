/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.sales.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.github.underscore.lodash.U;

@Component
public class JmsSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMsg(String msg){
        this.jmsTemplate.send("sales-out",new MessageCreator(){

            @Override //crea una sesion en cola
            public Message createMessage(Session session) throws JMSException {
                
                return session.createTextMessage(msg);
                
            }
            
        });
        
        System.out.println("venta enviada a spring camel" + msg);
        
    }
  
}
