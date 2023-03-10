package com.sample.employees.security;

import com.sample.employees.entity.Department;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

import javax.annotation.Nonnull;

@Nonnull
@ResourceRole(name = "Access to department", code = "access-to-department")
public interface AccessToDepartmentRole {
    @EntityAttributePolicy(entityClass = Department.class, attributes = "notes", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Department.class, attributes = {"id", "name", "internalPhoneNumber"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Department.class, actions = EntityPolicyAction.READ)
    void department();

    @MenuPolicy(menuIds = "Department.browse")
    @ScreenPolicy(screenIds = {"Department.browse", "Department.edit"})
    void screens();
}