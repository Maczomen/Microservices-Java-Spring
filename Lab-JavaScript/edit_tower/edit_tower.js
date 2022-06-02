import {getParameterByName} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => updateInfoAction(event));

    fetchAndDisplayTower();
    BackButton();
});


function BackButton() {
    let go_back =document.getElementById('go_back');
    go_back.href = '../tower_type/tower_type_view.html?towerType=' + getParameterByName('towerType');
}


function fetchAndDisplayTower() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            for (const [key, value] of Object.entries(response)) {
                let input = document.getElementById(key);
                if (input) {
                    input.textContent = value;
                    input.value = value;
                }
            }
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType') + '/towers/' + getParameterByName('tower'), true);
    xhttp.send();
}


function updateInfoAction(event) {
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            fetchAndDisplayTower();
        }
    };
    xhttp.open("PUT", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType') + '/towers/' + getParameterByName('tower'), true);

    const request = {
        "range": document.getElementById('range').value,
        "attackSpeed": document.getElementById('attackSpeed').value,
        "cost": document.getElementById('cost').value,
        "damage": document.getElementById('damage').value
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}
