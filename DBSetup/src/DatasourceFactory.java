import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DatasourceFactory {
    public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
            fis = new FileInputStream("./config/db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("db.url"));
            mysqlDS.setUser(props.getProperty("db.username"));
            mysqlDS.setPassword(props.getProperty("db.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mysqlDS;
    }
}