package ru.spec.javaee.ejb;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ru.spec.javaee.entity.CheckList;
import ru.spec.javaee.entity.Option;

/**
 * Session Bean implementation class CheckListService
 */
@Stateless(mappedName="CheckListService")
@LocalBean
public class CheckListService implements CheckListServiceRemote {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<CheckList> getCheckLists(/*Long id*/) {
		List<CheckList> resultList = em.createQuery("SELECT cl FROM CheckList cl "
				+ ""
//				+ "WHERE cl.id = :cl_ID "
				+ ""
				+ "", CheckList.class)
			.setFirstResult(0)
			.setMaxResults(10)
//			.setParameter("cl_ID", id)
			.getResultList();
		
		return resultList;
	}
   
	@Override
	public CheckList createCheckList(String name) {
		CheckList item = new CheckList();
		item.setText(name);
//		System.out.println(item);
		em.persist(item);
//		em.flush();
//		System.out.println(item.getId());
		
//		throw new RuntimeException("test rollBack");
		
		return item;
	}
	
	@Override
	public Option createOption(String text, Long checkListId) {
		
		CheckList cl = em.find(CheckList.class, checkListId);
		
		return createOption(text, cl);
	}

	@Override
	public Option createOption(String text, CheckList cl) {
		Option option = new Option();
		option.setText(text);
//		cl.addOption(option);
		option.setCheckList(cl);
		em.persist(option);
		
		
		createOptions(7L,"123","asd","asd","asxcv");
		return option;
	}
	
	public List<Option> createOptions(Long cl, String...text ) {
		return null;
	}

}
