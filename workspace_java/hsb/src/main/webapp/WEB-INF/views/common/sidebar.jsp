<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beginagain.mes.emp.model.dto.EmpDto" %>
<%
    EmpDto loginUser = (EmpDto) session.getAttribute("loginUser");
    String roleName = loginUser == null ? "" : loginUser.getRoleName();
    boolean isAdmin = "MES 관리자".equals(roleName);
    boolean isManager = "현장관리자".equals(roleName);
    boolean isAdminOrManager = isAdmin || isManager;
%>
<aside class="sidebar">
    <div class="sidebar-top">
        <button id="menuToggle" type="button">☰</button>
        <div class="brand">
            <span class="brand-logo"></span>
            <div>
                <div class="brand-title">Begin Again MES</div>
                <div class="brand-sub">2차전지 양극재 분체 가공</div>
            </div>
        </div>

        <div class="profile-card">
            <div class="profile-icon">
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <circle cx="12" cy="8" r="4"></circle>
                    <path d="M4 20c0-4 4-6 8-6s8 2 8 6"></path>
                </svg>
            </div>
            <div class="profile-text">
                <div class="name"><%= loginUser == null ? "게스트" : loginUser.getEmpName() %></div>
                <div class="role"><%= loginUser == null ? "권한 없음" : loginUser.getRoleName() %></div>
            </div>
        </div>

        <nav class="sidebar-nav">
            <button class="nav-home active" type="button" onclick="location.href='${pageContext.request.contextPath}/dashboard'">대시보드</button>

            <div class="menu-group">
                <button class="menu-title" type="button">기준정보</button>
                <div class="menu-items">
                    <% if (isAdminOrManager) { %>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/item/list'">품목 관리</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/process/list'">공정 관리</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/equipment/list'">설비 관리</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/bom/list'">BOM 관리</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/routing/list'">Routing 관리</button>
                    <% } %>
                </div>
            </div>

            <div class="menu-group">
                <button class="menu-title" type="button">업무관리</button>
                <div class="menu-items">
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/plan/list'">생산계획</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/workOrder/list'">작업지시</button>
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/result/list'">생산실적</button>
                </div>
            </div>

            <% if (isAdmin) { %>
            <div class="menu-group">
                <button class="menu-title" type="button">관리</button>
                <div class="menu-items">
                    <button type="button" onclick="location.href='${pageContext.request.contextPath}/emp/list'">직원 관리</button>
                </div>
            </div>
            <% } %>
        </nav>
    </div>

    <div class="sidebar-bottom">
        <button id="logoutBtn" class="btn-primary logoutBtn" type="button"
            onclick="location.href='${pageContext.request.contextPath}/logout'">로그아웃</button>
    </div>
</aside>
