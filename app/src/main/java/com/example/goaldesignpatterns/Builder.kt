package com.example.goaldesignpatterns

class Computer {

    private var HDD: String? = null
    private var RAM: String? = null

    //optional parameters
    private var isGraphicsCardEnabled = false
    private var isBluetoothEnabled = false

    constructor(builder: ComputerBuilder) {
        HDD = builder.getHDD()
        RAM = builder.getRAM()

        isGraphicsCardEnabled = builder.getGraphicsCardEnabled()
        isBluetoothEnabled = builder.getBluetoothEnabled()
    }

    //Builder Class
    class ComputerBuilder(// required parameters
        private val HDD: String,
        private val RAM: String
    ) {
        // optional parameters
        private var isGraphicsCardEnabled = false
        private var isBluetoothEnabled = false
        fun setGraphicsCardEnabled(isGraphicsCardEnabled: Boolean): ComputerBuilder {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled
            return this
        }

        fun setBluetoothEnabled(isBluetoothEnabled: Boolean): ComputerBuilder {
            this.isBluetoothEnabled = isBluetoothEnabled
            return this
        }

        fun getGraphicsCardEnabled(): Boolean {
            return isGraphicsCardEnabled
        }

        fun getBluetoothEnabled(): Boolean {
            return isBluetoothEnabled
        }


        fun getHDD(): String = HDD
        fun getRAM(): String = RAM

        fun build(): Computer {
            return Computer(this)
        }
    }
}