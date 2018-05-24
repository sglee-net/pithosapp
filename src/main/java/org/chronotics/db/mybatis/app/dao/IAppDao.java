package org.chronotics.db.mybatis.app.dao;

import java.util.List;

public interface IAppDao {
	List<Float> getNumbers(String name) throws Exception;
}
