package com.pbs.ams.common.base;

import com.pbs.ams.common.db.DataSourceEnum;
import com.pbs.ams.common.db.DynamicDataSource;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 实现BaseService抽象类
 * Created by ams on 2017/01/07.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl< Record, Example> implements BaseService<Record, Example> {


	@Override
	public long countByExample(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method countByExample =  getMapper().getClass().getDeclaredMethod("countByExample", example.getClass());
			Object result = countByExample.invoke( getMapper(), example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int deleteByExample(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method deleteByExample =  getMapper().getClass().getDeclaredMethod("deleteByExample", example.getClass());
			Object result = deleteByExample.invoke( getMapper(), example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Class x = id.getClass();
			Method deleteByPrimaryKey =  getMapper().getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
			Object result = deleteByPrimaryKey.invoke( getMapper(), id);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int insert(Record record) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method insert =  getMapper().getClass().getDeclaredMethod("insert", record.getClass());
			Object result = insert.invoke( getMapper(), record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int insertSelective(Record record) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method insertSelective =  getMapper().getClass().getDeclaredMethod("insertSelective", record.getClass());
			Object result = insertSelective.invoke( getMapper(), record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public List<Record> selectByExampleWithBLOBs(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method selectByExampleWithBLOBs =  getMapper().getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			Object result = selectByExampleWithBLOBs.invoke( getMapper(), example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return null;
	}

	@Override
	public List<Record> selectByExample(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method selectByExample = getMapper().getClass().getDeclaredMethod("selectByExample", example.getClass());
			Object result = selectByExample.invoke( getMapper(), example);
			return (List<Record>) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return null;
	}

	@Override
	public Record selectFirstByExample(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method selectByExample =  getMapper().getClass().getDeclaredMethod("selectByExample", example.getClass());
			List<Record> result = (List<Record>) selectByExample.invoke( getMapper(), example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return null;
	}

	@Override
	public Record selectFirstByExampleWithBLOBs(Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method selectByExampleWithBLOBs =  getMapper().getClass().getDeclaredMethod("selectByExampleWithBLOBs", example.getClass());
			List<Record> result = (List<Record>) selectByExampleWithBLOBs.invoke( getMapper(), example);
			if (null != result && result.size() > 0) {
				return result.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return null;
	}

	@Override
	public Record selectByPrimaryKey(Long id) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
			Method selectByPrimaryKey =  getMapper().getClass().getDeclaredMethod("selectByPrimaryKey", id.getClass());
			Object result = selectByPrimaryKey.invoke( getMapper(), id);
			return (Record) result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return null;
	}

	@Override
	public int updateByExampleSelective(@Param("record") Record record, @Param("example") Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByExampleSelective =  getMapper().getClass().getDeclaredMethod("updateByExampleSelective", record.getClass(), example.getClass());
			Object result = updateByExampleSelective.invoke( getMapper(), record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByExampleWithBLOBs =  getMapper().getClass().getDeclaredMethod("updateByExampleWithBLOBs", record.getClass(), example.getClass());
			Object result = updateByExampleWithBLOBs.invoke( getMapper(), record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int updateByExample(@Param("record") Record record, @Param("example") Example example) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByExample =  getMapper().getClass().getDeclaredMethod("updateByExample", record.getClass(), example.getClass());
			Object result = updateByExample.invoke( getMapper(), record, example);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(Record record) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByPrimaryKeySelective =  getMapper().getClass().getDeclaredMethod("updateByPrimaryKeySelective", record.getClass());
			Object result = updateByPrimaryKeySelective.invoke( getMapper(), record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(Record record) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByPrimaryKeyWithBLOBs =  getMapper().getClass().getDeclaredMethod("updateByPrimaryKeyWithBLOBs", record.getClass());
			Object result = updateByPrimaryKeyWithBLOBs.invoke( getMapper(), record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Record record) {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method updateByPrimaryKey =  getMapper().getClass().getDeclaredMethod("updateByPrimaryKey", record.getClass());
			Object result = updateByPrimaryKey.invoke( getMapper(), record);
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

	@Override
	public int deleteByPrimaryKeys(String ids) {

		try {
			if (StringUtils.isBlank(ids)) {
				return 0;
			}
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			String[] idArray = ids.split("-");
			int count = 0;
			for (String idStr : idArray) {
				if (StringUtils.isBlank(idStr)) {
					continue;
				}
				Long id = Long.parseLong(idStr);
				Method deleteByPrimaryKey =  getMapper().getClass().getDeclaredMethod("deleteByPrimaryKey", id.getClass());
				Object result = deleteByPrimaryKey.invoke( getMapper(), id);
				count += Integer.parseInt(String.valueOf(result));
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}


	/**
	 * MANDATORY:该方法只能在一个已存在的事务中执行.
	 * @return
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public int insertToSnaps() {
		try {
			DynamicDataSource.setDataSource(DataSourceEnum.MASTER.getName());
			Method insertSelective =  getMapper().getClass().getDeclaredMethod("insertSnaps");
			Object result = insertSelective.invoke( getMapper());
			return Integer.parseInt(String.valueOf(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		DynamicDataSource.clearDataSource();
		return 0;
	}

}
