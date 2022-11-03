let completeField;
let completeTable;
let autoRow;
let fioEmployee;
let isIE;
let linkElement;
let arrayTr;
let req;

function init() {
    completeField = document.getElementById("completeField");
    completeTable = document.getElementById("completeTable");
    autoRow = document.getElementById("auto-row");
    completeTable.style.top = getElementY(autoRow) + "px";
}

function doCompletion() {
    fioEmployee = completeField.value;
    if (fioEmployee.trim()){
        var url = "showEmployee/"+fioEmployee;
        req = initRequest();
        req.open("GET", url, true);
        req.onreadystatechange = callback;
        req.send(null);
    } else {
        clearTable()
    }
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callback() {
    clearTable();
    if (req.readyState == 4) {
        if (req.status == 200) {
            req.onload = function() {
                    let employeeListJson = req.response;
                    let employeeList = JSON.parse(employeeListJson);
                    for(var i=0;i<employeeList.length; i++){
                        appendComposer(employeeList[i].id,employeeList[i].fio);
                    }
                }
        }
    }
}

function appendComposer(id,fio) {
    let cell;
    let row;
    if (isIE) {
        completeTable.style.display = 'block';
        row = completeTable.insertRow(completeTable.rows.length);
        cell = row.insertCell(0);
    } else {
        completeTable.style.display = 'table';
        row = document.createElement("tr");
        cell = document.createElement("td");
        row.appendChild(cell);
        completeTable.appendChild(row);
    }

    cell.className = "popupCell";
    linkElement = document.createElement("a");
    linkElement.className = "popupItem";
    linkElement.setAttribute("href", "addNewProblemByUserId/" + id);
    linkElement.appendChild(document.createTextNode(fio));
    cell.appendChild(linkElement);
}

function getElementY(element){

    let targetTop = 0;

    if (element.offsetParent) {
        while (element.offsetParent) {
            targetTop += element.offsetTop;
            element = element.offsetParent;
        }
    } else if (element.y) {
        targetTop += element.y;
    }
    return targetTop;
}

function clearTable() {
    arrayTr = completeTable.getElementsByTagName("tr");
    if (arrayTr.length > 1) {
        for (var loop = arrayTr.length-1; loop > 1 ; loop--) {
            completeTable.removeChild(arrayTr[loop]);
        }
    }
}

