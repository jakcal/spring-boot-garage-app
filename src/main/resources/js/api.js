// API endpoints configuration
const API_BASE_URL = '/api';

const api = {
    // Garages
    async getGarages() {
        const response = await fetch(`${API_BASE_URL}/garages`);
        return await response.json();
    },
    async getGarage(id) {
        const response = await fetch(`${API_BASE_URL}/garages/${id}`);
        return await response.json();
    },
    async createGarage(garage) {
        const response = await fetch(`${API_BASE_URL}/garages`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(garage)
        });
        return await response.json();
    },
    async updateGarage(id, garage) {
        const response = await fetch(`${API_BASE_URL}/garages/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(garage)
        });
        return await response.json();
    },
    async deleteGarage(id) {
        await fetch(`${API_BASE_URL}/garages/${id}`, { method: 'DELETE' });
    },

    // Services
    async getServices() {
        const response = await fetch(`${API_BASE_URL}/services`);
        return await response.json();
    },
    async getService(id) {
        const response = await fetch(`${API_BASE_URL}/services/${id}`);
        return await response.json();
    },
    async createService(service) {
        const response = await fetch(`${API_BASE_URL}/services`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(service)
        });
        return await response.json();
    },
    async updateService(id, service) {
        const response = await fetch(`${API_BASE_URL}/services/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(service)
        });
        return await response.json();
    },
    async deleteService(id) {
        await fetch(`${API_BASE_URL}/services/${id}`, { method: 'DELETE' });
    },

    // Clients
    async getClients() {
        const response = await fetch(`${API_BASE_URL}/clients`);
        return await response.json();
    },
    async getClient(id) {
        const response = await fetch(`${API_BASE_URL}/clients/${id}`);
        return await response.json();
    },
    async createClient(client) {
        const response = await fetch(`${API_BASE_URL}/clients`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(client)
        });
        return await response.json();
    },
    async updateClient(id, client) {
        const response = await fetch(`${API_BASE_URL}/clients/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(client)
        });
        return await response.json();
    },
    async deleteClient(id) {
        await fetch(`${API_BASE_URL}/clients/${id}`, { method: 'DELETE' });
    },

    // Appointments (RendezVous)
    async getAppointments() {
        const response = await fetch(`${API_BASE_URL}/rendezvous`);
        return await response.json();
    },
    async getAppointment(id) {
        const response = await fetch(`${API_BASE_URL}/rendezvous/${id}`);
        return await response.json();
    },
    async createAppointment(appointment) {
        const response = await fetch(`${API_BASE_URL}/rendezvous`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(appointment)
        });
        return await response.json();
    },
    async updateAppointment(id, appointment) {
        const response = await fetch(`${API_BASE_URL}/rendezvous/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(appointment)
        });
        return await response.json();
    },
    async deleteAppointment(id) {
        await fetch(`${API_BASE_URL}/rendezvous/${id}`, { method: 'DELETE' });
    },

    // Employees
    async getEmployees() {
        const response = await fetch(`${API_BASE_URL}/employes`);
        return await response.json();
    },
    async getEmployee(id) {
        const response = await fetch(`${API_BASE_URL}/employes/${id}`);
        return await response.json();
    },
    async createEmployee(employee) {
        const response = await fetch(`${API_BASE_URL}/employes`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(employee)
        });
        return await response.json();
    },
    async updateEmployee(id, employee) {
        const response = await fetch(`${API_BASE_URL}/employes/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(employee)
        });
        return await response.json();
    },
    async deleteEmployee(id) {
        await fetch(`${API_BASE_URL}/employes/${id}`, { method: 'DELETE' });
    },

    // Stock
    async getStockItems() {
        const response = await fetch(`${API_BASE_URL}/stock`);
        return await response.json();
    },
    async getStockItem(id) {
        const response = await fetch(`${API_BASE_URL}/stock/${id}`);
        return await response.json();
    },
    async createStockItem(item) {
        const response = await fetch(`${API_BASE_URL}/stock`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)
        });
        return await response.json();
    },
    async updateStockItem(id, item) {
        const response = await fetch(`${API_BASE_URL}/stock/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(item)
        });
        return await response.json();
    },
    async deleteStockItem(id) {
        await fetch(`${API_BASE_URL}/stock/${id}`, { method: 'DELETE' });
    },

    // Invoices
    async getInvoices() {
        const response = await fetch(`${API_BASE_URL}/factures`);
        return await response.json();
    },
    async getInvoice(id) {
        const response = await fetch(`${API_BASE_URL}/factures/${id}`);
        return await response.json();
    },
    async createInvoice(invoice) {
        const response = await fetch(`${API_BASE_URL}/factures`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(invoice)
        });
        return await response.json();
    },
    async updateInvoice(id, invoice) {
        const response = await fetch(`${API_BASE_URL}/factures/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(invoice)
        });
        return await response.json();
    },
    async deleteInvoice(id) {
        await fetch(`${API_BASE_URL}/factures/${id}`, { method: 'DELETE' });
    }
};