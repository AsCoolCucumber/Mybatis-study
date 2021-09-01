package com.lhs.dao.role;

import com.lhs.pojo.Role;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {
	@Select("select * from smbms_role")
	public List<Role> getRoleList() throws Exception;

}
