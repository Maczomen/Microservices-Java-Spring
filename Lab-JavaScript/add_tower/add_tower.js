import {getParameterByName} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    const infoForm = document.getElementById('infoForm');

    infoForm.addEventListener('submit', event => updateInfoAction(event));

    DisplayTowerType();
});

function DisplayTowerType() {
    let element = document.getElementById('towerType');
    element.appendChild(document.createTextNode(getParameterByName('towerType')));

    let go_back =document.getElementById('go_back');
    go_back.href = '../tower_type/tower_type_view.html?towerType=' + getParameterByName('towerType');
}


function updateInfoAction(event) {
    event.preventDefault();

    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            ;
        }
    };
    xhttp.open("POST", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType') + '/towers', true);

    const request = {
        'name': document.getElementById('name').value,
        'range': parseInt(document.getElementById('range').value),
        'attackSpeed': parseInt(document.getElementById('attackSpeed').value),
        'towerType': getParameterByName('towerType'),
        'cost': parseInt(document.getElementById('cost').value),
        'damage': parseInt(document.getElementById('damage').value)
    };

    xhttp.setRequestHeader('Content-Type', 'application/json');

    xhttp.send(JSON.stringify(request));
}
