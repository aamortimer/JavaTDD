import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    private DataSource dataSource = DatasourceFactory.getMySQLDataSource();
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Before
    public void prepare() throws Exception {
        Operation operation =
                sequenceOf(
                        CommonOperations.DELETE_ALL,
                        CommonOperations.INSERT_REFERENCE_DATA,
                        insertInto("Employees")
                                .columns("id", "firstName", "lastName")
                                .values(3, "Andy", "Test")
                                .build());
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
        dbSetup.launch();

        DataSource ds = DatasourceFactory.getMySQLDataSource();
        con = ds.getConnection();
    }

    @Test
    public void testThatEmployeeExists() {
        try {
            pstmt = con.prepareStatement("SELECT id, firstName from Employees WHERE id = ?");
            pstmt.setInt(1,1);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String firstName = rs.getString("firstName");
                assertEquals("Jon", firstName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(rs != null) {
                    rs.close();
                }
                if(pstmt != null) {
                    pstmt.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
