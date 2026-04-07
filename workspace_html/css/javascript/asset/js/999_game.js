const canvas = document.getElementById('gameCanvas');
const ctx = canvas.getContext('2d');

const gravity = 0.7;

// 캐릭터 클래스 생성
class Sprite {
    constructor({ position, velocity, color, offset }) {
        this.position = position;
        this.velocity = velocity;
        this.width = 50;
        this.height = 150;
        this.color = color;
        this.health = 100;
        this.isAttacking = false;
        this.attackBox = {
            position: { x: this.position.x, y: this.position.y },
            offset: offset,
            width: 100,
            height: 50
        };
    }

    draw() {
        // 캐릭터 그리기
        ctx.fillStyle = this.color;
        ctx.fillRect(this.position.x, this.position.y, this.width, this.height);

        // 공격 범위 그리기 (공격 중일 때만)
        if (this.isAttacking) {
            ctx.fillStyle = 'white';
            ctx.fillRect(this.attackBox.position.x, this.attackBox.position.y, this.attackBox.width, this.attackBox.height);
        }
    }

    update() {
        this.draw();
        this.attackBox.position.x = this.position.x + this.attackBox.offset.x;
        this.attackBox.position.y = this.position.y;

        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;

        // 중력 및 바닥 충돌
        if (this.position.y + this.height + this.velocity.y >= canvas.height) {
            this.velocity.y = 0;
        } else {
            this.velocity.y += gravity;
        }
    }

    attack() {
        this.isAttacking = true;
        setTimeout(() => { this.isAttacking = false; }, 100);
    }
}

// 플레이어 생성
const player = new Sprite({
    position: { x: 100, y: 0 },
    velocity: { x: 0, y: 0 },
    color: 'red',
    offset: { x: 0, y: 0 }
});

const enemy = new Sprite({
    position: { x: 600, y: 0 },
    velocity: { x: 0, y: 0 },
    color: 'blue',
    offset: { x: -50, y: 0 }
});

const keys = {
    a: { pressed: false }, d: { pressed: false },
    ArrowRight: { pressed: false }, ArrowLeft: { pressed: false }
};

// 충돌 감지 함수
function rectangularCollision({ rect1, rect2 }) {
    return (
        rect1.attackBox.position.x + rect1.attackBox.width >= rect2.position.x &&
        rect1.attackBox.position.x <= rect2.position.x + rect2.width &&
        rect1.attackBox.position.y + rect1.attackBox.height >= rect2.position.y &&
        rect1.attackBox.position.y <= rect2.position.y + rect2.height
    );
}

function animate() {
    window.requestAnimationFrame(animate);
    ctx.fillStyle = 'black';
    ctx.fillRect(0, 0, canvas.width, canvas.height);

    player.update();
    enemy.update();

    // 플레이어 이동 제어
    player.velocity.x = 0;
    if (keys.a.pressed) player.velocity.x = -5;
    else if (keys.d.pressed) player.velocity.x = 5;

    // 적 이동 제어
    enemy.velocity.x = 0;
    if (keys.ArrowLeft.pressed) enemy.velocity.x = -5;
    else if (keys.ArrowRight.pressed) enemy.velocity.x = 5;

    // 공격 적중 판정
    if (player.isAttacking && rectangularCollision({ rect1: player, rect2: enemy })) {
        player.isAttacking = false;
        enemy.health -= 10;
        console.log('Enemy Hit! HP:', enemy.health);
    }

    if (enemy.isAttacking && rectangularCollision({ rect1: enemy, rect2: player })) {
        enemy.isAttacking = false;
        player.health -= 10;
        console.log('Player Hit! HP:', player.health);
    }
}

animate();

// 키보드 입력 이벤트
window.addEventListener('keydown', (event) => {
    switch (event.key) {
        case 'd': keys.d.pressed = true; break;
        case 'a': keys.a.pressed = true; break;
        case 'w': player.velocity.y = -15; break;
        case ' ': player.attack(); break;

        case 'ArrowRight': keys.ArrowRight.pressed = true; break;
        case 'ArrowLeft': keys.ArrowLeft.pressed = true; break;
        case 'ArrowUp': enemy.velocity.y = -15; break;
        case 'Enter': enemy.attack(); break;
    }
});

window.addEventListener('keyup', (event) => {
    switch (event.key) {
        case 'd': keys.d.pressed = false; break;
        case 'a': keys.a.pressed = false; break;
        case 'ArrowRight': keys.ArrowRight.pressed = false; break;
        case 'ArrowLeft': keys.ArrowLeft.pressed = false; break;
    }
});