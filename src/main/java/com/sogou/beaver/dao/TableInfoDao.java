package com.sogou.beaver.dao;

import com.sogou.beaver.Config;
import com.sogou.beaver.db.ConnectionPoolException;
import com.sogou.beaver.model.TableInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tao Li on 6/11/16.
 */
public class TableInfoDao {
  private final static String TABLE_NAME = "dw_tables";

  private List<TableInfo> getTableInfos(String whereClause)
      throws ConnectionPoolException, SQLException {
    String sql = String.format("SELECT * FROM %s %s", TABLE_NAME, whereClause);
    Connection conn = Config.POOL.getConnection();
    try {
      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = stmt.executeQuery()) {
          List<TableInfo> tableInfos = new ArrayList<>();
          while (rs.next()) {
            tableInfos.add(new TableInfo(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("frequency")
            ));
          }
          return tableInfos;
        }
      }
    } finally {
      Config.POOL.releaseConnection(conn);
    }
  }

  private TableInfo getTableInfo(String whereClause) throws ConnectionPoolException, SQLException {
    List<TableInfo> tableInfos = getTableInfos(whereClause);
    return tableInfos.size() == 0 ? null : tableInfos.get(0);
  }

  public List<TableInfo> getAllTableInfos() throws ConnectionPoolException, SQLException {
    return getTableInfos("");
  }

  public TableInfo getTableInfoByName(String name) throws ConnectionPoolException, SQLException {
    return getTableInfo(String.format("WHERE name='%s'", name));
  }
}
