package sample.chooyan.co.jp.architecturecomponentsample

class DummyUserProvider {
    fun provide(id: Int): User {
        when (id) {
            1 -> return User(1, "Ichi", "I am the number one user!")
            2 -> return User(2, "Nino", "I am the number two user!")
            3 -> return User(3, "Santa", "I am the number three user!")
            4 -> return User(4, "Yonji", "I am the number four user!")
            5 -> return User(5, "Goro", "I am the number five user!")
            6 -> return User(6, "Rokuro", "I am the number six user!")
            7 -> return User(7, "Nana", "I am the number seven user!")
            8 -> return User(8, "Hachiko", "I am the number eight user!")
            9 -> return User(9, "Kyubei", "I am the number nine user!")
            10 -> return User(10, "Juji", "I am the number ten user!")
        }
        return User(99, "Gonbe", "I am not a user!")
    }
}