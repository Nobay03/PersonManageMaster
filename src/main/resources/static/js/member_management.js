function getDetail(empNo) {
    window.location.href = "/table/basic_information?empNo=" + empNo
}

function addEmployee() {
    window.location.href = "/table/add_employee"
}

function searchEmployee() {
    let empNo = document.getElementsByClassName("body-head-input")[0].value.trim()
    let empNameKanji = document.getElementsByClassName("body-head-input")[1].value.trim()
    if (!(empNo + empNameKanji)) {
        alert("检索入力を空にすることはできません")
    } else {
        if (empNo && empNameKanji) {

        } else if (empNo) {
            axios({
                method: 'GET',
                url: "searchEmployeeByEmpNo",
                params: {empNo}
            }).then(function (response) {
                const searchEmployees = response.data
                if (searchEmployees) {
                    const tbody = document.getElementById("table-body")
                    tbody.innerHTML = ""
                    tbody.appendChild(getDataRow(searchEmployees, 0))
                } else {
                    alert("従業員はいません")
                }
            })
        } else {
            axios({
                method: 'GET',
                url: "searchEmployeeByEmpNameKanji",
                params: {empNameKanji}
            }).then(function (response) {
                const searchEmployees = response.data
                if (searchEmployees.length) {
                    const tbody = document.getElementById("table-body")
                    tbody.innerHTML = ""
                    for (let i = 0; i < searchEmployees.length; i++) {
                        tbody.appendChild(getDataRow(searchEmployees[i], i))
                    }
                } else {
                    alert("従業員はいません")
                }
            })
        }
    }
}

function getDataRow(searchEmployees, no) {
    let row = document.createElement('tr')

    let noCell = document.createElement('td')
    noCell.innerHTML = no + 1
    row.appendChild(noCell)

    let empNoCell = document.createElement('td')
    empNoCell.innerHTML = searchEmployees.empNo
    row.appendChild(empNoCell)

    let empNameKanjiCell = document.createElement('td')
    empNameKanjiCell.innerHTML = searchEmployees.empNameKanji
    row.appendChild(empNameKanjiCell)

    let detailCell = document.createElement('td')
    row.appendChild(detailCell);
    let btnDetail = document.createElement('input')
    btnDetail.setAttribute('type', 'button');
    btnDetail.setAttribute('value', '詳細');
    btnDetail.onclick = () => {
        getDetail(searchEmployees.empNo)
    }
    detailCell.appendChild(btnDetail)
    return row
}