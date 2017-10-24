package pc.util.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class FlatXmlDateGenerate {
	private static final String JDBC_PASSWORD = "jdbc.password";
	private static final String JDBC_USERNAME = "jdbc.username";
	private static final String JDBC_PROPERTIES_FILE = "jdbc.properties";

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, DatabaseUnitException, FileNotFoundException,
			IOException {

		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		try (InputStream input = loader.getResourceAsStream(JDBC_PROPERTIES_FILE)) {
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// загружаем драйвер для работы с mysql
		Class.forName("com.mysql.jdbc.Driver");

		// получаем подключение к серверу СУБД
/*		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		DataSource ds = (DataSource)ctx.getBean("myDatasourceBean");
		Connection conn = DataSourceUtils.getConnection(ds);		*/		
		
		Connection conn = 
//				 ctx represents a spring context
				DriverManager.getConnection(
				"jdbc:mysql://localhost/pc?useUnicode=true&characterSet=UTF-8",
				prop.getProperty(JDBC_USERNAME),
				prop.getProperty(JDBC_PASSWORD));
		IDatabaseConnection iConnection = new DatabaseConnection(conn);

		// экспортируем часть базы данных
		QueryDataSet partialDataSet = new QueryDataSet(iConnection);

		// экспорт таблицы, но не всей, а только определенных записей
		// partialDataSet.addTable("user", "SELECT * FROM user");

		// экспорт всей таблицы
		partialDataSet.addTable("add_sockets");

		partialDataSet.addTable("autor");
		partialDataSet.addTable("computer");
		partialDataSet.addTable("hdd");
		partialDataSet.addTable("monitor");
		partialDataSet.addTable("mother");
		partialDataSet.addTable("os");
		partialDataSet.addTable("printer");
		partialDataSet.addTable("processor");
		partialDataSet.addTable("producer");
		partialDataSet.addTable("ram");
		partialDataSet.addTable("type_computer");
		partialDataSet.addTable("type_hdd");
		partialDataSet.addTable("type_mother");
		partialDataSet.addTable("type_proc");
		partialDataSet.addTable("type_ram");
		partialDataSet.addTable("type_ram_spec");
		partialDataSet.addTable("ups");
		partialDataSet.addTable("user");
		partialDataSet.addTable("workplace");

		// сохраняем изменения в файл
		FlatXmlDataSet.write(partialDataSet, new FileOutputStream(
				".db/all_tables-dataset.xml"));

		// экспорт всей базы данных полностью
		/*IDataSet fullDataSet = iConnection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream("tables.xml"));*/

	}
}
