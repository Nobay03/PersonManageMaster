let flag = true

function submitTable() {
    const input = document.getElementById("formList").getElementsByTagName("input")
    const select = document.getElementById("formList").getElementsByTagName("select")
    const error = document.getElementsByClassName("error")
    let checkFlag = ""
    for (let i = 0; i < input.length; i++) {
        checkInput(input[i])
    }
    for (let i = 0; i <error.length; i++) {
        checkFlag += error[i].innerHTML
    }
    console.log(checkFlag)
    if (!(checkFlag.trim())) {
        flag = true
    }
    if (!flag) {
        alert("間違っています。正しい情報を入力してください")
        return
    }
    if (flag) {
        let employee = {}
        for (let i = 0; i < input.length; i++) {
            if (input[i].name === "sexFlg"){
                if (input[i].checked) {
                    employee[input[i].name] = input[i].value
                }
            } else {
                employee[input[i].name] = input[i].value
            }
        }
        for (let i = 0; i < select.length; i++) {
            employee[select[i].name] = select[i].value
        }
        axios({
            method: 'POST',
            url: 'add',
            data: {employee}
        }).then(function (response) {
            alert("データが正常に保存されました")
            window.location.href = "/table/member_management"
        }).catch(function (error) {
            alert("データの保存に失敗しました")
        })
    } else {
        alert("空にできないフィールドがあります")
    }
}

function checkInput(element) {
    if (!element.value.trim()) {
        if (element.classList.contains("input-notnull")) {
            document.getElementById(element.name).innerHTML = "このフィールドを空にすることはできません"
            flag = false
        }
    } else {
        if (element.classList.contains("number")) {
            const type = "^[0-9]*$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "このフィールドに自然数を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("phoneJP")) {
            const type = "\\d{3}-\\d{4}-\\d{4}"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "次の形式070-0000-0000で入力してください"
                flag = false
            }
        }
        if (element.classList.contains("phoneCN")) {
            const type = "\\d{3}-\\d{4}-\\d{4}"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "次の形式130-0000-0000で入力してください"
                flag = false
            }
        }
        if (element.classList.contains("email")) {
            const type = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効なメールアドレスを入力してください"
                flag = false
            }
        }
        if (element.classList.contains("two")) {
            const type = "^.{1,2}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜2文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("six")) {
            const type = "^.{1,6}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜6文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("eight")) {
            const type = "^\\d{8}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "8桁の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("twelve")) {
            const type = "^.{1,12}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜12文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("fifteen")) {
            const type = "^.{1,15}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜15文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("twenty")) {
            const type = "^.{1,20}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜20文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("hundred")) {
            const type = "^.{1,100}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜100文字の文字を入力してください"
                flag = false
            }
        }
        if (element.classList.contains("twoHundred")) {
            const type = "^.{1,200}$"
            const ruler = new RegExp(type)
            if (!ruler.test(element.value.trim())) {
                document.getElementById(element.name).innerHTML = "有効な1〜200文字の文字を入力してください"
                flag = false
            }
        }
    }
}

function clearError(element) {
    if (element.classList.contains("phoneJP") || element.classList.contains("phoneCN")) {
        let oldValue = element.value.trim()
        if (oldValue) {
            element.value = oldValue.substring(0, 3) + "-" + oldValue.substring(3, 7) + "-" + oldValue.substring(7, 11)
        }
    }
    document.getElementById(element.name).innerHTML = " "
}