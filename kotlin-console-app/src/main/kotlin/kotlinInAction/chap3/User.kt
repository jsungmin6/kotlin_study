package kotlinInAction.chap3

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user ${user.id}, emtpy ${fieldName}")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
    // user 데이터베이스에 저장
}

// REFACTOR 2 로컬 함수는 자신이 속한 바깥 함수의 모든 파라미터와 변수 사용 가능
fun saveUser2(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user ${user.id}, emtpy ${fieldName}")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
    // user 데이터베이스에 저장
}


// REFACTOR 3 - 확장 함수 ( 응집도 해치는거 아닌가? User 내부 코드 간결 + 사용하는쪽에서만 )
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user ${id}, emtpy ${fieldName}")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser3(user: User) {
    user.validateBeforeSave()

    // user 데이터베이스에 저장
}