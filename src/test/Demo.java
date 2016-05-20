package test;

import java.util.List;

import entity.QueryEntity;
import service.QueryService;
import serviceImpl.QueryServiceImpl;

public class Demo {

	public static void main(String[] args) {
		QueryService queryService = new QueryServiceImpl();
		String l = "-21474830480";
		Long l1 = Long.parseLong(l);
		/*
		 * eryEntity q = new QueryEntity(); q.setQueryName("First Query");
		 * queryService.addQuery(l1, q);
		 */

		List<QueryEntity> a = queryService.getQueryByColumnId(l1);
		for (QueryEntity q : a) {
			System.out.println(q.getQueryId());
		}
	}
}