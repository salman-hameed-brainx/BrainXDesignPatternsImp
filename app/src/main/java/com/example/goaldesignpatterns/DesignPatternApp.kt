package com.example.goaldesignpatterns

import android.app.Application
import com.example.goaldesignpatterns.Computer.ComputerBuilder

class DesignPatternApp : Application() {

    override fun onCreate() {
        super.onCreate()
        observerUsage()
        singletonUsage()
        singletonUsage1()
        builderUsage()
        factoryUsage()
    }

    private fun observerUsage() {

        print("///////////////*********** OBSERVER DESIGN PATTERN STARTED***********///////////////")
        val textView = TextView().apply {
            addListeners(PrintingTextChangedListener())
        }

        with(textView) {
            text = "Lorem ipsum"
            text = "dolor sit amet"
        }
        print("///////////////*********** OBSERVER DESIGN PATTERN ENDED ***********///////////////")
    }

    private fun singletonUsage() {
        print("///////////////*********** SINGLETON DESIGN PATTERN STARTED***********///////////////")
        Singleton.print()
        Singleton.print()
        print("///////////////*********** SINGLETON DESIGN PATTERN ENDED ***********///////////////")
    }

    private fun singletonUsage1() {
        print("///////////////*********** SINGLETON 1 DESIGN PATTERN STARTED***********///////////////")
        print(NetworkManager.getInstance().toString())
        print(NetworkManager.getInstance().toString())
        print(NetworkManager.getInstance().toString())
        print("///////////////*********** SINGLETON 1 DESIGN PATTERN ENDED ***********///////////////")
    }


    private fun builderUsage() {
        print("///////////////*********** BUILDER DESIGN PATTERN STARTED***********///////////////")

        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        //Using builder to get the object in a single line of code and
        //without any inconsistent state or arguments management issues
        val comp = ComputerBuilder(
            "500 GB", "2 GB"
        )
            .setBluetoothEnabled(true)
            .setGraphicsCardEnabled(true)
            .build()
        print("///////////////*********** BUILDER DESIGN PATTERN ENDED ***********///////////////")
    }

    private fun factoryUsage() {
        print("///////////////*********** FACTORY DESIGN PATTERN STARTED***********///////////////")

        val server = ComputerFactory.getComputer(SYSTEM.SERVER)
        val pc = ComputerFactory.getComputer(SYSTEM.PC)

        print("///////////////*********** FACTORY DESIGN PATTERN ENDED ***********///////////////")
    }
}