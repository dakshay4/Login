package com.jwt.login;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

public class HibernateQueryIterator {
	Query qry; List l=qry.list();Iterator it=l.iterator();
}
