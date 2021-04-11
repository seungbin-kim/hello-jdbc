package io.wisoft.seminar;

import java.sql.*;

public class Application {

  public static void main(final String... args) {
    try {
      Connection conn = DriverManager.getConnection
          ("jdbc:postgresql://localhost:5432/exercise", "postgres", "local");

      Statement stmt;
      stmt = conn.createStatement();

      ResultSet rs;
      rs = stmt.executeQuery("SELECT * FROM STUDENT"); // 아래꺼와 이것중 하나 사용. 실행은 2가지 방법이 있다.

//      if (stmt.execute("SELECT * FROM STUDENT")) {
//        rs = stmt.getResultSet();
//      }

      while (rs.next()) {
        System.out.print("[학번] " + rs.getString(1) + " || ");
        System.out.print("[이름] " + rs.getString(2) + " || ");
        System.out.println("[생일] " + rs.getString(3));
      }

      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException sqex) {
      System.out.println("SQLException: " + sqex.getMessage());
      System.out.println("SQLState: " + sqex.getSQLState());
    }
  }

}

