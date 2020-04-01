package des.springprueba.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.springprueba.entity.Email;

@Repository
@Component("EmailDao")
public class EmailDaoImpl extends GenericDaoImpl<Email> implements EmailDao{

}
