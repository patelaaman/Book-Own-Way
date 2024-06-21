const navBtn = document.getElementById('nav-btn');
const cancelBtn = document.getElementById('cancel-btn');
const sideNav = document.getElementById('sidenav');
const modal = document.getElementById('modal');

navBtn.addEventListener("click", function(){
    sideNav.classList.add('show');
    modal.classList.add('showModal');
});

cancelBtn.addEventListener('click', function(){
    sideNav.classList.remove('show');
    modal.classList.remove('showModal');
});

window.addEventListener('click', function(event){
    if(event.target === modal){
        sideNav.classList.remove('show');
        modal.classList.remove('showModal');
    }
});

function calculateCharge() {
    const purpose = document.getElementById('purpose').value;
    let charges;
    switch (purpose) {
        case 'birthday':
            charges = 1000;
            break;
        case 'anniversary':
            charges = 2000;
            break;
        case 'normal':
            charges = 3000;
            break;
        default:
            charges = 0;
            break;
    }
    document.getElementById('charges').value = charges;
}

function bookTable() {
    // Get form values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const number = document.getElementById('number').value;
    const seat = document.getElementById('seat').value;
    const purpose = document.getElementById('purpose').value;
    const charges = document.getElementById('charges').value;

    // Dummy validation
    if (!name || !email || !number || !seat || !purpose || !charges) {
        alert('Please fill in all fields');
        return;
    }

    // Show confirmation message
    document.getElementById('bookingForm').style.display = 'none';
    document.getElementById('confirmation').style.display = 'block';
}


// Garden booking
function calculateCharges() {
    const seat = parseInt(document.getElementById('seat').value);
    const worker = parseInt(document.getElementById('worker').value);
    const room = parseInt(document.getElementById('room').value);
    const purpose = document.getElementById('purpose').value;

    let charges;
    switch (purpose) {
        case 'marriage':
            charges = seat * 200 + worker * 1000 + room * 5000;
            break;
        case 'anniversary':
            charges = seat * 150 + worker * 800 + room * 4000;
            break;
        case 'normal':
            charges = seat * 100 + worker * 500 + room * 3000;
            break;
        default:
            charges = 0;
            break;
    }
    document.getElementById('charges').value = charges.toLocaleString('en-IN', { style: 'currency', currency: 'INR' });
}

function bookVenue() {
    // Get form values
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const number = document.getElementById('number').value;
    const seat = document.getElementById('seat').value;
    const worker = document.getElementById('worker').value;
    const room = document.getElementById('room').value;
    const purpose = document.getElementById('purpose').value;
    const charges = document.getElementById('charges').value;

    // Dummy validation
    if (!name || !email || !number || !seat || !worker || !room || !purpose || !charges) {
        alert('Please fill in all fields');
        return;
    }

    // Show confirmation message
    document.getElementById('bookingForm').style.display = 'none';
    document.getElementById('confirmation').style.display = 'block';
}

function calculateCharges() {
    const people = parseInt(document.getElementById('numberPeople').value);
    const purpose = document.getElementById('purpose').value;

    let charges;
    switch (purpose) {
        case 'swimming':
            charges = people * 500;
            break;
        case 'party':
            charges = people * 1000;
            break;
        default:
            charges = 0;
            break;
    }
    document.getElementById('charges').value = "Charges: Rupees" + charges.toLocaleString();
}

function bookNow() {
    // Code to book the swimming pool
    alert("Your booking has been confirmed!");
}
