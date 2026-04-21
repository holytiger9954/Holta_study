window.addEventListener('load', init);

function init() {
    const pageMainTitle = document.getElementById('pageMainTitle');
    const pageSubTitle = document.getElementById('pageSubTitle');
    const navHome = document.querySelector('.nav-home');
    const menuTitles = document.querySelectorAll('.menu-title');
    const pageSections = document.querySelectorAll('.page-section');
    const submenuButtons = document.querySelectorAll('.menu-items button');
    const profileModal = document.getElementById('profileModal');
    const openProfileBtn = document.getElementById('openProfileBtn');
    const closeProfileBtn = document.getElementById('closeProfileBtn');
    const toast = document.getElementById('toast');
    const liveCalendar = document.getElementById('liveCalendar');
    const liveClock = document.getElementById('liveClock');
    const menuToggle = document.getElementById('menuToggle');

    function updateClock() {
        const now = new Date();
        const y = now.getFullYear();
        const m = String(now.getMonth() + 1).padStart(2, '0');
        const d = String(now.getDate()).padStart(2, '0');
        const h = String(now.getHours()).padStart(2, '0');
        const mi = String(now.getMinutes()).padStart(2, '0');
        const s = String(now.getSeconds()).padStart(2, '0');
        const week = ['일', '월', '화', '수', '목', '금', '토'];
        const w = week[now.getDay()];
        if (liveCalendar) liveCalendar.textContent = `${y}-${m}-${d} ${w}요일`;
        if (liveClock) liveClock.textContent = `${h} : ${mi} : ${s}`;
    }
    updateClock();
    setInterval(updateClock, 1000);

    if (menuToggle) {
        menuToggle.addEventListener('click', () => {
            document.querySelector('.sidebar').classList.toggle('open');
        });
    }

    let toastTimer = null;
    function showToast(message) {
        if (!toast) return;
        toast.textContent = message;
        toast.classList.add('show');
        clearTimeout(toastTimer);
        toastTimer = setTimeout(() => toast.classList.remove('show'), 1800);
    }

    function activatePage(pageKey) {
        pageSections.forEach(section => section.classList.remove('active'));
        const target = document.getElementById(`page-${pageKey}`);
        if (!target) return;
        target.classList.add('active');
        if (pageMainTitle) pageMainTitle.textContent = target.dataset.title || 'Begin Again MES';
        if (pageSubTitle) pageSubTitle.textContent = target.dataset.subtitle || '';
        if (navHome) navHome.classList.toggle('active', pageKey === 'dashboard');
        submenuButtons.forEach(button => button.classList.toggle('active', button.dataset.page === pageKey));
        showToast(`${target.dataset.title} 화면으로 이동했습니다.`);
    }

    if (navHome) navHome.addEventListener('click', () => activatePage('dashboard'));
    submenuButtons.forEach(button => button.addEventListener('click', () => activatePage(button.dataset.page)));
    menuTitles.forEach(titleBtn => {
        titleBtn.addEventListener('click', () => {
            titleBtn.classList.toggle('open');
            const menuItems = titleBtn.nextElementSibling;
            if (menuItems) menuItems.classList.toggle('open');
        });
    });

    if (openProfileBtn && profileModal) {
        openProfileBtn.addEventListener('click', () => profileModal.classList.remove('hidden'));
    }
    if (closeProfileBtn && profileModal) {
        closeProfileBtn.addEventListener('click', () => profileModal.classList.add('hidden'));
    }

    document.querySelectorAll('.open-modal-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.dataset.modalTarget;
            const modal = document.getElementById(id);
            if (modal) modal.classList.remove('hidden');
        });
    });

    document.querySelectorAll('.close-modal-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            const modal = btn.closest('.modal-backdrop');
            if (modal) modal.classList.add('hidden');
        });
    });

    document.querySelectorAll('.modal-backdrop').forEach(modal => {
        modal.addEventListener('click', (event) => {
            if (event.target === modal) modal.classList.add('hidden');
        });
    });

    const logoutBtn = document.getElementById('logoutBtn');
    if (logoutBtn) {
        logoutBtn.addEventListener('click', () => {
            showToast('로그아웃되었습니다.');
            setTimeout(() => window.location.reload(), 500);
        });
    }
}
