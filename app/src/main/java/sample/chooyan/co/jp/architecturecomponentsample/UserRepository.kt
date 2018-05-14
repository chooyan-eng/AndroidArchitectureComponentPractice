package sample.chooyan.co.jp.architecturecomponentsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class UserRepository {

    val cache = mutableMapOf<Int, LiveData<User>>()

    fun getUser(id: Int): LiveData<User> {
        val cachedUser = cache[id]
        if(cachedUser != null) {
            return cachedUser
        }

        val userLiveData = MutableLiveData<User>()
        cache[id] = userLiveData

        val user = DummyUserProvider().provide(id)
        userLiveData.value = user

        return userLiveData
    }
}