let oldValue
let flag = true

function updateInformation() {
    const list = document.getElementById("tableList").getElementsByTagName("input")
    let data = []
    for (let i = 0; i < list.length; i++) {
        if (list[i].value) {
            data[i] = '"' + list[i].name + '"' + ":" + '"' + list[i].value + '"'
        } else {
            data[i] = '"' + list[i].name + '"' + ":" + "null"
        }
    }
    if (flag) {
        axios({
            method: 'POST',
            url: 'updateInformation',
            data: {data: data}
        }).then(function (response) {
            alert("データが正常に更新されました")
        }).catch(function (error) {
            alert("データの保存に失敗しました")
            console.log(error)
        })
    } else {
        alert("空にできないフィールドがあります")
    }
}

function getOldValue(value) {
    if (this.className === "input-notnull") {
        document.getElementById(this.name).innerHTML = " "
    }
    oldValue = value
}

function changeIt(element) {
    if (window.confirm("コンテンツが変更されました、保存するかどうか")) {
        if (element.value) {
            if (element.className === "input-notnull") {
                document.getElementById(element.name).innerHTML = " "
                let notnull = document.getElementsByClassName("notnull")
                let count = 0
                for (let i = 0; i < notnull.length; i++) {
                    if (notnull[i].innerHTML !== " "){
                        count += 1
                    }
                }
                flag = !count
            }
            element.value = element.value.trim()
        } else if (element.className === "input-notnull") {
            document.getElementById(element.name).innerHTML = "このフィールドを空にすることはできません"
            flag = false
        } else {
            element.value = element.value.trim()
        }
    } else {
        element.value = oldValue
    }
}