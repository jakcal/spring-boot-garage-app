let currentSection = null;
let currentModal = null;

// Form configurations for each section
const formConfigs = {
    garages: [
        { name: 'name', label: 'Name', type: 'text' },
        { name: 'address', label: 'Address', type: 'text' },
        { name: 'phoneNumber', label: 'Phone Number', type: 'tel' }
    ],
    services: [
        { name: 'name', label: 'Name', type: 'text' },
        { name: 'description', label: 'Description', type: 'text' },
        { name: 'price', label: 'Price', type: 'number' }
    ],
    clients: [
        { name: 'firstName', label: 'First Name', type: 'text' },
        { name: 'lastName', label: 'Last Name', type: 'text' },
        { name: 'email', label: 'Email', type: 'email' },
        { name: 'phoneNumber', label: 'Phone Number', type: 'tel' }
    ],
    appointments: [
        { name: 'clientId', label: 'Client', type: 'select', dataSource: 'clients' },
        { name: 'date', label: 'Date', type: 'date' },
        { name: 'time', label: 'Time', type: 'time' },
        { name: 'serviceId', label: 'Service', type: 'select', dataSource: 'services' },
        { name: 'status', label: 'Status', type: 'select', options: ['Scheduled', 'Completed', 'Cancelled'] }
    ],
    employees: [
        { name: 'firstName', label: 'First Name', type: 'text' },
        { name: 'lastName', label: 'Last Name', type: 'text' },
        { name: 'position', label: 'Position', type: 'text' },
        { name: 'phoneNumber', label: 'Phone Number', type: 'tel' }
    ],
    stock: [
        { name: 'name', label: 'Name', type: 'text' },
        { name: 'description', label: 'Description', type: 'text' },
        { name: 'quantity', label: 'Quantity', type: 'number' },
        { name: 'price', label: 'Price', type: 'number' }
    ],
    invoices: [
        { name: 'rendezVousId', label: 'Appointment', type: 'select', dataSource: 'appointments' },
        { name: 'clientId', label: 'Client', type: 'select', dataSource: 'clients' },
        { name: 'date', label: 'Date', type: 'date' },
        { name: 'totalAmount', label: 'Total Amount', type: 'number' },
        { name: 'status', label: 'Status', type: 'select', options: ['Paid', 'Pending', 'Cancelled'] }
    ]
};

// Initialize Bootstrap modal
const modal = new bootstrap.Modal(document.getElementById('crudModal'));

// Load section data and show modal
async function loadSection(section) {
    currentSection = section;
    document.querySelector('.modal-title').textContent = `Manage ${section.charAt(0).toUpperCase() + section.slice(1)}`;
    await refreshList();
    modal.show();
}

// Refresh items list
async function refreshList() {
    const itemsList = document.getElementById('itemsList');
    itemsList.innerHTML = '';
    document.getElementById('itemForm').classList.add('d-none');

    try {
        let items;
        switch(currentSection) {
            case 'garages': items = await api.getGarages(); break;
            case 'services': items = await api.getServices(); break;
            case 'clients': items = await api.getClients(); break;
            case 'appointments': items = await api.getAppointments(); break;
            case 'employees': items = await api.getEmployees(); break;
            case 'stock': items = await api.getStockItems(); break;
            case 'invoices': items = await api.getInvoices(); break;
        }

        items.forEach(item => {
            const listItem = document.createElement('div');
            listItem.className = 'list-group-item d-flex justify-content-between align-items-center';
            listItem.innerHTML = `
                <span>${getItemDisplayName(item)}</span>
                <div>
                    <button class="btn btn-sm btn-primary me-2" onclick="editItem(${item.id})">Edit</button>
                    <button class="btn btn-sm btn-danger" onclick="deleteItem(${item.id})">Delete</button>
                </div>
            `;
            itemsList.appendChild(listItem);
        });
    } catch (error) {
        console.error('Error loading items:', error);
        alert('Error loading items. Please try again.');
    }
}

// Get display name for list items
function getItemDisplayName(item) {
    switch(currentSection) {
        case 'garages': return item.name;
        case 'services': return `${item.name} - $${item.price}`;
        case 'clients': return `${item.firstName} ${item.lastName}`;
        case 'appointments': return `${item.date} - ${item.status}`;
        case 'employees': return `${item.firstName} ${item.lastName} - ${item.position}`;
        case 'stock': return `${item.name} (${item.quantity})`;
        case 'invoices': return `Invoice #${item.id} - $${item.totalAmount}`;
        default: return item.id;
    }
}

// Show add form
function showAddForm() {
    showForm();
}

// Show edit form
async function editItem(id) {
    try {
        let item;
        switch(currentSection) {
            case 'garages': item = await api.getGarage(id); break;
            case 'services': item = await api.getService(id); break;
            case 'clients': item = await api.getClient(id); break;
            case 'appointments': item = await api.getAppointment(id); break;
            case 'employees': item = await api.getEmployee(id); break;
            case 'stock': item = await api.getStockItem(id); break;
            case 'invoices': item = await api.getInvoice(id); break;
        }
        showForm(item);
    } catch (error) {
        console.error('Error loading item:', error);
        alert('Error loading item. Please try again.');
    }
}

// Show form for add/edit
async function showForm(item = null) {
    const formDiv = document.getElementById('itemForm');
    const config = formConfigs[currentSection];
    
    let formHtml = `<form id="itemForm" class="mt-3">`;
    
    for (const field of config) {
        const value = item ? item[field.name] : '';
        formHtml += `<div class="mb-3">`;
        
        if (field.type === 'select') {
            formHtml += `<label class="form-label">${field.label}</label>`;
            formHtml += `<select class="form-select" name="${field.name}" required>`;
            formHtml += `<option value="">Select ${field.label}</option>`;
            
            if (field.options) {
                field.options.forEach(option => {
                    const selected = value === option ? 'selected' : '';
                    formHtml += `<option value="${option}" ${selected}>${option}</option>`;
                });
            } else if (field.dataSource) {
                // Load options from API
                try {
                    const options = await getOptionsForField(field.dataSource);
                    options.forEach(option => {
                        const selected = value === option.id ? 'selected' : '';
                        formHtml += `<option value="${option.id}" ${selected}>${getItemDisplayName(option)}</option>`;
                    });
                } catch (error) {
                    console.error(`Error loading options for ${field.name}:`, error);
                }
            }
            
            formHtml += `</select>`;
        } else {
            formHtml += `
                <label class="form-label">${field.label}</label>
                <input type="${field.type}" class="form-control" name="${field.name}" value="${value}" required>
            `;
        }
        
        formHtml += `</div>`;
    }
    
    formHtml += `
        <input type="hidden" name="id" value="${item ? item.id : ''}">
        <button type="submit" class="btn btn-primary">${item ? 'Update' : 'Create'}</button>
        <button type="button" class="btn btn-secondary ms-2" onclick="cancelForm()">Cancel</button>
    </form>`;
    
    formDiv.innerHTML = formHtml;
    formDiv.classList.remove('d-none');
    document.getElementById('itemsList').classList.add('d-none');
    
    // Add form submit handler
    document.getElementById('itemForm').addEventListener('submit', handleFormSubmit);
}

// Get options for select fields
async function getOptionsForField(dataSource) {
    switch(dataSource) {
        case 'clients': return await api.getClients();
        case 'services': return await api.getServices();
        case 'appointments': return await api.getAppointments();
        default: return [];
    }
}

// Handle form submit
async function handleFormSubmit(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData);
    const id = data.id;
    delete data.id;

    try {
        if (id) {
            // Update
            switch(currentSection) {
                case 'garages': await api.updateGarage(id, data); break;
                case 'services': await api.updateService(id, data); break;
                case 'clients': await api.updateClient(id, data); break;
                case 'appointments': await api.updateAppointment(id, data); break;
                case 'employees': await api.updateEmployee(id, data); break;
                case 'stock': await api.updateStockItem(id, data); break;
                case 'invoices': await api.updateInvoice(id, data); break;
            }
        } else {
            // Create
            switch(currentSection) {
                case 'garages': await api.createGarage(data); break;
                case 'services': await api.createService(data); break;
                case 'clients': await api.createClient(data); break;
                case 'appointments': await api.createAppointment(data); break;
                case 'employees': await api.createEmployee(data); break;
                case 'stock': await api.createStockItem(data); break;
                case 'invoices': await api.createInvoice(data); break;
            }
        }
        cancelForm();
        await refreshList();
    } catch (error) {
        console.error('Error saving item:', error);
        alert('Error saving item. Please try again.');
    }
}

// Cancel form
function cancelForm() {
    document.getElementById('itemForm').classList.add('d-none');
    document.getElementById('itemsList').classList.remove('d-none');
}

// Delete item
async function deleteItem(id) {
    if (!confirm('Are you sure you want to delete this item?')) return;

    try {
        switch(currentSection) {
            case 'garages': await api.deleteGarage(id); break;
            case 'services': await api.deleteService(id); break;
            case 'clients': await api.deleteClient(id); break;
            case 'appointments': await api.deleteAppointment(id); break;
            case 'employees': await api.deleteEmployee(id); break;
            case 'stock': await api.deleteStockItem(id); break;
            case 'invoices': await api.deleteInvoice(id); break;
        }
        await refreshList();
    } catch (error) {
        console.error('Error deleting item:', error);
        alert('Error deleting item. Please try again.');
    }
}