package com.bellmedia.web;

import com.bellmedia.web.db.DataSourceProvider;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;
import org.json.simple.JSONObject;

public class TestServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {


        PrintWriter out = response.getWriter();

        try {
            DataSourceProvider dsp = DataSourceProvider.getInstance();

            Connection con = dsp.getConnection();
            Statement stmt = null;
            String query = "select count(1) total from clients";

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt("total");

                JSONObject obj = new JSONObject();
                obj.put("nbClients", count);

                out.println( obj.toJSONString() );
            }


        } catch (SQLException e) {
            e.printStackTrace();
            out.println( "something bad happened :" + e.getMessage() );
        }


        out.flush();
        out.close();
    }
}
