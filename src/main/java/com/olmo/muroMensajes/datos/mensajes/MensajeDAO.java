package com.olmo.muroMensajes.datos.mensajes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/*el crud repository necesita saber el tipo de dato 
 * con el que va a trabajar "Mensaje" y el id de este "Long" */

@Repository
public interface MensajeDAO extends CrudRepository<Mensaje, Long> {

}
