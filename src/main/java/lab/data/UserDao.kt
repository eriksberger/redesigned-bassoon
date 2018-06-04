package lab.data

import java.util.concurrent.atomic.AtomicInteger

class UserDao {

    val users = hashMapOf(
            0 to User(email = "jens.eriksberger@avegagroup.se0", name = "Jens Eriksberger0", id = 0),
            1 to User(email = "jens.eriksberger@avegagroup.se1", name = "Jens Eriksberger1", id = 1),
            2 to User(email = "jens.eriksberger@avegagroup.se2", name = "Jens Eriksberger2", id = 2),
            3 to User(email = "jens.eriksberger@avegagroup.se3", name = "Jens Eriksberger3", id = 3)
    )

    var lastId: AtomicInteger = AtomicInteger(users.size - 1)

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users[id] = User(name = name, email = email, id = id)
    }

    fun findById(id: Int): User? {
        return users[id]
    }

    fun findByEmail(email: String): User? {
        return users.values.find {it.email == email}
    }

    fun update(id: Int, name: String, email: String) {
        users[id] = User(name = name, email = email, id = id)
    }

    fun delete(id: Int) {
        users.remove(id)
    }

}
