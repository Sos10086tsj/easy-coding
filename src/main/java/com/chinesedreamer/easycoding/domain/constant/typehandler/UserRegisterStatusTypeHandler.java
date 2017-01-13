package com.chinesedreamer.easycoding.domain.constant.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.chinesedreamer.easycoding.domain.constant.UserRegisterStatus;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 13, 2017
**/
public class UserRegisterStatusTypeHandler extends BaseTypeHandler<UserRegisterStatus>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, UserRegisterStatus parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getStatus());
	}

	@Override
	public UserRegisterStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
		return UserRegisterStatus.get(rs.getInt(columnName));
	}

	@Override
	public UserRegisterStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		return UserRegisterStatus.get(rs.getInt(columnIndex));
	}

	@Override
	public UserRegisterStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		return UserRegisterStatus.get(cs.getInt(columnIndex));
	}

}
