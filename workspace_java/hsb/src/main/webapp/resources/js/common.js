(function () {
  function tick() {
    var now = new Date();
    var dateText = now.getFullYear() + '-' +
      String(now.getMonth() + 1).padStart(2, '0') + '-' +
      String(now.getDate()).padStart(2, '0');
    var timeText = String(now.getHours()).padStart(2, '0') + ':' +
      String(now.getMinutes()).padStart(2, '0') + ':' +
      String(now.getSeconds()).padStart(2, '0');
    var c = document.getElementById('liveCalendar');
    var t = document.getElementById('liveClock');
    if (c) c.textContent = dateText;
    if (t) t.textContent = timeText;
  }
  tick();
  setInterval(tick, 1000);
})();
