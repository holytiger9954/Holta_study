package com.beginagain.mes.common.demo;

import java.util.*;

public class DemoDataFactory {
    private DemoDataFactory() {}

    public static Map<String, Object> dashboard() {
        Map<String, Object> m = new HashMap<>();
        m.put("todayPlanCount", 12);
        m.put("inProgressWorkOrderCount", 5);
        m.put("todayResultCount", 8);
        m.put("totalGoodQty", 12450.0);
        m.put("totalDefectQty", 185.0);
        m.put("activeEquipmentCount", 9);

        List<Map<String,Object>> recent = new ArrayList<>();
        recent.add(result(101, 5001, "FG-CAM-002", "NCM 양극재 6계열", "2026-04-12", 1200, 20, "DONE"));
        recent.add(result(102, 5002, "FG-CAM-003", "NCM 양극재 8계열", "2026-04-12", 980, 15, "IN_PROGRESS"));
        recent.add(result(103, 5003, "FG-CAM-002", "NCM 양극재 6계열", "2026-04-11", 1100, 10, "DONE"));
        recent.add(result(104, 5004, "FG-LFP-001", "LFP 양극재", "2026-04-11", 860, 12, "DONE"));
        recent.add(result(105, 5005, "FG-CAM-004", "하이니켈 양극재", "2026-04-10", 760, 8, "READY"));
        m.put("recentResultList", recent);

        List<Map<String,Object>> status = new ArrayList<>();
        status.add(status("READY", 4));
        status.add(status("IN_PROGRESS", 5));
        status.add(status("DONE", 11));
        status.add(status("CANCELLED", 1));
        m.put("workOrderStatusList", status);
        return m;
    }

    private static Map<String,Object> result(int resultId, int workOrderId, String itemCode, String itemName, String resultDate, double goodQty, double defectQty, String status){
        Map<String,Object> m = new HashMap<>();
        m.put("resultId", resultId);
        m.put("workOrderId", workOrderId);
        m.put("itemCode", itemCode);
        m.put("itemName", itemName);
        m.put("resultDate", resultDate);
        m.put("goodQty", goodQty);
        m.put("defectQty", defectQty);
        m.put("status", status);
        return m;
    }
    private static Map<String,Object> status(String status, int count){
        Map<String,Object> m = new HashMap<>();
        m.put("status", status);
        m.put("count", count);
        return m;
    }

    public static List<Map<String,Object>> items() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("itemId",1,"itemCode","RM-CO-001","itemName","황산코발트","itemType","원자재","unit","kg","safetyStock",2000,"useYn","Y"));
        list.add(map("itemId",2,"itemCode","RM-NI-001","itemName","황산니켈","itemType","원자재","unit","kg","safetyStock",1500,"useYn","Y"));
        list.add(map("itemId",3,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","itemType","완제품","unit","kg","safetyStock",0,"useYn","Y"));
        return list;
    }
    public static List<Map<String,Object>> equipments() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("equipmentId",1,"equipmentCode","EQ-MIX-001","equipmentName","혼합 설비 1호기","modelName","MR-MIX-110","location","A-01","manufacturer","미래기공","useYn","Y"));
        list.add(map("equipmentId",2,"equipmentCode","EQ-FIRE-001","equipmentName","소성 설비 1호기","modelName","FR-220","location","B-01","manufacturer","한빛테크","useYn","Y"));
        return list;
    }
    public static List<Map<String,Object>> processes() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("processId",1,"processCode","PC-MIX","processName","혼합","useYn","Y"));
        list.add(map("processId",2,"processCode","PC-FIRE","processName","소성","useYn","Y"));
        list.add(map("processId",3,"processCode","PC-PACK","processName","포장","useYn","Y"));
        return list;
    }
    public static List<Map<String,Object>> boms() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("bomId",1,"itemId",3,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","versionNo",1,"useYn","Y","remark","주 생산 배합"));
        return list;
    }
    public static List<Map<String,Object>> bomDetails() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("bomDetailId",1,"bomId",1,"itemId",1,"itemCode","RM-CO-001","itemName","황산코발트","qtyRequired",0.25,"unit","kg"));
        list.add(map("bomDetailId",2,"bomId",1,"itemId",2,"itemCode","RM-NI-001","itemName","황산니켈","qtyRequired",0.65,"unit","kg"));
        return list;
    }
    public static List<Map<String,Object>> routings() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("routingId",1,"itemId",3,"processId",1,"equipmentId",1,"processSeq",1,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","processCode","PC-MIX","processName","혼합","equipmentCode","EQ-MIX-001","equipmentName","혼합 설비 1호기","useYn","Y"));
        list.add(map("routingId",2,"itemId",3,"processId",2,"equipmentId",2,"processSeq",2,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","processCode","PC-FIRE","processName","소성","equipmentCode","EQ-FIRE-001","equipmentName","소성 설비 1호기","useYn","Y"));
        return list;
    }
    public static List<Map<String,Object>> plans() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("planId",1001,"itemId",3,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","planDate","2026-04-12","planQty",1500,"lineCode","LINE-A","status","PLANNED"));
        list.add(map("planId",1002,"itemId",3,"itemCode","FG-CAM-003","itemName","NCM 양극재 8계열","planDate","2026-04-13","planQty",1800,"lineCode","LINE-B","status","IN_PROGRESS"));
        return list;
    }
    public static List<Map<String,Object>> workOrders() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("workOrderId",5001,"planId",1001,"itemId",3,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","startDate","2026-04-12","endDate","2026-04-12","orderQty",1500,"status","IN_PROGRESS"));
        list.add(map("workOrderId",5002,"planId",1002,"itemId",3,"itemCode","FG-CAM-003","itemName","NCM 양극재 8계열","startDate","2026-04-13","endDate","2026-04-13","orderQty",1800,"status","READY"));
        return list;
    }
    public static List<Map<String,Object>> results() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("resultId",101,"workOrderId",5001,"itemId",3,"itemCode","FG-CAM-002","itemName","NCM 양극재 6계열","resultDate","2026-04-12","goodQty",1200,"defectQty",20,"status","DONE"));
        list.add(map("resultId",102,"workOrderId",5002,"itemId",3,"itemCode","FG-CAM-003","itemName","NCM 양극재 8계열","resultDate","2026-04-12","goodQty",980,"defectQty",15,"status","IN_PROGRESS"));
        return list;
    }
    public static List<Map<String,Object>> employees() {
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map("empId",1,"empNo","E25001","empName","백지원","deptCode","PD","positionName","부장","status","재직","roleName","MES 관리자"));
        list.add(map("empId",2,"empNo","E25002","empName","김공정","deptCode","PR","positionName","대리","status","재직","roleName","현장관리자"));
        list.add(map("empId",3,"empNo","E25003","empName","이작업","deptCode","PR","positionName","사원","status","재직","roleName","현장작업자"));
        return list;
    }

    @SafeVarargs
    public static Map<String,Object> map(Object... kv) {
        Map<String,Object> m = new HashMap<>();
        for (int i=0;i<kv.length;i+=2) {
            m.put(String.valueOf(kv[i]), kv[i+1]);
        }
        return m;
    }

    public static Map<String,Object> findById(List<Map<String,Object>> list, String key, int id) {
        for (Map<String,Object> row : list) {
            Object v = row.get(key);
            if (v instanceof Number && ((Number) v).intValue() == id) return row;
        }
        return null;
    }
}
