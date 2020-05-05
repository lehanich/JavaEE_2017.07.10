package ru.spec.java.ee;

import java.util.Date;
import java.util.concurrent.Future;

import javax.ejb.Remote;
@Remote
public interface DateService {

	Date getDate();

	Future<Long> increment();

}