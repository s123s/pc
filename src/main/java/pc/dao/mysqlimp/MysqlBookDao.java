package pc.dao.mysqlimp;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import pc.dao.BookDao;
//import pc.model.Book;

public class MysqlBookDao {
//	implements BookDao {
//}
//	private static final String ID 		= "id";
//	private static final String NAME 	= "name";
//	private static final String ISDN 	= "isdn";
//	private static final String AUTOR_ID = "autor_id";
//	private static final String SELECT_BOOKS = "select * from book where deleted != 1";
//
//    private JdbcTemplate jdbcTemplate;
//
//    public void setDataSource(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//	@Override
//	public List<Book> readAll()  {
//		List<Book> books = this.jdbcTemplate.query(
//				SELECT_BOOKS,
//		        new RowMapper<Book>() {
//		            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
//		                Book book = new Book();
//		                book.setId(rs.getInt(ID));
//		                book.setName(rs.getString(NAME));
//		                book.setIsdn(rs.getString(ISDN));
//		                book.setAutorId(rs.getInt(AUTOR_ID));
//		                return book;
//		            }
//		        });
//		/*try (PreparedStatement preStat = conn
//				.prepareStatement(SELECT_BOOKS);
//				ResultSet res = preStat.executeQuery();) {
//
//			while (res.next()) {
//				Book b = new Book();
//				
//				b.setId(res.getInt(ID));
//				b.setName(res.getString(NAME));
//				b.setIsdn(res.getString(ISDN));
//				b.setAutor_id(res.getInt(AUTOR_ID));
//				books.add(b);
//
//			}
//		} catch (SQLException ex) {
//			throw new DaoException("Throw in MysqlBookDao.readAll()", ex);
//		}*/
//		return books;
//	}

}
