document.addEventListener('DOMContentLoaded', function () {
    const miniButtons = document.querySelectorAll('.mini-btn, .form-mockup button');
    miniButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            alert('목업 화면입니다. 실제 저장/처리는 JDBC + Servlet + Oracle 연동 단계에서 구현하면 됩니다.');
        });
    });
});
