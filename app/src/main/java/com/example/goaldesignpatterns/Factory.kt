package com.example.goaldesignpatterns

enum class SYSTEM {
    SERVER,
    PC
}

abstract class ComputerSystem {
    abstract val rAM: String
    abstract val hDD: String
    abstract val cPU: String

    override fun toString(): String {
        return "RAM= $rAM, HDD=$hDD, CPU=$cPU"
    }
}

class PC(override val rAM: String, override val hDD: String, override val cPU: String) :
    ComputerSystem()

class Server(override val rAM: String, override val hDD: String, override val cPU: String) :
    ComputerSystem()

object ComputerFactory {
    fun getComputer(
        type: SYSTEM = SYSTEM.PC,
        ram: String = "",
        hdd: String = "",
        cpu: String = ""
    ): ComputerSystem? {
        if (type == SYSTEM.PC)
            return PC(ram, hdd, cpu)
        else if (type == SYSTEM.SERVER)
            return Server(ram, hdd, cpu)
        return null
    }
}