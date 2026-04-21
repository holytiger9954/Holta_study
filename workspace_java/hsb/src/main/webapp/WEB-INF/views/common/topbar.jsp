<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section class="global-topbar">
    <div class="global-box">
        <div class="global-title"><%= request.getAttribute("pageTitle") == null ? "대시보드" : request.getAttribute("pageTitle") %></div>
        <div class="global-sub"><%= request.getAttribute("pageSubTitle") == null ? "운영 현황을 한 눈에 확인하는 화면입니다." : request.getAttribute("pageSubTitle") %></div>
    </div>
    <div class="global-clock">
        <div class="value" id="liveCalendar"></div>
        <div class="value" id="liveClock"></div>
    </div>
</section>
