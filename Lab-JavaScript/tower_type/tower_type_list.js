import {clearElementChildren, createLinkCell, createButtonCell, createTextCell} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayTowerTypes();
});


function fetchAndDisplayTowerTypes() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayTowerTypes(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/towerTypes', true);
    xhttp.send();
}


function displayTowerTypes(towerTypes) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    towerTypes.towerTypes.forEach(towerType => {
        tableBody.appendChild(createTableRow(towerType.name));
    })
}


function createTableRow(towerType) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(towerType));
    tr.appendChild(createLinkCell('view', '../tower_type/tower_type_view.html?towerType=' + towerType));
    tr.appendChild(createLinkCell('edit', '../edit_tower_type/edit_tower_type.html?towerType=' + towerType));
    tr.appendChild(createButtonCell('delete', () => deleteTowerType(towerType)));
    return tr;
}


function deleteTowerType(towerType) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayTowerTypes();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/towerTypes/' + towerType, true);
    xhttp.send();
}
