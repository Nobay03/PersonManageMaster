let nameError = document.getElementById("nameError")
let passwordError = document.getElementById("passwordError")

function checkName(username) {
    username = username.trim()
    if (username) {
        if (username.length < 6 || username.length > 14) {
            nameError.innerHTML = "ユーザー名の長さは6〜14桁である必要があります"
        }
    } else {
        nameError.innerHTML = "ユーザー名を空にすることはできません"
    }
}

function checkPassword(password) {
    if (!password) {
        passwordError.innerHTML = "パスワードを空白にすることはできません"
    }
}

function clearNameError() {
    nameError.innerHTML = ""
}

function clearPasswordError() {
    passwordError.innerHTML = ""
}

function check() {
    const control = document.getElementsByClassName("form-control")
    if (control[0].value && control[1].value) {
        return !nameError.innerHTML;
    } else {
        checkName(control[0].value)
        checkPassword(control[1].value)
        return false
    }
}