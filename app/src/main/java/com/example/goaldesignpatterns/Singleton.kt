package com.example.goaldesignpatterns

object Singleton {
    init {
        println("Initializing with object: $this")
    }

    fun print() = println("Printing with object: $this")
}

class NetworkManager {

    companion object {
        private var INSTANCE: NetworkManager? = null

        fun getInstance(): NetworkManager {
            if (INSTANCE == null)
                synchronized(this) {
                    INSTANCE = NetworkManager()
              }

            return INSTANCE as NetworkManager
        }
    }

    private constructor() {}
}