document.addEventListener('DOMContentLoaded', () => {
    loadCategories();
    loadDishes();
});

function loadCategories() {
    fetch('/api/menu/categories')
        .then(res => res.json())
        .then(categories => {
            const tabs = document.getElementById('categoryTabs');
            tabs.innerHTML = '<button onclick="loadDishes()">All</button>';
            categories.forEach(cat => {
                tabs.innerHTML += `<button onclick="loadDishes(${cat.id})">${cat.name}</button>`;
            });
        });
}

function loadMenuItems() {
    fetch('/api/menu')
        .then(response => response.json())
        .then(data => {
            const grid = document.getElementById('dishesGrid');
            grid.innerHTML = ''; // Clear previous dishes

            if (data.length === 0) {
                grid.innerHTML = '<p style="color: #fff;">No Dishes Available.</p>';
                return;
            }

            data.forEach(item => {
                const card = `
                <div class="dish-card">
                    <img src="/uploads/${item.imageFilename || 'default.jpg'}" alt="Dish" style="width:100px; height:100px; border-radius:8px;">
                    <h4>${item.name}</h4>
                    <p>$${item.price}</p>
                    <button onclick="editDish(${item.id})">Edit</button>
                    <button onclick="deleteDish(${item.id})">Delete</button>
                </div>`;
                grid.insertAdjacentHTML('beforeend', card);
            });
        })
        .catch(err => console.error('Error loading menu items:', err));
}


function openModal(item = null) {
    const modal = document.getElementById('dishModal');
    const form = document.getElementById('dishForm');
    form.reset();
    form.id.value = item?.id || '';
    form.name.value = item?.name || '';
    form.price.value = item?.price || '';

    fetch('/api/menu/categories')
        .then(res => res.json())
        .then(categories => {
            form.categoryId.innerHTML = categories.map(c =>
                `<option value="${c.id}" ${item?.categoryId === c.id ? 'selected' : ''}>${c.name}</option>`
            ).join('');
        });

    modal.style.display = 'flex';  // ✅ Ensure this is set to 'flex' to center properly
}


function closeModal() {
    document.getElementById('dishModal').style.display = 'none';
}

document.getElementById('dishForm').addEventListener('submit', function (e) {
    e.preventDefault();
    const formData = new FormData(this);
    const id = formData.get('id');
    const url = `/api/menu${id ? `/${id}` : ''}`;
    const method = id ? 'PUT' : 'POST';

    fetch(url, {
        method: method,
        body: formData
    }).then(() => {
        closeModal();
        loadDishes();
    });
});

function editDish(id) {
    fetch(`/api/menu/${id}`)
        .then(res => res.json())
        .then(item => openModal(item));
}

function deleteDish(id) {
    if (confirm('Are you sure you want to delete this dish?')) {
        fetch(`/api/menu/${id}`, { method: 'DELETE' })
            .then(() => loadDishes());
    }
}
