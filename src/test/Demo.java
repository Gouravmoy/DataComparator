package test;

import entity.QueryEntity;
import service.QueryService;
import serviceImpl.QueryServiceImpl;

public class Demo {

	public static void main(String[] args) {
		QueryService queryService = new QueryServiceImpl();
		queryService.addQuery((long) 4, "");
		QueryEntity q = queryService.getQueryByID((long) 1);
		System.out.println(q);
		q.setParamNames("ABCDEFG");
		QueryEntity q1 = queryService.updateQueryEntity((long) 1, q);
		System.out.println(q1);
	}
}