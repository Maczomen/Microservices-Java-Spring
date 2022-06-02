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
    BackButton();
});

function BackButton() {
    let go_back =document.getElementById('go_back');
    go_back.href = '../tower_type/tower_type_view.html?towerType=' + getParameterByName('towerType');
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
    xhttp.open("GET", getBackendUrl() + '/api/towerTypes/' + getParameterByName('towerType') + '/towers/' +getParameterByName('tower'), true);
    xhttp.send();
}
