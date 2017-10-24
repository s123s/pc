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
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceUtils;

public class FlatXmlDateGenerate {
	private static final String DB_TABLES_DATA_FULL_FILE_DTD = "../.db/tables_data_full.dtd";
	private static final String DB_TABLES_DATA_FULL_FILE_XML = "../.db/tables_data_full.xml";
	/*private static final String TABLES_DATA_FILE_XML = "../.db/tables_data.xml";
	private static final String JDBC_PASSWORD = "jdbc.password";
	private static final String JDBC_USERNAME = "jdbc.username";*/
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

/*		// загружаем драйвер для работы с mysql
		Class.forName("com.mysql.jdbc.Driver");*/

		// получаем подключение к серверу СУБД
		FileSystemXmlApplicationContext ctx = new  FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");
		DataSource ds = (DataSource)ctx.getBean("dataSource");
		Connection conn = DataSourceUtils.getConnection(ds);
		/*Connection conn = 
		//		 ctx represents a spring context
				DriverManager.getConnection(
				"jdbc:mysql://localhost/pc?useUnicode=true&characterSet=UTF-8",
				prop.getProperty(JDBC_USERNAME),
				prop.getProperty(JDBC_PASSWORD));*/
				
		
		SessionFactoryImplementor sessionFactory = (SessionFactoryImplementor)ctx.getBean("sessionFactory");
		String schema = (String) sessionFactory.getProperties().get("hibernate.default_schema");
		
		//Фиксим баг у DBUnit: 1. Показываем DBUnit схему. 2. Указываем, что регистр не нужно учитывать 
		IDatabaseConnection iConnection = new DatabaseConnection(conn, schema);
		DatabaseConfig config = iConnection.getConfig();
		config.setFeature(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, true);
		
		/*IDatabaseConnection iConnection = new DatabaseConnection(conn);*/

		// экспортируем часть базы данных
		QueryDataSet partialDataSet = new QueryDataSet(iConnection);

		// экспорт таблицы, но не всей, а только определенных записей
		// partialDataSet.addTable("user", "SELECT * FROM user");

/*		// экспорт всей таблицы
		partialDataSet.addTable("add_sockets");
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
				TABLES_DATA_FILE_XML));
*/
        // write DTD file
        FlatDtdDataSet.write(iConnection.createDataSet(), new FileOutputStream(DB_TABLES_DATA_FULL_FILE_DTD));
		
		// экспорт всей базы данных полностью
		IDataSet fullDataSet = iConnection.createDataSet();
		FlatXmlDataSet.write(fullDataSet, new FileOutputStream(DB_TABLES_DATA_FULL_FILE_XML));

	}
}
