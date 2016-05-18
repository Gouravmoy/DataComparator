package test;

import dao.GenericDAO;
import daoImpl.GenericDAOImpl;
import entity.ColumnMeta;
import entity.DBTypes;
import entity.DataBase_CompositeID;
import entity.Database;

public class Demo {

	public static void main(String[] args) {
		Database db = new Database(new DataBase_CompositeID("DBNAME", 17),
				"sName", "U", "P", "P", DBTypes.MYSQL);

		GenericDAO<Database, Long> dao = new GenericDAOImpl<Database, Long>();
		dao.save(db);
		dao.readAll(Database.class);

		ColumnMeta columnMeta = new ColumnMeta();
		columnMeta.setColNames("C");
		columnMeta.setSeparator("|");
		GenericDAO<ColumnMeta, Long> dao1 = new GenericDAOImpl<ColumnMeta, Long>();
		dao1.save(columnMeta);

	}

}
