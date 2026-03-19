package dao;

import java.util.Set;

import pojos.RoleEntity;
import pojos.RoleEnum;

public interface IRoleDao {
	String addRole(RoleEntity role);

	Set<RoleEntity> getRolesByRoleName(Set<RoleEnum> roles);

}
