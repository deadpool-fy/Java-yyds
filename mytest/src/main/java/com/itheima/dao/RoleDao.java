package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    int save(Role role);

    int delete(Role role);

    int update(Role role);

    Role findById(String id);

    List<Role> findAll();

    void deleteRolePermission(String roleId);

    void saveRolePermission(@Param("roleId") String roleId, @Param("permissionId") String moduleId);
}
