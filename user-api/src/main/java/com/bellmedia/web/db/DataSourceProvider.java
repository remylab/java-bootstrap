package com.bellmedia.web.db;

import java.sql.*;
import org.apache.commons.dbcp2.*;
import java.io.IOException;

public class DataSourceProvider {

    private static DataSourceProvider datasource;
    private BasicDataSource ds;

    private DataSourceProvider() throws IOException, SQLException {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("test");
        ds.setPassword("testPWD");
        ds.setUrl("jdbc:mysql://localhost/amazoom");

        // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

    }

    public static DataSourceProvider getInstance() throws IOException, SQLException {
        if (datasource == null) {
            datasource = new DataSourceProvider();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
