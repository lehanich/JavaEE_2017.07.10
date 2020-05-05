package ru.spec.javaee.ejb;

import java.util.List;

import javax.ejb.Remote;

import ru.spec.javaee.entity.CheckList;
import ru.spec.javaee.entity.Option;

@Remote
public interface CheckListServiceRemote {

	List<CheckList> getCheckLists();

	CheckList createCheckList(String name);

	Option createOption(String text, Long checkListId);

	Option createOption(String text, CheckList cl);

}
