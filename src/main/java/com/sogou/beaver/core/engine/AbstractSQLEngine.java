package com.sogou.beaver.core.engine;

import com.sogou.beaver.core.collector.OutputCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Tao Li on 2016/6/6.
 */
public abstract class AbstractSQLEngine implements SQLEngine {
  private final Logger LOG = LoggerFactory.getLogger(AbstractSQLEngine.class);

  @Override
  public boolean execute(String sql) throws SQLException {
    try (OutputCollector collector = getOutputCollector()) {
      return doExecute(sql, collector);
    } catch (IOException e) {
      throw new SQLException("Failed to init output collector", e);
    }
  }

  public abstract boolean doExecute(String sql, OutputCollector collector) throws SQLException;

  public abstract OutputCollector getOutputCollector() throws IOException;
}
