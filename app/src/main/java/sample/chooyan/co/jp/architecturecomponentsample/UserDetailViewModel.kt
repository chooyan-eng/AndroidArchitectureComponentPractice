package sample.chooyan.co.jp.architecturecomponentsample

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class UserDetailViewModel: ViewModel {

    var userData: LiveData<User>? = null
    var repository: UserRepository? = null

    constructor() {
        this.repository = UserRepository()
    }

    fun init(id: Int) {
        if (userData != null) {
            return
        }

        userData = repository?.getUser(id)
    }

    fun getUser(): LiveData<User>? {
        return userData
    }
}