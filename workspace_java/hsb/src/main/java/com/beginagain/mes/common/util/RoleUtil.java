package com.beginagain.mes.common.util;

import com.beginagain.mes.common.consts.RoleConst;
import com.beginagain.mes.emp.model.dto.EmpDto;

public class RoleUtil {
    private RoleUtil() {}

    public static boolean isAdmin(EmpDto loginUser) {
        return loginUser != null && RoleConst.ADMIN.equals(loginUser.getRoleName());
    }
    public static boolean isManager(EmpDto loginUser) {
        return loginUser != null && RoleConst.MANAGER.equals(loginUser.getRoleName());
    }
    public static boolean isWorker(EmpDto loginUser) {
        return loginUser != null && RoleConst.WORKER.equals(loginUser.getRoleName());
    }
    public static boolean isAdminOrManager(EmpDto loginUser) {
        return isAdmin(loginUser) || isManager(loginUser);
    }
    public static boolean isAnyUser(EmpDto loginUser) {
        return loginUser != null;
    }
}
