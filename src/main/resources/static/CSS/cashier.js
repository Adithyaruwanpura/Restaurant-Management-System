// public/js/cashier.js

function filterCategory(category) {
    const cards = document.querySelectorAll('.food-card');
    const tabs = document.querySelectorAll('.tab');

    tabs.forEach(tab => tab.classList.remove('active'));
    event.target.classList.add('active');

    cards.forEach(card => {
        card.style.display = card.dataset.category === category ? 'block' : 'none';
    });
}

function selectOrderType(button, type) {
    const allButtons = document.querySelectorAll('.order-types button');
    allButtons.forEach(btn => btn.classList.remove('active'));
    button.classList.add('active');

    const takeawayBar = document.getElementById('takeawayBar');
    if (takeawayBar) {
        takeawayBar.style.display = (type === 'takeaway') ? 'block' : 'none';
    }
}
