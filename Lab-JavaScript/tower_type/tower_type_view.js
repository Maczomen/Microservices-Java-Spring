import {
    getParameterByName,
    clearElementChildren,
    createLinkCell,
    createButtonCell,
    createTextCell,
} from '../js/dom_utils.js';
import {getBackendUrl} from '../js/configuration.js';

window.addEventListener('load', () => {
    fetchAndDisplayTowerType();
    fetchAndDisplayTower();
    addTowerLint();
});


function addTowerLint(){
    let link = document.getElementById('add_tower');
    link.href = '../add_tower/add_tower.html?towerType=' + getParameterByName('towerType');
}

function fetchAndDisplayTower() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            displayTowers(JSON.parse(this.responseText))
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType') + '/towers', true);
    xhttp.send();
}


function displayTowers(towers) {
    let tableBody = document.getElementById('tableBody');
    clearElementChildren(tableBody);
    towers.towers.forEach(tower => {
        tableBody.appendChild(createTableRow(tower.name));
    })
}


function createTableRow(tower) {
    let tr = document.createElement('tr');
    tr.appendChild(createTextCell(tower));
    tr.appendChild(createLinkCell('view', '../tower_view/tower_view.html?towerType='
        + getParameterByName('towerType') + '&tower=' + tower));
    tr.appendChild(createLinkCell('edit', '../edit_tower/edit_tower.html?towerType='
        + getParameterByName('towerType') + '&tower=' + tower));
    tr.appendChild(createButtonCell('delete', () => deleteTower(tower)));
    return tr;
}


function deleteTower(tower) {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 202) {
            fetchAndDisplayTower();
        }
    };
    xhttp.open("DELETE", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType')
        + '/towers/' + tower, true);
    xhttp.send();
}


function fetchAndDisplayTowerType() {
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let response = JSON.parse(this.responseText);
            for (const [key, value] of Object.entries(response)) {
                let input = document.getElementById(key);
                if (input) {
                    input.textContent = value;
                }
            }
        }
    };
    xhttp.open("GET", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType'), true);
    xhttp.send();
}
